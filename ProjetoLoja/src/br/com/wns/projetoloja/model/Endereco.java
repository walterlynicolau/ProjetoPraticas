
package br.com.wns.projetoloja.model;

public class Endereco {
    
    private long id;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private Cidade cidade;

    public Endereco( String rua, String numero, String bairro, String cep, Cidade cidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
    
    public Endereco(Cidade cidade) {
        cidade = new Cidade();
    }

    //torna a classe javaBin, uma classe q tem atributos privados, metodos de acesso publico, e pelo menos um contrutor vazio
    public Endereco() {
        
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Endereco{" + "id=" + id +", rua=" + rua + 
             ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + '}';
    }
    
}
