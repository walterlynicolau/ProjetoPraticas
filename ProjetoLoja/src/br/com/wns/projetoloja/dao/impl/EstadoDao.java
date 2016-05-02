
package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.dao.interfaces.IEstadoDao;
import br.com.wns.projetoloja.model.Estado;
import br.com.wns.projetoloja.util.ConnectionFactory;
import br.com.wns.projetoloja.util.PropertiesUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadoDao extends DaoGeneric implements IEstadoDao{
    
    public void inserir(Estado estado) throws Exception{
        try{
            String sqlEstado = "INSERT INTO estados (nome, uf) values (?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sqlEstado, Statement.RETURN_GENERATED_KEYS);   
            ps.setString(1, estado.getNome());
            ps.setString(2, estado.getUf());
            ps.executeUpdate();
            ResultSet rsEstado = ps.getGeneratedKeys();
            long id = 0;
            if (rsEstado.next()){
               id = rsEstado.getLong(1);
            }
            this.getConnection().commit();
            this.closeConnection();
            //return id;
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_SALVAR));   
        }   
    }
    
    public void alterar (Estado estado) throws Exception{
        try{
            
            String sqlEstado = "UPDATE estados SET nome = ?, uf = ? WHERE id = ?";
            PreparedStatement psEstado = getConnection().prepareStatement(sqlEstado);
            psEstado.setString(1, estado.getNome());
            psEstado.setString(2, estado.getUf());
            psEstado.setLong(3, estado.getId());
            psEstado.executeUpdate();
            this.getConnection().commit();
            this.closeConnection();
            
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_ALTERAR));
        }
    }
    
    public void excluir (Estado estado) throws Exception{
        try{
            
            String sqlEstado = "DELETE FROM estados WHERE id = ?";
            PreparedStatement psEstado = getConnection().prepareStatement(sqlEstado, Statement.RETURN_GENERATED_KEYS);
            psEstado.setLong(1, estado.getId());
            psEstado.executeUpdate();
            this.getConnection().commit();
            this.closeConnection();
            
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_EXCLUIR));
        }
    }
    
    public Estado buscar(long id) throws Exception{
        try{
            
            Estado estado = null;
            String sqlEstado = "SELECT * FROM estados WHERE id = ?";
            PreparedStatement psEstado = getConnection().prepareStatement(sqlEstado);
            psEstado.setLong(1, id);
            ResultSet rs = psEstado.executeQuery();
            if(rs.next()){
                estado = new Estado();
                estado.setId(rs.getLong("id"));
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("uf"));
            }
            
            this.closeConnection();
            return estado;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        }
    }
    
    public List<Estado> listar() throws Exception{
        List<Estado> estados = null;
        try{
            
            Estado estado = null;
            estados = new ArrayList<>();
            String sqlEstado = "SELECT * FROM estados";
            PreparedStatement psEstado = getConnection().prepareStatement(sqlEstado);
            ResultSet rsEstado = psEstado.executeQuery();
            while(rsEstado.next()){
                estado = new Estado();
                estado.setId(rsEstado.getLong("id"));
                estado.setNome(rsEstado.getString("nome"));
                estado.setUf(rsEstado.getString("uf"));
                estados.add(estado);
            }
            this.closeConnection();
            return estados;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LISTAR));
        }
    }

}

