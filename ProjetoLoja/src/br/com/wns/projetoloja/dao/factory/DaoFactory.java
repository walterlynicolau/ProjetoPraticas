
package br.com.wns.projetoloja.dao.factory;

import br.com.wns.projetoloja.dao.impl.CategoriaDao;
import br.com.wns.projetoloja.dao.impl.CidadeDao;
import br.com.wns.projetoloja.dao.impl.ClienteDao;
import br.com.wns.projetoloja.dao.impl.ContatoDao;
import br.com.wns.projetoloja.dao.impl.EnderecoDao;
import br.com.wns.projetoloja.dao.impl.EstadoDao;
import br.com.wns.projetoloja.dao.impl.FuncionarioDao;
import br.com.wns.projetoloja.dao.impl.PessoaDao;
import br.com.wns.projetoloja.dao.impl.ProdutoDao;
import br.com.wns.projetoloja.dao.interfaces.ICategoriaDao;
import br.com.wns.projetoloja.dao.interfaces.ICidadeDao;
import br.com.wns.projetoloja.dao.interfaces.IClienteDao;
import br.com.wns.projetoloja.dao.interfaces.IContatoDao;
import br.com.wns.projetoloja.dao.interfaces.IEnderecoDao;
import br.com.wns.projetoloja.dao.interfaces.IEstadoDao;
import br.com.wns.projetoloja.dao.interfaces.IFuncionarioDao;
import br.com.wns.projetoloja.dao.interfaces.IPessoaDao;
import br.com.wns.projetoloja.dao.interfaces.IProdutoDao;

public class DaoFactory {
   
    public static IFuncionarioDao createFuncionarioDao() {
       return  new FuncionarioDao(); 
    } 
    public static IClienteDao createClienteDao() {
       return  new ClienteDao(); 
    }
    public static IPessoaDao createPessoaDao() {
       return  new PessoaDao(); 
    } 
    public static IEnderecoDao createEnderecoDao() {
       return  new EnderecoDao(); 
    } 
    public static IContatoDao createContatoDao() {
       return  new ContatoDao(); 
    } 
    public static ICidadeDao createCidadeDao() {
       return  new CidadeDao(); 
    } 
    public static IEstadoDao createEstadoDao() {
       return  new EstadoDao(); 
    } 
    public static IProdutoDao createProdutoDao() {
       return  new ProdutoDao(); 
    } 
    public static ICategoriaDao createCategoriaDao() {
       return  new CategoriaDao(); 
    } 
}
