
package br.com.wns.projetoloja.dao.interfaces;


import br.com.wns.projetoloja.model.Cidade;
import java.util.List;

public interface ICidadeDao {
    
     public void inserir(Cidade cidade)throws Exception;
     
     public void alterar(Cidade cidade)throws Exception;
     
     public void excluir(Cidade cidade)throws Exception;
     
     public Cidade buscar(long id)throws Exception;
     
     public List<Cidade> listar()  throws Exception;
}
