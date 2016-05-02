package br.com.wns.projetoloja.teste;

import br.com.wns.projetoloja.facade.FacadeLoja;
import br.com.wns.projetoloja.model.Categoria;
import br.com.wns.projetoloja.model.Funcionario;
import br.com.wns.projetoloja.model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProdutoTest {
    private static FacadeLoja facade;
    
    public ProdutoTest() {
    }
        
        
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        facade = new FacadeLoja();
        facade.limparProdutos();
        facade.limparCategorias();
    }
    
    @AfterClass
    public static void tearDownClass() {
        facade = null;
        System.gc();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testeCrudProduto() throws Exception{
        
        testeInserir();
        testeAlterar();
        testeBuscar();
        testeExcluir();
        
    }

    public void testeInserir() throws Exception {
        
        Produto produto = new Produto();
        Categoria categoria = new Categoria();
        produto.setNome("Calsa Skinner");
        produto.setCodigo("101");
        produto.setValor("120,00");
        categoria.setNome("Vesturio");
        produto.setCategoria(categoria);
        
        assertEquals(0, facade.listarProdutos().size());
        assertEquals(0, facade.listarCategorias().size());
        
        long id = facade.inserirCategoria(produto.getCategoria());
        produto.getCategoria().setId(id);
        facade.inserirProduto(produto);
        assertEquals(1, facade.listarProdutos().size());
        assertEquals(1, facade.listarCategorias().size());
       
    }

    public void testeAlterar() throws Exception {
       Produto produto = facade.listarProdutos().get(0);
       
       String novoNome = "Tennis Rainha";
       String novoCodigo = "1001";
       String novoValor = "150,00";
       String novaDescricao = "Calçados";
        produto.setNome(novoNome);
        produto.setCodigo(novoCodigo);
        produto.setValor(novoValor);
        produto.getCategoria().setNome(novaDescricao);
        
        facade.alterarProduto(produto);
        facade.alterarCategoria(produto.getCategoria());
        produto = facade.listarProdutos().get(0);
        
        assertEquals(novoNome,produto.getNome());
        assertEquals(novoCodigo, produto.getCodigo());
        assertEquals(novoValor, produto.getValor());
        assertEquals(novaDescricao,produto.getCategoria().getNome());
    }
       
    public void testeBuscar() throws Exception{
        
        assertEquals(1,facade.listarProdutos().size());
        Produto produto = facade.listarProdutos().get(0);
        produto = facade.buscarProduto(produto.getId());
        assertNotNull(produto);
    }
    
     public void testeExcluir() throws Exception{
        
        assertEquals(1, facade.listarProdutos().size());
        Produto produto = facade.listarProdutos().get(0);
        facade.excluirProduto(produto);
        assertEquals(0, facade.listarProdutos().size());
    }
}
