package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.dao.factory.DaoFactory;
import br.com.wns.projetoloja.dao.interfaces.IClienteDao;
import br.com.wns.projetoloja.dao.interfaces.IPessoaDao;
import br.com.wns.projetoloja.model.Cliente;
import br.com.wns.projetoloja.util.PropertiesUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends DaoGeneric implements IClienteDao{
    private IPessoaDao iDaoPessoa;
    public void inserirCliente(Cliente cliente) throws Exception {
        
        try {
            //ok
            iDaoPessoa = DaoFactory.createPessoaDao();
            long id = iDaoPessoa.inserir(cliente);
            
            String sqlCliente = "INSERT INTO clientes (idcliente,tipocliente) VALUES (?,?)";
            PreparedStatement psCliente = this.getConnection().prepareStatement(sqlCliente);
            
            psCliente.setLong(1, id);
            psCliente.setString(2, cliente.getTipoCliente());
            
            psCliente.executeUpdate();
            this.getConnection().commit();
            this.closeConnection();
            
        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_SALVAR));
        }
    }

    public void excluirCliente(Cliente cliente) throws Exception {

        try {
            //ok
            String sqlCliente = "DELETE FROM clientes WHERE idcliente = ?";
            PreparedStatement psCliente = this.getConnection().prepareStatement(sqlCliente);
            
            psCliente.setLong(1, cliente.getIdClente());
            
            iDaoPessoa = DaoFactory.createPessoaDao();
            iDaoPessoa.excluir(cliente);
            
            this.getConnection().commit();
            this.closeConnection();
        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_EXCLUIR));
        }
    }

    public Cliente buscarCliente(long id) throws Exception {

        try {
            //ok
            Cliente cliente = null;
            
            String sql = "SELECT * FROM clientes WHERE idcliente = ?";
            PreparedStatement st = this.getConnection().prepareStatement(sql);
            st.setLong(1, id);

            ResultSet rsCliente = st.executeQuery();

            if (rsCliente.next()) {
                cliente = new Cliente();
                cliente.setId(rsCliente.getLong("idcliente"));
                cliente.setTipoCliente(rsCliente.getString("tipocliente"));
            }
            this.getConnection().commit();
            this.closeConnection();
            
            return cliente;
            
        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        }
    }

    public void alterarCliente(Cliente cliente) throws Exception {
        try {
            //ok
            String sql = "UPDATE clientes SET tipocliente = ? WHERE idcliente = ?";
            PreparedStatement st = this.getConnection().prepareStatement(sql);

            st.setString(1, cliente.getTipoCliente());
            st.setLong(2, cliente.getIdClente());
            
            st.executeUpdate();
            iDaoPessoa = DaoFactory.createPessoaDao();
            iDaoPessoa.alterar(cliente);
            
            this.getConnection().commit();
            this.closeConnection();
        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_ALTERAR));
        }
    }

    public List<Cliente> listarCliente() throws Exception {

        try {
            //ok
            List<Cliente> listaClientes = new ArrayList<>();
            String sql = "SELECT * FROM clientes";
            PreparedStatement st = this.getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdClente(rs.getLong("idcliente"));
                cliente.setTipoCliente(rs.getString("tipocliente"));
                
                listaClientes.add(cliente);
            }
            this.getConnection().commit();
            this.closeConnection();
            return listaClientes;
            
        } catch (Exception e) {
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LISTAR));
        }
    }
    
     public void limparCliente () throws Exception {
         try{
             String sqlCliente = "DELETE FROM clientes"; 
             PreparedStatement psCliente = getConnection().prepareStatement(sqlCliente);
             psCliente.executeUpdate();
             this.getConnection().commit();
             this.closeConnection();
        }catch(Exception e){
             this.getConnection().rollback();
             e.printStackTrace();
             throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LIMPAR));
         }  
     }
}
