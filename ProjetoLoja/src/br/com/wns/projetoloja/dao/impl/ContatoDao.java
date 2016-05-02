
package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.dao.interfaces.IContatoDao;
import br.com.wns.projetoloja.model.Contato;
import br.com.wns.projetoloja.util.ConnectionFactory;
import br.com.wns.projetoloja.util.PropertiesUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ContatoDao extends DaoGeneric implements IContatoDao{
    
    public long inserir(Contato contato) throws Exception{
        try{
           
          String sqlContato = "INSERT INTO contatos (telefone_celular, telefone_fixo, email_1, email_2) values(?,?,?,?)";
          PreparedStatement psContato = getConnection().prepareStatement(sqlContato, Statement.RETURN_GENERATED_KEYS);
          psContato.setString(1, contato.getTelefoneCelular());
          psContato.setString(2, contato.getTelefoneFixo());
          psContato.setString(3, contato.getEmail1());
          psContato.setString(4, contato.getEmail2());
          psContato.executeUpdate();
          ResultSet rsContato = psContato.getGeneratedKeys();
          long id = 0;
          if(rsContato.next()){
              id = rsContato.getLong(1);
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
    
    public void alterar (Contato contato) throws Exception{
        try{
            
            String sqlContato = "UPDATE contatos SET telefone_celular = ?, telefone_fixo = ?, email_1 = ?, email_2 = ? WHERE id = ?";
            PreparedStatement psContato = getConnection().prepareStatement(sqlContato);
            psContato.setString(1, contato.getTelefoneCelular());
            psContato.setString(2, contato.getTelefoneFixo());
            psContato.setString(3, contato.getEmail1());
            psContato.setString(4, contato.getEmail2());
            psContato.setLong(5, contato.getId());
            psContato.executeUpdate();
           this.getConnection().commit();
           this.closeConnection();
            
        }catch(Exception e){
          this.getConnection().rollback();
          e.printStackTrace();
          throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_ALTERAR));
        }
    }
    
    public void excluir (Contato contato) throws Exception{
        try{
            
            String sqlContato = "DELETE FROM contatos WHERE id = ?";
            PreparedStatement psContato = getConnection().prepareStatement(sqlContato);
            psContato.setLong(1, contato.getId());
            psContato.executeUpdate();
            this.getConnection().commit();
            this.closeConnection();
            
        }catch(Exception e){
          this.getConnection().rollback();
          e.printStackTrace();
          throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_EXCLUIR));
        }
    }
    
    public Contato buscar(long id) throws Exception{
        try{
            Contato contato = null;
            String sqlContato = "SELECT * FROM contatos WHERE id = ?";
            PreparedStatement psEndereco = getConnection().prepareStatement(sqlContato);
            psEndereco.setLong(1, id);
            ResultSet rsEndereco = psEndereco.executeQuery();
            if(rsEndereco.next()){
                contato = new Contato();
                contato.setId(rsEndereco.getLong("id"));
                contato.setTelefoneCelular(rsEndereco.getString("telefone_celular"));
                contato.setTelefoneFixo(rsEndereco.getString("telefone_fixo"));
                contato.setEmail1(rsEndereco.getString("email_1"));
                contato.setEmail2(rsEndereco.getString("email_2"));
            }
            this.closeConnection();
            return contato;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        }
    }
    
    public List<Contato> listar() throws Exception{
        List<Contato> contatos = null;
        try{
            
            Contato contato = null;
            contatos = new ArrayList<>();
            String sqlContato = "SELECT * FROM contatos";
            PreparedStatement psEndereco = getConnection().prepareStatement(sqlContato);
            ResultSet rsEndereco = psEndereco.executeQuery();
            while(rsEndereco.next()){
                contato = new Contato();
                contato.setId(rsEndereco.getLong("id"));
                contato.setTelefoneCelular(rsEndereco.getString("telefone_celular"));
                contato.setTelefoneFixo(rsEndereco.getString("telefone_fixo"));
                contato.setEmail1(rsEndereco.getString("email_1"));
                contato.setEmail2(rsEndereco.getString("email_2"));
                contatos.add(contato);
            }
            this.closeConnection();
            return contatos;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LISTAR));
        }
    }

    public void limpar() throws Exception {
         try{
             
             String sqlFuncionario = "DELETE FROM contatos"; 
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
