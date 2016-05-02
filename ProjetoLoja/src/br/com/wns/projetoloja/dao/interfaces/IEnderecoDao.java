
package br.com.wns.projetoloja.dao.interfaces;

import br.com.wns.projetoloja.model.Endereco;
import java.util.List;

public interface IEnderecoDao {
    
     public long inserir(Endereco endereco)throws Exception;
     
     public void alterar(Endereco endereco)throws Exception;
     
     public void excluir(Endereco endereco)throws Exception;
     
     public Endereco buscar(long id)throws Exception;
     
     public List<Endereco> listar()  throws Exception;
     
     public void limpar () throws Exception;
}
