
package br.com.wns.projetoloja.model;

public class Cliente extends Pessoa  {
    
    private long idClente;
    private String tipoCliente;

    public Cliente(long idClente, String tipoCliente) {
        this.idClente = idClente;
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public Cliente() {
           
    }

    public long getIdClente() {
        return idClente;
    }

    public void setIdClente(long idClente) {
        this.idClente = idClente;
    }
}