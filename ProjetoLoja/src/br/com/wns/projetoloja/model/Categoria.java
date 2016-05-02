
package br.com.wns.projetoloja.model;


public class Categoria {
    private long id;
    private String Nome;

    public Categoria(long id, String Nome) {
        this.id = id;
        this.Nome = Nome;
    }

    public Categoria() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }


    public String toString() {
        return "Categoria " + "id= " + id + ", Nome= " + Nome;
    }
    
}
