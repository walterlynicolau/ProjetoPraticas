package br.com.wns.projetoloja.model;

public class Produto {
    
    private long id;
    private String nome;
    private String codigo;
    private String valor;
    private Categoria categoria;
   
    

    public Produto() {
        categoria = new Categoria();
    }
    
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", valor=" + valor + categoria;
    }

        
}