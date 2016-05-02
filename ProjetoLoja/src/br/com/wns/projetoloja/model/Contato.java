
package br.com.wns.projetoloja.model;

public class Contato {
    private long id;
    private String telefoneCelular;
    private String telefoneFixo;
    private String email1;
    private String email2;

    public Contato(String telefoneCelular, String telefoneFixo, String email1, String email2) {
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.email1 = email1;
        this.email2 = email2;
    }

    public Contato(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    
    

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", telefoneCelular=" + telefoneCelular 
                          + ", telefoneFixo=" + telefoneFixo + ", email1=" + email1 
                          +", email2=" + email2 + '}';
    }
 
}
