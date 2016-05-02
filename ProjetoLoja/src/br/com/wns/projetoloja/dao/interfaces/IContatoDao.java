
package br.com.wns.projetoloja.dao.interfaces;


import br.com.wns.projetoloja.model.Contato;
import java.util.List;

public interface IContatoDao {
   
     public long inserir(Contato contato)throws Exception;
     
     public void alterar(Contato contato)throws Exception;
     
     public void excluir(Contato contato)throws Exception;
     
     public Contato buscar(long id)throws Exception;
     
     public List<Contato> listar()  throws Exception;
     
     public void limpar () throws Exception;
}
