
package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.dao.factory.DaoFactory;
import br.com.wns.projetoloja.dao.interfaces.ICategoriaDao;
import br.com.wns.projetoloja.dao.interfaces.IProdutoDao;
import br.com.wns.projetoloja.model.Produto;
import br.com.wns.projetoloja.util.PropertiesUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends DaoGeneric implements IProdutoDao{
    private ICategoriaDao iDaoCategoria = null;
    
    public void inserir(Produto produto) throws Exception {
        try {
            //okk
            iDaoCategoria = DaoFactory.createCategoriaDao();
            long id = iDaoCategoria.inserir(categoria);
            
            String sql = "INSERT INTO Produtos (nomeproduto, codigoproduto, valor,idcategoria) VALUES (?,?,?,?)";
            
            PreparedStatement st = this.getConnection().prepareStatement(sql);
            
            st.setString(2, produto.getNome());
            st.setString(1, produto.getCodigo()); 
            st.setString(3, produto.getValor());
            st.setLong(4, produto.getCategoria().getId());
        
            st.executeUpdate();
            this.getConnection().commit();
            this.getConnection().close();

        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_SALVAR));
        }
    }

    public void alterar(Produto produto) throws Exception {
        try {
            //okk
            String sqlProduto = "UPDATE Produtos SET nomeproduto = ?, codigoproduto = ?, valor = ? WHERE idproduto = ?";
            PreparedStatement st = this.getConnection().prepareStatement(sqlProduto);
            
            st.setString(2, produto.getNome());
            st.setString(1, produto.getCodigo());
            st.setString(3, produto.getValor());
            
            st.setLong(4, produto.getId());
            st.executeUpdate();
            System.out.println("chego no metodo");
            this.getConnection().commit();
            this.getConnection().close();

        }
            catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_ALTERAR));
        }
    }


    public Produto buscar(long id) throws Exception{
       try {
            //ok
            Produto produto = null;
            
            String sql = "SELECT * FROM produtos WHERE idproduto = ?";

            PreparedStatement st = this.getConnection().prepareStatement(sql);
            
            st.setLong(1, id);
         
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                
                produto = new Produto();
                
                produto.setId(rs.getLong("idproduto"));
                produto.setNome(rs.getString("nomeproduto"));
                produto.setCodigo(rs.getString("codigoproduto"));
                produto.setValor(rs.getString("valor"));
            }
            
            this.getConnection().commit();
            this.getConnection().close();
            
            return produto;

        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        }
    }
    
    public void excluir(Produto produto) throws Exception {
        try {
            //ok
            String sql = "DELETE FROM Produtos WHERE idproduto = ?";

            PreparedStatement st = this.getConnection().prepareStatement(sql);
            
            st.setLong(1, produto.getId());

            st.executeUpdate();

            this.getConnection().commit();
            this.getConnection().close();

        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_EXCLUIR));
        }
    }

    public List<Produto> listar() throws Exception {
        try {
            //okk
            List<Produto> lista = new ArrayList<Produto>();
            
            String sqlProduto = "SELECT * FROM produtos";

            
            PreparedStatement st = this.getConnection().prepareStatement(sqlProduto);
            
           
            ResultSet rsProduto = st.executeQuery();

            while(rsProduto.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rsProduto.getLong("idproduto"));
                produto.setCodigo(rsProduto.getString("codigoproduto"));
                produto.setNome(rsProduto.getString("nomeproduto"));
                produto.setValor(rsProduto.getString("valor"));
                
                lista.add(produto);
            }
            this.getConnection().commit();
            this.getConnection().close();
 
            return lista;

        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LISTAR));
        }
    }

    @Override
    public void limpar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}