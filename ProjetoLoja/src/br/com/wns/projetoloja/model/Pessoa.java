
package br.com.wns.projetoloja.model;

import java.util.Date;

public class Pessoa {
    private long id;
    private String cpf;
    private String nome;
    private String sexo;
    private String rg;
    private Date dataNascimento;
    private Endereco endereco;
    private Contato contato;

    public Pessoa(long id, String cpf, String nome, String sexo, String rg, Date dataNascimento, Endereco endereco, Contato contato) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contato = contato;
    }
    
    public Pessoa() {
        endereco = new Endereco();
        contato = new Contato();
        dataNascimento = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
   
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", idEndereco="+ ", cpf=" + cpf + ", nome=" + nome 
                         + ", sexo=" + sexo + ", rg=" + rg + ", dataNascimento=" + dataNascimento 
                         + ", endereco=" + endereco + ", contato=" + contato + '}';
    }
}