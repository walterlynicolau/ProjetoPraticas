
package br.com.wns.projetoloja.dao.interfaces;

import br.com.wns.projetoloja.model.Estado;
import java.util.List;

public interface IEstadoDao {
    
     public void inserir(Estado estado)throws Exception;
     
     public void alterar(Estado estado)throws Exception;
     
     public void excluir(Estado estado)throws Exception;
     
     public Estado buscar(long id)throws Exception;
     
     public List<Estado> listar()  throws Exception;
}
