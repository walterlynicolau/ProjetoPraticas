
package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.dao.interfaces.ICategoriaDao;
import br.com.wns.projetoloja.model.Categoria;
import br.com.wns.projetoloja.util.PropertiesUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDao extends DaoGeneric implements ICategoriaDao{

    public long inserir(Categoria categoria) throws Exception {
        try{ 
            String sqlCategoria = "INSERT INTO categorias(nome) VALUES (?)";
            PreparedStatement psCategoria = getConnection().prepareStatement(sqlCategoria, Statement.RETURN_GENERATED_KEYS);
            psCategoria.setString(1, categoria.getNome());
            psCategoria.executeUpdate();
            ResultSet rsCategoria =  psCategoria.getGeneratedKeys();
            long id = 0;
            if(rsCategoria.next()){
                id = rsCategoria.getLong(1);
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

    
    public void alterar(Categoria categoria) throws Exception {
        try{
           String sqlCategoria = "UPDATE categorias SET nome = ? WHERE id = ?";
           PreparedStatement psCategoria = getConnection().prepareStatement(sqlCategoria);
           psCategoria.setString(1, categoria.getNome());
           psCategoria.setLong(2, categoria.getId());
           psCategoria.executeUpdate();
           this.getConnection().commit();
           this.closeConnection();
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_ALTERAR));
        } 
    }

   
    public void excluir(Categoria categoria) throws Exception {
        try{
            String sqlCategoria = "DELETE FROM categorias WHERE id = ?";
            PreparedStatement psCategoria = getConnection().prepareStatement(sqlCategoria);
            psCategoria.setLong(1, categoria.getId());
            psCategoria.executeUpdate();
            this.getConnection().commit();
            this.closeConnection();
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_EXCLUIR));
        } 
    }

    public Categoria buscar(long id) throws Exception {
        try{
            Categoria categoria = null;
            String sqlCategoria = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement psCategoria = getConnection().prepareStatement(sqlCategoria);
            psCategoria.setLong(1, id);
            ResultSet rsCategoria = psCategoria.executeQuery();
            if(rsCategoria.next()){
                categoria = new Categoria();
                categoria.setId(rsCategoria.getLong("id"));
                categoria.setNome(rsCategoria.getString("nome"));
            }
            this.closeConnection();
            return categoria;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        } 
    }

   
    public List<Categoria> listar() throws Exception {
        List<Categoria> categorias = null; 
        try{
            Categoria categoria = null;
            categorias = new ArrayList<Categoria>();
            String sqlCategoria = "SELECT * FROM categorias";
            PreparedStatement psCategoria = getConnection().prepareStatement(sqlCategoria);
            ResultSet rsCategoria = psCategoria.executeQuery();
            while(rsCategoria.next()){
                categoria = new Categoria();
                categoria.setId(rsCategoria.getLong("id"));
                categoria.setNome(rsCategoria.getString("nome"));
                categorias.add(categoria);
            }
            this.closeConnection();
            return categorias;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LISTAR));
        } 
    }

    
    public void limpar() throws Exception {
        try{
             String sqlCategoria = "DELETE FROM categorias"; 
             PreparedStatement psCategoria = getConnection().prepareStatement(sqlCategoria);
             psCategoria.executeUpdate();
             this.getConnection().commit();
             this.closeConnection();
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LIMPAR));
        } 
    }
    
    
}
