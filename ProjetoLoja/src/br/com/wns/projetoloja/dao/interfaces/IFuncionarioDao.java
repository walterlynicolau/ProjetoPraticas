
package br.com.wns.projetoloja.dao.interfaces;

import br.com.wns.projetoloja.model.Funcionario;
import java.util.List;

public interface IFuncionarioDao {
    
     public void inserir(Funcionario funcionario)throws Exception;
     
     public void alterar(Funcionario funcionario)throws Exception;
     
     public void excluir(Funcionario funcionario)throws Exception;
     
     public Funcionario buscar(long id)throws Exception;
     
     public List<Funcionario> listar()  throws Exception;
     
     public void limpar () throws Exception;
}
