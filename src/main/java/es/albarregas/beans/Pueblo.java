package es.albarregas.beans;

import java.io.Serializable;


public class Pueblo implements Serializable{
    
    private int idPueblo;
    private int IdProvincia;
    private String codigoPostal;
    private String nombre;

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the IdProvincia
     */
    public int getIdProvincia() {
        return IdProvincia;
    }

    /**
     * @param IdProvincia the IdProvincia to set
     */
    public void setIdProvincia(int IdProvincia) {
        this.IdProvincia = IdProvincia;
    }
    
    
    
}
