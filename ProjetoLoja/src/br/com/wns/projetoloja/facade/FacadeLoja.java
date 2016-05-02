
package br.com.wns.projetoloja.facade;

import br.com.wns.projetoloja.dao.factory.DaoFactory;
import br.com.wns.projetoloja.dao.interfaces.ICategoriaDao;
import br.com.wns.projetoloja.dao.interfaces.ICidadeDao;
import br.com.wns.projetoloja.dao.interfaces.IClienteDao;
import br.com.wns.projetoloja.dao.interfaces.IContatoDao;
import br.com.wns.projetoloja.dao.interfaces.IEnderecoDao;
import br.com.wns.projetoloja.dao.interfaces.IEstadoDao;
import br.com.wns.projetoloja.dao.interfaces.IFuncionarioDao;
import br.com.wns.projetoloja.dao.interfaces.IPessoaDao;
import br.com.wns.projetoloja.dao.interfaces.IProdutoDao;
import br.com.wns.projetoloja.model.Categoria;
import br.com.wns.projetoloja.model.Cidade;
import br.com.wns.projetoloja.model.Cliente;
import br.com.wns.projetoloja.model.Endereco;
import br.com.wns.projetoloja.model.Estado;
import br.com.wns.projetoloja.model.Funcionario;
import br.com.wns.projetoloja.model.Pessoa;
import br.com.wns.projetoloja.model.Produto;
import java.util.List;

public class FacadeLoja {
      public IFuncionarioDao daoFuncionario;
      public IClienteDao daoCliente;
      public IPessoaDao daoPessoa;
      public IEnderecoDao daoEndereco;
      public IContatoDao daoContato;
      public ICidadeDao daoCidade;
      public IEstadoDao daoEstado;
      public IProdutoDao daoProduto;
      public ICategoriaDao daoCategoria;
    
    public FacadeLoja(){
        daoFuncionario = DaoFactory.createFuncionarioDao();
        daoCliente = DaoFactory.createClienteDao();
        daoPessoa = DaoFactory.createPessoaDao();
        daoEndereco = DaoFactory.createEnderecoDao();
        daoContato = DaoFactory.createContatoDao();
        daoCidade = DaoFactory.createCidadeDao();
        daoEstado = DaoFactory.createEstadoDao();
        daoProduto = DaoFactory.createProdutoDao();
        daoCategoria = DaoFactory.createCategoriaDao();
    }
    
 //*********************************************************************************
    
    public void inserirFuncionario(Funcionario funcionario) throws Exception{
        daoFuncionario.inserir(funcionario);
    }
    public void alterarFuncionario(Funcionario funcionario) throws Exception{
        daoFuncionario.alterar(funcionario);
    }
    public void excluirFuncionario(Funcionario funcionario) throws Exception{
        daoFuncionario.excluir(funcionario);
    }
    public Funcionario buscarFuncionario(long id) throws Exception{
        return daoFuncionario.buscar(id);
    }
    public List<Funcionario> listarFuncionarios() throws Exception{
       return daoFuncionario.listar();
    }
    public void limparFuncionarios() throws Exception{
        daoFuncionario.limpar();
    }

//**********************************************************************************
    
    public void inserirCliente(Cliente cliente) throws Exception{
        daoCliente.inserirCliente(cliente);
    }
    public void alterarCliente(Cliente cliente) throws Exception{
        daoCliente.alterarCliente(cliente);
    }
    public void excluirCliente(Cliente cliente) throws Exception{
        daoCliente.excluirCliente(cliente);
    }
    public Cliente buscarCliente(long id) throws Exception{
        return daoCliente.buscarCliente(id);
    }
    public List<Cliente> listarClientes() throws Exception{
       return daoCliente.listarCliente();
    }
    
//***********************************************************************************  
    
    public void inserirPessoa(Pessoa pessoa) throws Exception{
        daoPessoa.inserir(pessoa);
    }
    public void alterarPessoa(Pessoa pessoa) throws Exception{
         daoPessoa.alterar(pessoa);
    }
    public void excluirPessoa(Pessoa pessoa) throws Exception{
        daoPessoa.excluir(pessoa);
    }
    public Pessoa buscarPessoa(long id) throws Exception{
        return  daoPessoa.buscar(id);
    }
    public List<Pessoa> listarPessoas() throws Exception{
       return  daoPessoa.listar();
    }
    public void limparPessoas() throws Exception{
        daoPessoa.limpar();
    }
    
//***********************************************************************************  
    
    public void inserirEndereco(Endereco endereco) throws Exception{
        daoEndereco.inserir(endereco);
    }
    public void alterarEndereco(Endereco endereco) throws Exception{
         daoEndereco.alterar(endereco);
    }
    public void excluirEndereco(Endereco endereco) throws Exception{
        daoEndereco.excluir(endereco);
    }
    public Endereco buscarEndereco(long id) throws Exception{
        return  daoEndereco.buscar(id);
    }
    public List<Endereco> listarEnderecos() throws Exception{
       return  daoEndereco.listar();
    }
    public void limparEnderecos() throws Exception{
        daoEndereco.limpar();
    }
 
//***********************************************************************************   
    
    public void inserirCidade(Cidade cidade) throws Exception{
        daoCidade.inserir(cidade);
    }
    public void alterarCidade(Cidade cidade) throws Exception{
         daoCidade.alterar(cidade);
    }
    public void excluirCidade(Cidade cidade) throws Exception{
        daoCidade.excluir(cidade);
    }
    public Cidade buscarCidade(long id) throws Exception{
        return  daoCidade.buscar(id);
    }
    public List<Cidade> listarCidades() throws Exception{
       return  daoCidade.listar();
    }
   
   
   //***********************************************************************************
    
    public void inserirEstado(Estado estado) throws Exception{
        daoEstado.inserir(estado);
    }
    public void alterarEstado(Estado estado) throws Exception{
         daoEstado.alterar(estado);
    }
    public void excluirEstado(Estado estado) throws Exception{
        daoEstado.excluir(estado);
    }
    public Estado buscarEstado(long id) throws Exception{
        return  daoEstado.buscar(id);
    }
    public List<Estado> listarEstados() throws Exception{
       return  daoEstado.listar();
    } 
    
//***********************************************************************************
    
    public long inserirCategoria(Categoria categoria) throws Exception{
        return daoCategoria.inserir(categoria);
    }
    public void alterarCategoria(Categoria categoria) throws Exception{
         daoCategoria.alterar(categoria);
    }
    public void excluirCategoria(Categoria categoria) throws Exception{
        daoCategoria.excluir(categoria);
    }
    public Categoria buscarCategoria(long id) throws Exception{
        return  daoCategoria.buscar(id);
    }
    public List<Categoria> listarCategorias() throws Exception{
       return  daoCategoria.listar();
    } 
    public void limparCategorias() throws Exception{
        daoCategoria.limpar();
    }
    
    //***********************************************************************************
    
    public void inserirProduto(Produto produto) throws Exception{
        daoProduto.inserir(produto);
    }
    public void alterarProduto(Produto produto) throws Exception{
         daoProduto.alterar(produto);
    }
    public void excluirProduto(Produto produto) throws Exception{
        daoProduto.excluir(produto);
    }
    public Produto buscarProduto(long id) throws Exception{
        return  daoProduto.buscar(id);
    }
    public List<Produto> listarProdutos() throws Exception{
       return  daoProduto.listar();
    } 
    public void limparProdutos() throws Exception{
        daoProduto.limpar();
    }
}
