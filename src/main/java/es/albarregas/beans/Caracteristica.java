package es.albarregas.beans;

import java.io.Serializable;


public class Caracteristica implements Serializable{
    
    private int idCaracteristica;
    private int idCategoria;
    private String nombre;

    /**
     * @return the idCaracteristica
     */
    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    /**
     * @param idCaracteristica the idCaracteristica to set
     */
    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
    
    
    
}
