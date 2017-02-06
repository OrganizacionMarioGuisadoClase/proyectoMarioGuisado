package es.albarregas.beans;

import java.io.Serializable;


public class Caractprod implements Serializable{
    
    private int idCaractprods;
    private int idProducto;
    private int idCaracteristica;
    private String descripcion;
    private int idx;
    private Caracteristica caracteristica;

    /**
     * @return the idCaractprods
     */
    public int getIdCaractprods() {
        return idCaractprods;
    }

    /**
     * @param idCaractprods the idCaractprods to set
     */
    public void setIdCaractprods(int idCaractprods) {
        this.idCaractprods = idCaractprods;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the idx
     */
    public int getIdx() {
        return idx;
    }

    /**
     * @param idx the idx to set
     */
    public void setIdx(int idx) {
        this.idx = idx;
    }

    /**
     * @return the caracteristica
     */
    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    /**
     * @param caracteristica the caracteristica to set
     */
    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }
    
    
    
}
