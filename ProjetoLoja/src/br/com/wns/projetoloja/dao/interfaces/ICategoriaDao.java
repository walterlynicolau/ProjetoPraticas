
package br.com.wns.projetoloja.dao.interfaces;

import br.com.wns.projetoloja.model.Categoria;
import java.util.List;

public interface ICategoriaDao {
    
     public long inserir(Categoria categoria)throws Exception;
     
     public void alterar(Categoria categoria)throws Exception;
     
     public void excluir(Categoria categoria)throws Exception;
     
     public Categoria buscar(long id)throws Exception;
     
     public List<Categoria> listar()  throws Exception;
     
     public void limpar () throws Exception;
}
