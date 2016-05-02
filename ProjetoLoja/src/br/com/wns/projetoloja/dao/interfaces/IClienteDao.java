
package br.com.wns.projetoloja.dao.interfaces;

import br.com.wns.projetoloja.model.Cliente;
import java.util.List;

public interface IClienteDao {
    
     public void inserirCliente(Cliente cliente)throws Exception;
     
     public void excluirCliente(Cliente cliente)throws Exception;
     
     public Cliente buscarCliente(long id)throws Exception;
     
     public void alterarCliente(Cliente cliente)throws Exception;
     
     public List<Cliente> listarCliente()  throws Exception;
}
