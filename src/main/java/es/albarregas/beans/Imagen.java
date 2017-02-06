package es.albarregas.beans;

import java.io.Serializable;


public class Imagen implements Serializable{
    
    private int idImagen;
    private int IdProducto;
    private String imagen;
    private int idx;

    /**
     * @return the idImagen
     */
    public int getIdImagen() {
        return idImagen;
    }

    /**
     * @param idImagen the idImagen to set
     */
    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
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
     * @return the IdProducto
     */
    public int getIdProducto() {
        return IdProducto;
    }

    /**
     * @param IdProducto the IdProducto to set
     */
    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    
    
}
