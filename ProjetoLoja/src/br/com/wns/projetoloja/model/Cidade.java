
package br.com.wns.projetoloja.model;


public class Cidade {
    private long id;
    private String nome;
    private Estado estado;

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }
    
  
    public Cidade(Estado estado) {
        estado = new Estado();
    }
    
    public Cidade() {
        
    }
    
//============================================
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    } 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", nome=" + nome + ", estado=" + estado + '}';
    }
    
}
