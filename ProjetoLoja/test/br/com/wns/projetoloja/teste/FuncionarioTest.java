package br.com.wns.projetoloja.teste;

import br.com.wns.projetoloja.facade.FacadeLoja;
import br.com.wns.projetoloja.model.Cidade;
import br.com.wns.projetoloja.model.Contato;
import br.com.wns.projetoloja.model.Endereco;
import br.com.wns.projetoloja.model.Funcionario;
import br.com.wns.projetoloja.util.StringUtils;
import java.text.ParseException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FuncionarioTest {
    
    private static FacadeLoja facade;
    
    public FuncionarioTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        facade = new  FacadeLoja();
        facade.limparFuncionarios();
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
   public void testeCrudFuncionario()throws Exception{
        testeInserir();
        testeEditar();
        testeBuscar();
        testeExcluir();
         //testeListar();
   }

    
    public void testeInserir() throws Exception{
        
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula("00000");
        funcionario.setSalario("20.000,00");
        funcionario.setNome("Walterly N de Sousa");
        funcionario.setCpf("000 000 000-00");
        funcionario.setRg("00000-00");
        funcionario.setSexo("Masculino");
        funcionario.setDataNascimento(StringUtils.converterData("22/09/1995"));
        funcionario.setEndereco(new Endereco());
        funcionario.getEndereco().setRua("Rua dos cha");
        funcionario.getEndereco().setNumero("000");
        funcionario.getEndereco().setBairro("novo");
        funcionario.getEndereco().setCep("00000-000");
        funcionario.getEndereco().setCidade(new Cidade());
        funcionario.setContato(new Contato());
        funcionario.getContato().setTelefoneCelular("(00)0000-0000");
        funcionario.getContato().setTelefoneFixo("(00)0000-0000");
        funcionario.getContato().setEmail1("walter@gmail.com");
        funcionario.getContato().setEmail2("walterlyninja@gmail.com");
        funcionario.getEndereco().getCidade().setId(2);
        
        assertEquals(0, facade.listarFuncionarios().size());
        
        facade.inserirFuncionario(funcionario);
        
        assertEquals(1, facade.listarFuncionarios().size());
    }

   
    public void testeEditar() throws Exception{
        
        Funcionario funcionario = facade.listarFuncionarios().get(0);
        
        String novoMatricula = "01111";
        String novoSalario = "10.000,00";
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
        int novoId = 1;
        
        funcionario.setMatricula(novoMatricula);
        funcionario.setSalario(novoSalario);
        funcionario.setNome(novoNome);
        funcionario.setCpf(novoCpf);
        funcionario.setRg(novoRg);
        funcionario.setSexo(novoSexo);
        funcionario.setDataNascimento(StringUtils.converterData(novoDataNascimento));
        funcionario.getEndereco().setRua(novoRua);
        funcionario.getEndereco().setNumero(novoNumero);
        funcionario.getEndereco().setBairro(novoBairro);
        funcionario.getEndereco().setCep(novoCep);
        funcionario.getContato().setTelefoneCelular(novoCelular);
        funcionario.getContato().setTelefoneFixo(novoFixo);
        funcionario.getContato().setEmail1(novoEmail1);
        funcionario.getContato().setEmail2(novoEmail2);
        funcionario.getEndereco().getCidade().setId(novoId);
        
        facade.alterarFuncionario(funcionario);
        funcionario = facade.listarFuncionarios().get(0);
        
        assertEquals(novoMatricula, funcionario.getMatricula());
        assertEquals(novoSalario, funcionario.getSalario());
        assertEquals(novoNome, funcionario.getNome());
        assertEquals(novoCpf, funcionario.getCpf());
        assertEquals(novoRg, funcionario.getRg());
        assertEquals(novoSexo, funcionario.getSexo());
        assertEquals(novoDataNascimento, StringUtils.formatarData(funcionario.getDataNascimento()));
        assertEquals(novoRua, funcionario.getEndereco().getRua());
        assertEquals(novoNumero, funcionario.getEndereco().getNumero());
        assertEquals(novoBairro, funcionario.getEndereco().getBairro());
        assertEquals(novoCep, funcionario.getEndereco().getCep());
        assertEquals(novoCelular, funcionario.getContato().getTelefoneCelular());
        assertEquals(novoFixo, funcionario.getContato().getTelefoneFixo());
        assertEquals(novoEmail1, funcionario.getContato().getEmail1());
        assertEquals(novoEmail2, funcionario.getContato().getEmail2());
        assertEquals(novoId, funcionario.getEndereco().getCidade().getId());
    }
    
   
    public void testeExcluir() throws Exception{
        
        assertEquals(1, facade.listarFuncionarios().size());
        Funcionario funcionario = facade.listarFuncionarios().get(0);
        facade.excluirFuncionario(funcionario);
        assertEquals(0, facade.listarFuncionarios().size());
    }
       
    public void testeBuscar() throws Exception{
        
        assertEquals(1,facade.listarFuncionarios().size());
        Funcionario funcionario = facade.listarFuncionarios().get(0);
        funcionario = facade.buscarFuncionario(funcionario.getId());
        assertNotNull(funcionario);
//        
//        String novoMatricula = funcionario.getMatricula();
//        String novoSalario = funcionario.getSalario();
//        String novoNome = funcionario.getNome();
//        String novoCpf = funcionario.getCpf();
//        String novoRg = funcionario.getRg();
//        String novoSexo = funcionario.getSexo();
//        String novoDataNascimento = StringUtils.formatarData(funcionario.getDataNascimento());
//        String novoRua = funcionario.getEndereco().getRua();
//        String novoNumero = funcionario.getEndereco().getNumero();
//        String novoBairro = funcionario.getEndereco().getBairro();
//        String novoCep = funcionario.getEndereco().getCep();
//        String novoCelular = funcionario.getContato().getTelefoneCelular();
//        String novoFixo = funcionario.getContato().getTelefoneFixo();
//        String novoEmail1 = funcionario.getContato().getEmail1();
//        String novoEmail2 = funcionario.getContato().getEmail2();
//        long novoId = funcionario.getEndereco().getCidade().getId();
////        
////        funcionario = facade.buscarFuncionario(funcionario.getId());
//        assertEquals(novoMatricula, funcionario.getMatricula());
//        assertEquals(novoSalario, funcionario.getSalario());
//        assertEquals(novoNome, funcionario.getNome());
//        assertEquals(novoCpf, funcionario.getCpf());
//        assertEquals(novoRg, funcionario.getRg());
//        assertEquals(novoSexo, funcionario.getSexo());
//        assertEquals(novoDataNascimento, StringUtils.formatarData(funcionario.getDataNascimento()));
//        assertEquals(novoRua, funcionario.getEndereco().getRua());
//        assertEquals(novoNumero, funcionario.getEndereco().getNumero());
//        assertEquals(novoBairro, funcionario.getEndereco().getBairro());
//        assertEquals(novoCep, funcionario.getEndereco().getCep());
//        assertEquals(novoCelular, funcionario.getContato().getTelefoneCelular());
//        assertEquals(novoFixo, funcionario.getContato().getTelefoneFixo());
//        assertEquals(novoEmail1, funcionario.getContato().getEmail1());
//        assertEquals(novoEmail2, funcionario.getContato().getEmail2());
//        assertEquals(novoId, funcionario.getEndereco().getCidade().getId());
    }
   
//    public void testeListar() throws Exception{
//        
//        List<Funcionario> funcionarios = facade.listarFuncionarios();
//        assertNotNull(funcionarios);
//        
//    }
}
