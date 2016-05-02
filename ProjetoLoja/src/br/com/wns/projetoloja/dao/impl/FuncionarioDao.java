
package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.dao.factory.DaoFactory;
import br.com.wns.projetoloja.dao.interfaces.IFuncionarioDao;
import br.com.wns.projetoloja.dao.interfaces.IPessoaDao;
import br.com.wns.projetoloja.model.Funcionario;
import br.com.wns.projetoloja.model.Pessoa;
import br.com.wns.projetoloja.util.ConnectionFactory;
import br.com.wns.projetoloja.util.PropertiesUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDao extends DaoGeneric implements IFuncionarioDao{
   
    private IPessoaDao iDaoPessoa = null;

    public void inserir(Funcionario funcionario)throws Exception{
     try{
            iDaoPessoa = DaoFactory.createPessoaDao();//usa o Daofactory?? ou a Facade????
            long idFuncionario = iDaoPessoa.inserir(funcionario);
            String sqlFuncionario = "INSERT INTO funcionarios (matricula, salario, id_funcionario) values(?,?,?)";
            PreparedStatement psFuncionario = getConnection().prepareStatement(sqlFuncionario);
            psFuncionario.setString(1, funcionario.getMatricula());
            psFuncionario.setString(2, funcionario.getSalario());
            psFuncionario.setLong(3, idFuncionario);
            psFuncionario.executeUpdate();
            this.getConnection().commit();
            this.closeConnection();
            
        }catch(Exception e){
         this.getConnection().rollback();
         e.printStackTrace();
         throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_SALVAR));
     }
    }
     
    
    
     public void alterar(Funcionario funcionario)   throws Exception {
        try{
            
               String sqlFuncionario = " UPDATE funcionarios SET matricula = ?, salario = ? WHERE id_funcionario = ?";
               PreparedStatement psFuncionario = getConnection().prepareStatement(sqlFuncionario);
                psFuncionario.setString(1, funcionario.getMatricula());
                psFuncionario.setString(2, funcionario.getSalario());
                psFuncionario.setLong(3, funcionario.getId());
                psFuncionario.executeUpdate();
                iDaoPessoa = DaoFactory.createPessoaDao();
                iDaoPessoa.alterar(funcionario);
               this.getConnection().commit();
               this.closeConnection();
               
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_ALTERAR));
        }
    }
    
     public void excluir(Funcionario funcionario)   throws Exception {

        try{
        
                String sqlFuncionario = "DELETE FROM funcionarios WHERE id_funcionario = ?";
                PreparedStatement psFuncionario = getConnection().prepareStatement(sqlFuncionario);
                psFuncionario.setLong(1, funcionario.getId());
                psFuncionario.executeUpdate();
               this.getConnection().commit();
               this.closeConnection();
               iDaoPessoa = DaoFactory.createPessoaDao();
               iDaoPessoa.excluir(funcionario);
        }catch(Exception e){
            this.getConnection().rollback();
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_EXCLUIR));
        }
    }
     
     
     public Funcionario buscar(long id)   throws Exception {
        try{
            Funcionario funcionario = null;
            String sqlFuncionario = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
            PreparedStatement psFuncionario = getConnection().prepareStatement(sqlFuncionario);
            psFuncionario.setLong(1, id);
            ResultSet rsFuncionario = psFuncionario.executeQuery();
            if(rsFuncionario.next()){
             funcionario = new Funcionario();
             iDaoPessoa = DaoFactory.createPessoaDao();
             Pessoa pessoa = iDaoPessoa.buscar(id);
             funcionario.setId(rsFuncionario.getInt("id_funcionario"));
             funcionario.setMatricula(rsFuncionario.getString("matricula"));
             funcionario.setSalario(rsFuncionario.getString("salario"));
             funcionario.setNome(pessoa.getNome());
             funcionario.setCpf(pessoa.getCpf());
             funcionario.setRg(pessoa.getRg());
             funcionario.setSexo(pessoa.getSexo());
             funcionario.setDataNascimento(pessoa.getDataNascimento());
             funcionario.setContato(pessoa.getContato());
             funcionario.setEndereco(pessoa.getEndereco());
            }
            this.getConnection().close();
            return funcionario;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_BUSCAR));
        }
    }
     
     public List<Funcionario> listar()  throws Exception{
         List <Funcionario> funcionarios = null;
          try{
              
              funcionarios = new ArrayList<>();
              Funcionario funcionario = null;
              String sqlFuncionario = "SELECT * FROM funcionarios";
              PreparedStatement psFuncionario = getConnection().prepareStatement(sqlFuncionario);
              ResultSet rsFuncionario = psFuncionario.executeQuery();
              while(rsFuncionario.next()){
                  funcionario = new Funcionario();
                  iDaoPessoa = DaoFactory.createPessoaDao();
                  Pessoa pessoa = iDaoPessoa.buscar(rsFuncionario.getInt("id_funcionario"));
                  funcionario.setId(rsFuncionario.getInt("id_funcionario"));
                  funcionario.setMatricula(rsFuncionario.getString("matricula"));
                  funcionario.setSalario(rsFuncionario.getString("salario"));
                  funcionario.setNome(pessoa.getNome());
                  funcionario.setCpf(pessoa.getCpf());
                  funcionario.setRg(pessoa.getRg());
                  funcionario.setSexo(pessoa.getSexo());
                  funcionario.setDataNascimento(pessoa.getDataNascimento());
                  funcionario.setContato(pessoa.getContato());
                  funcionario.setEndereco(pessoa.getEndereco());
                  funcionarios.add(funcionario);
               }
              this.getConnection().close();
              return funcionarios;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LISTAR));
        }
    }
     
     public void limpar () throws Exception {
         try{
             String sqlFuncionario = "DELETE FROM funcionarios"; 
             PreparedStatement psFuncionario = getConnection().prepareStatement(sqlFuncionario);
             psFuncionario.executeUpdate();
            
            // iDaoPessoa = DaoFactory.createPessoaDao();
             //iDaoPessoa.limpar();
              this.getConnection().commit();
             this.closeConnection();
        }catch(Exception e){
             this.getConnection().rollback();
             e.printStackTrace();
             throw new Exception(PropertiesUtil.getStringsValue(PropertiesUtil.MSG_ERRO_LIMPAR));
         }  
     }
          
}
