package br.com.wns.projetoloja.teste;

import br.com.wns.projetoloja.facade.FacadeLoja;
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
    public void testeCrudProduto(){
        
    }
}
