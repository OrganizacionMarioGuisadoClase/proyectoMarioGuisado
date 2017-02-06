package es.albarregas.beans;

import java.io.Serializable;


public class Direccion implements Serializable{
    
    private int idDireccion;
    private int idCliente;
    private String nombreDireccion;
    private String direccion;
    private String codigoPostal;
    private int idPueblo;
    private String telefono;

    /**
     * @return the idDireccion
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * @param idDireccion the idDireccion to set
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nombreDireccion
     */
    public String getNombreDireccion() {
        return nombreDireccion;
    }

    /**
     * @param nombreDireccion the nombreDireccion to set
     */
    public void setNombreDireccion(String nombreDireccion) {
        this.nombreDireccion = nombreDireccion;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return the idPueblo
     */
    public int getIdPueblo() {
        return idPueblo;
    }

    /**
     * @param idPueblo the idPueblo to set
     */
    public void setIdPueblo(int idPueblo) {
        this.idPueblo = idPueblo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
