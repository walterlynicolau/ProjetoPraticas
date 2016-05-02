
package br.com.wns.projetoloja.dao.interfaces;

import br.com.wns.projetoloja.model.Pessoa;
import java.util.List;

public interface IPessoaDao {
    
     public long inserir(Pessoa pessoa)throws Exception;
     
     public void alterar(Pessoa pessoa)throws Exception;
     
     public void excluir(Pessoa pessoa)throws Exception;
     
     public Pessoa buscar(long id)throws Exception;
     
     public List<Pessoa> listar()  throws Exception;
     
     public void limpar () throws Exception;
    
}
