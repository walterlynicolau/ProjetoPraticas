/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wns.projetoloja.teste;

import br.com.wns.projetoloja.facade.FacadeLoja;
import br.com.wns.projetoloja.model.Cidade;
import br.com.wns.projetoloja.model.Cliente;
import br.com.wns.projetoloja.model.Contato;
import br.com.wns.projetoloja.model.Endereco;
import br.com.wns.projetoloja.model.Funcionario;
import br.com.wns.projetoloja.model.Pessoa;
import br.com.wns.projetoloja.util.StringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ClienteTest {
    
    private static FacadeLoja facade;
    
    public ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        facade = new  FacadeLoja();
        facade.limparFuncionarios();
        facade.limparClientes();
        facade.limparPessoas();
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
    public void testeCrudCliente() throws Exception {
        testeInserir();
        testeEditar();
        testeExcluir();
    }
    
    public void testeInserir() throws Exception{
        
        Cliente cliente = new Cliente();
        cliente.setTipoCliente("preferencial");
        cliente.setNome("Rivaldo Sousa");
        cliente.setCpf("000 000 000-00");
        cliente.setRg("00000-00");
        cliente.setSexo("Masculino");
        cliente.setDataNascimento(StringUtils.converterData("22/09/1960"));
        cliente.setEndereco(new Endereco());
        cliente.getEndereco().setRua("Rua dos cha");
        cliente.getEndereco().setNumero("000");
        cliente.getEndereco().setBairro("novo");
        cliente.getEndereco().setCep("00000-000");
        cliente.getEndereco().setCidade(new Cidade());
        cliente.setContato(new Contato());
        cliente.getContato().setTelefoneCelular("(00)0000-0000");
        cliente.getContato().setTelefoneFixo("(00)0000-0000");
        cliente.getContato().setEmail1("walter@gmail.com");
        cliente.getContato().setEmail2("walterlyninja@gmail.com");
        cliente.getEndereco().getCidade().setId(2);
        
        assertEquals(0, facade.listarClientes().size());
        
        facade.inserirCliente(cliente);
        
        assertEquals(1, facade.listarClientes().size());
    }
    
     public void testeEditar() throws Exception{
        
        Cliente cliente = facade.listarClientes().get(0);
        
        String novoTipoCliente = "Preferencial";
        String novoNome = "walterly Nicolau de Souza";
        String novoCpf = "000 000 000-00";
        String novoRg = "00.000-00";
        String novoSexo = "Masculino";
        String novoRua = "avenida das chagas";
        String novoDataNascimento = "22/09/1994";
        String novoNumero = "00.000";
        String novoBairro = "Centro";
        String novoCep = "00.000-000";
        String novoCelular = "88888888";
        String novoFixo = "77777777";
        String novoEmail1 = "walterlyninja@gmail.com";
        String novoEmail2 = "walter@gmail.com";
        int novoId = 2;
        
        cliente.setTipoCliente(novoTipoCliente);
        cliente.setNome(novoNome);
        cliente.setCpf(novoCpf);
        cliente.setRg(novoRg);
        cliente.setSexo(novoSexo);
        cliente.setDataNascimento(StringUtils.converterData(novoDataNascimento));
        cliente.getEndereco().setRua(novoRua);
        cliente.getEndereco().setNumero(novoNumero);
        cliente.getEndereco().setBairro(novoBairro);
        cliente.getEndereco().setCep(novoCep);
        cliente.getContato().setTelefoneCelular(novoCelular);
        cliente.getContato().setTelefoneFixo(novoFixo);
        cliente.getContato().setEmail1(novoEmail1);
        cliente.getContato().setEmail2(novoEmail2);
        cliente.getEndereco().getCidade().setId(novoId);
        
        facade.alterarCliente(cliente);
        cliente = facade.listarClientes().get(0);
        
        assertEquals(novoTipoCliente, cliente.getTipoCliente());;
        assertEquals(novoNome, cliente.getNome());
        assertEquals(novoCpf, cliente.getCpf());
        assertEquals(novoRg, cliente.getRg());
        assertEquals(novoSexo, cliente.getSexo());
        assertEquals(novoDataNascimento, StringUtils.formatarData(cliente.getDataNascimento()));
        assertEquals(novoRua, cliente.getEndereco().getRua());
        assertEquals(novoNumero, cliente.getEndereco().getNumero());
        assertEquals(novoBairro, cliente.getEndereco().getBairro());
        assertEquals(novoCep, cliente.getEndereco().getCep());
        assertEquals(novoCelular, cliente.getContato().getTelefoneCelular());
        assertEquals(novoFixo, cliente.getContato().getTelefoneFixo());
        assertEquals(novoEmail1, cliente.getContato().getEmail1());
        assertEquals(novoEmail2, cliente.getContato().getEmail2());
        assertEquals(novoId, cliente.getEndereco().getCidade().getId());
    }
     
    public void testeExcluir() throws Exception{
        
        assertEquals(1, facade.listarClientes().size());
        Cliente cliente = facade.listarClientes().get(0);
        facade.excluirCliente(cliente);
        assertEquals(0, facade.listarClientes().size());
    }
       
    public void testeBuscar() throws Exception{
        
//        assertEquals(1,facade.listarClientes().size());
//        Cliente cliente = facade.listarClientes().get(0);
//        cliente = facade.buscarCliente(cliente.getId());
//        assertNotNull(cliente);
//        
//        String novoTipoCliente = cliente.getTipoCliente();
//        String novoNome = cliente.getNome();
//        String novoCpf = cliente.getCpf();
//        String novoRg = cliente.getRg();
//        String novoSexo = cliente.getSexo();
//        String novoDataNascimento = StringUtils.formatarData(cliente.getDataNascimento());
//        String novoRua = cliente.getEndereco().getRua();
//        String novoNumero = cliente.getEndereco().getNumero();
//        String novoBairro = cliente.getEndereco().getBairro();
//        String novoCep = cliente.getEndereco().getCep();
//        String novoCelular = cliente.getContato().getTelefoneCelular();
//        String novoFixo = cliente.getContato().getTelefoneFixo();
//        String novoEmail1 = cliente.getContato().getEmail1();
//        String novoEmail2 = cliente.getContato().getEmail2();
//        long novoId = cliente.getEndereco().getCidade().getId();
//       
//        cliente = facade.buscarCliente(cliente.getId());
//        assertEquals(novoTipoCliente, cliente.getTipoCliente());
//        assertEquals(novoNome, cliente.getNome());
//        assertEquals(novoCpf, cliente.getCpf());
//        assertEquals(novoRg, cliente.getRg());
//        assertEquals(novoSexo, cliente.getSexo());
//        assertEquals(novoDataNascimento, StringUtils.formatarData(cliente.getDataNascimento()));
//        assertEquals(novoRua, cliente.getEndereco().getRua());
//        assertEquals(novoNumero, cliente.getEndereco().getNumero());
//        assertEquals(novoBairro, cliente.getEndereco().getBairro());
//        assertEquals(novoCep, cliente.getEndereco().getCep());
//        assertEquals(novoCelular, cliente.getContato().getTelefoneCelular());
//        assertEquals(novoFixo, cliente.getContato().getTelefoneFixo());
//        assertEquals(novoEmail1, cliente.getContato().getEmail1());
//        assertEquals(novoEmail2, cliente.getContato().getEmail2());
//        assertEquals(novoId, cliente.getEndereco().getCidade().getId());
    }
}
