
package br.com.wns.projetoloja.dao.interfaces;

import br.com.wns.projetoloja.model.Produto;
import java.util.List;


public interface IProdutoDao {
    
     public void inserir(Produto produto)throws Exception;
     
     public void alterar(Produto produto)throws Exception;
     
     public void excluir(Produto produto)throws Exception;
     
     public Produto buscar(long id)throws Exception;
     
     public List<Produto> listar()  throws Exception;
     
     public void limpar () throws Exception;
}
