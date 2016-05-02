
package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.dao.factory.DaoFactory;
import br.com.wns.projetoloja.dao.interfaces.ICidadeDao;
import br.com.wns.projetoloja.dao.interfaces.IEnderecoDao;
import br.com.wns.projetoloja.model.Endereco;
import br.com.wns.projetoloja.util.ConnectionFactory;
import br.com.wns.projetoloja.util.PropertiesUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao extends DaoGeneric implements IEnderecoDao{
    private ICidadeDao iDaoCidade = null;
    public long inserir (Endereco endereco) throws Exception{
        try{
            
            String sqlEndereco = "INSERT INTO enderecos (rua, numero, bairro, cep, id_cidade) values (?,?,?,?,?)";            
            PreparedStatement psEndereco = getConnection().prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            psEndereco.setString(1, endereco.getRua());
            psEndereco.setString(2, endereco.getNumero());
            psEndereco.setString(3, endereco.getBairro());
            psEndereco.setString(4, endereco.getCep());
            psEndereco.setLong(5, endereco.getCidade().getId());
            psEndereco.executeUpdate();
            ResultSet rsEndereco = psEndereco.getGeneratedKeys();
            long id = 0;
            if(rsEndereco.next()){
                id = rsEndereco.getLong(1);
            }
            this.getConnection().commit();
            this.closeConnection();
            return id;
            
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_SALVAR));
        }
    }
    
    public void alterar (Endereco endereco) throws Exception{
        try{
            
            String sqlEndereco = "UPDATE enderecos SET rua = ?, numero = ?, bairro = ?, cep = ?, id_cidade = ? WHERE id = ?";
            PreparedStatement psEndereco = getConnection().prepareStatement(sqlEndereco);
            psEndereco.setString(1, endereco.getRua());
            psEndereco.setString(2, endereco.getNumero());
            psEndereco.setString(3, endereco.getBairro());
            psEndereco.setString(4, endereco.getCep());
            psEndereco.setLong(5, endereco.getCidade().getId());
            psEndereco.setLong(6, endereco.getId());
            psEndereco.executeUpdate();
            this.getConnection().commit();
            this.closeConnection();
            
        }catch(Exception e){
           this.getConnection().rollback();
           e.printStackTrace();
           throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_ALTERAR));
        } 
    }
    
    public void excluir (Endereco endereco) throws Exception{
        try{
            
            String sqlEndereco = " DELETE FROM enderecos WHERE id = ?";
            PreparedStatement psEndereco = getConnection().prepareStatement(sqlEndereco);
            psEndereco.setLong(1, endereco.getId());
            psEndereco.executeUpdate();
            this.getConnection().commit();
            this.closeConnection();
            
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_EXCLUIR));
        }
    }
    
    public Endereco buscar(long id) throws Exception{
        try{
            Endereco endereco = null;
            String sqlEndereco = "SELECT * FROM enderecos WHERE id = ?";
            PreparedStatement psEndereco = getConnection().prepareStatement(sqlEndereco);
            psEndereco.setLong(1, id);
            ResultSet rsEndereco = psEndereco.executeQuery();
            if(rsEndereco.next()){
                endereco = new Endereco();
                iDaoCidade = DaoFactory.createCidadeDao();
                endereco.setId(rsEndereco.getLong("id"));
                endereco.setRua(rsEndereco.getString("rua"));
                endereco.setNumero(rsEndereco.getString("numero"));
                endereco.setBairro(rsEndereco.getString("bairro"));
                endereco.setCep(rsEndereco.getString("cep"));
                endereco.setCidade(iDaoCidade.buscar(rsEndereco.getInt("id_cidade")));
            }
           this.closeConnection();
            return endereco;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        }
    }
    
    public List<Endereco> listar() throws Exception{
         List<Endereco> enderecos = null;
        try{
            Endereco endereco = null;
            enderecos = new ArrayList<>();
            String sqlEndereco = "SELECT * FROM enderecos";
            PreparedStatement psEndereco = getConnection().prepareStatement(sqlEndereco);
            ResultSet rsEndereco = psEndereco.executeQuery();
            while(rsEndereco.next()){
                endereco = new Endereco();
                iDaoCidade = DaoFactory.createCidadeDao();
                endereco.setId(rsEndereco.getLong("id"));
                endereco.setRua(rsEndereco.getString("rua"));
                endereco.setNumero(rsEndereco.getString("numero"));
                endereco.setBairro(rsEndereco.getString("bairro"));
                endereco.setCep(rsEndereco.getString("cep"));
                endereco.setCidade(iDaoCidade.buscar(rsEndereco.getInt("id_cidade")));
                enderecos.add(endereco);
            }
            this.closeConnection();
            return enderecos;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LISTAR));
        }
    }

    public void limpar() throws Exception {
         try{
             
             String sqlFuncionario = "DELETE FROM enderecos"; 
             PreparedStatement psFuncionario = getConnection().prepareStatement(sqlFuncionario);
             psFuncionario.executeUpdate();
             this.getConnection().commit();
             this.closeConnection();
             
        }catch(Exception e){
             this.getConnection().rollback();
             e.printStackTrace();
             throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LIMPAR));
         }  
    }
}
