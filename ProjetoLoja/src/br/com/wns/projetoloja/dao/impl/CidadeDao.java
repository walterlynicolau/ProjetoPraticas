
package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.dao.factory.DaoFactory;
import br.com.wns.projetoloja.dao.interfaces.ICidadeDao;
import br.com.wns.projetoloja.dao.interfaces.IEstadoDao;
import br.com.wns.projetoloja.model.Cidade;
import br.com.wns.projetoloja.util.ConnectionFactory;
import br.com.wns.projetoloja.util.PropertiesUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CidadeDao extends DaoGeneric implements ICidadeDao{
     
      private IEstadoDao iDaoEstado = null;
    
    public void inserir (Cidade cidade) throws Exception{
        try{
            String sqlCidade = "INSERT INTO cidades (nome, id_Estado) values (?,?)";
            PreparedStatement psCidade = getConnection().prepareStatement(sqlCidade, Statement.RETURN_GENERATED_KEYS);
            psCidade.setString(1, cidade.getNome());
           // psCidade.setLong(2, idEstado);
            psCidade.executeUpdate();
            
           ResultSet rsCidade = psCidade.getGeneratedKeys();
           long id = 0;
           if(rsCidade.next()){
               id = rsCidade.getLong(1);
           }
            this.getConnection().commit();
            this.closeConnection();
            //return id;
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception (PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_SALVAR));
        } 
    } 
    
    public void alterar(Cidade cidade) throws Exception{
        try{
            String sqlCidade = "UPDATE cidades SET nome = ? WHERE id = ?";
            PreparedStatement psCidade = getConnection().prepareStatement(sqlCidade);
            psCidade.setString(1, cidade.getNome());
            psCidade.setLong(2, cidade.getId());
            
            psCidade.executeUpdate();
            ResultSet rsCidade = psCidade.getGeneratedKeys();
            long id = 0;
            if(rsCidade.next()){
                id = rsCidade.getInt(3);
            }
            cidade.getEstado().setId(id);
            iDaoEstado = DaoFactory.createEstadoDao();
            iDaoEstado.alterar(cidade.getEstado());//pode ser assim
            this.getConnection().commit();
            this.closeConnection();
            
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_ALTERAR)); 
        }
    }
    
     public void excluir (Cidade cidade) throws Exception{
        try{
            String sqlCidade = "DELETE FROM cidades WHERE id = ?";
            PreparedStatement psCidade = getConnection().prepareStatement(sqlCidade, Statement.RETURN_GENERATED_KEYS);
            psCidade.setLong(1, cidade.getId());
            psCidade.executeUpdate();
            ResultSet rsCidade =  psCidade.getGeneratedKeys();
            long id = 0;
            if(rsCidade.next()){
                id = rsCidade.getInt(3);
            }
            cidade.getEstado().setId(id);
            this.getConnection().commit();
            this.closeConnection();
            iDaoEstado = DaoFactory.createEstadoDao();
            iDaoEstado.excluir(cidade.getEstado());
            
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_EXCLUIR));
        }
    }
     public Cidade buscar(long id) throws Exception{
         try{
             Cidade cidade = null;
             String sqlCidade = "SELECT * FROM cidades WHERE id = ?";
             PreparedStatement psCidade = getConnection().prepareStatement(sqlCidade);
             psCidade.setLong(1, id);
             ResultSet rsCidade = psCidade.executeQuery();
             if(rsCidade.next()){
                 cidade = new Cidade();
                 iDaoEstado = DaoFactory.createEstadoDao();
                 cidade.setId(rsCidade.getLong("id"));
                 cidade.setNome(rsCidade.getString("nome"));
                 cidade.setEstado(iDaoEstado.buscar(rsCidade.getInt("id_estado")));
             }
             this.closeConnection();
             return cidade;
         }catch(Exception e){
             e.printStackTrace();
             throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_BUSCAR));
         }
     }
     
      public List<Cidade> listar() throws Exception{
          List<Cidade> cidades = null;
         try{
             Cidade cidade = null;
             cidades = new ArrayList<>();
             String sqlCidade = "SELECT * FROM cidades";
             PreparedStatement psCidade = getConnection().prepareStatement(sqlCidade);
             ResultSet rsCidade = psCidade.executeQuery();
             while(rsCidade.next()){
                 cidade = new Cidade();
                 iDaoEstado = DaoFactory.createEstadoDao();
                 cidade.setId(rsCidade.getLong("id"));
                 cidade.setNome(rsCidade.getString("nome"));
                 cidade.setEstado(iDaoEstado.buscar(rsCidade.getInt("id_estado")));
                 cidades.add(cidade);
             }
             this.getConnection().commit();
             this.closeConnection();
             return cidades;
             
         }catch(Exception e){
             this.getConnection().rollback();
             e.printStackTrace();
             throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LISTAR));
         }
     }
}
