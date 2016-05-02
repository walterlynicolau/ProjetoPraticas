
package br.com.wns.projetoloja.model;

public class Estado {    
    private long id;
    private String nome;
    private String uf;

    public Estado( String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }
 
    
    
    public Estado() {
        
    }

//==================================================

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", "
                + "         nome=" + nome + ", "
                + "         uf=" + uf + '}';
    }

}
