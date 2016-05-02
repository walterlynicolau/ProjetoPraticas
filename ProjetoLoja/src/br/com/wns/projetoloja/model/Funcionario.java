package br.com.wns.projetoloja.model;

public class Funcionario extends Pessoa {
  // private long idFuncionario;
   private String matricula;
   private String salario;

    public Funcionario( String matricula, String salario) {
       // this.idFuncionario = idFuncionario;
        this.matricula = matricula;
        this.salario = salario;
    }

    public Funcionario() {
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return "Funcionario\n matricula: " + matricula + "\n salario: " + salario;
    }
}
