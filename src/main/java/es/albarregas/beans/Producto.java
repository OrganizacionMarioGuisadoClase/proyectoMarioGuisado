package es.albarregas.beans;

import es.albarregas.daofactory.DAOFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Producto implements Serializable{
    
    private int idProducto;
    private int IdCategoria;
    private int IdMarca;
    private String denominacion;
    private String descripcion;
    private int IdProveedor;
    private double precioUnitario;
    private int stock;
    private int stockMinimo;
    private Date fechaAlta;
    private char oferta;
    private char fueraCatalogo;
    private Categoria categoria;
    private Marca marca;
    private ArrayList<Imagen> imagenes;
    private ArrayList<Caractprod> caracteristicas;
    
    private ArrayList<Producto> productosOferta;
    private ArrayList<Producto> productosVendidos;
    
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
     * @return the IdCategoria
     */
    public int getIdCategoria() {
        return IdCategoria;
    }

    /**
     * @param IdCategoria the IdCategoria to set
     */
    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    /**
     * @return the IdMarca
     */
    public int getIdMarca() {
        return IdMarca;
    }

    /**
     * @param IdMarca the IdMarca to set
     */
    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    /**
     * @return the denominacion
     */
    public String getDenominacion() {
        return denominacion;
    }

    /**
     * @param denominacion the denominacion to set
     */
    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
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
     * @return the Proveedor
     */
    public int getIdProveedor() {
        return IdProveedor;
    }

    /**
     * @param Proveedor the Proveedor to set
     */
    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    /**
     * @return the precioUnitario
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the stockMinimo
     */
    public int getStockMinimo() {
        return stockMinimo;
    }

    /**
     * @param stockMinimo the stockMinimo to set
     */
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    /**
     * @return the fechaAlta
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * @param fechaAlta the fechaAlta to set
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * @return the oferta
     */
    public char getOferta() {
        return oferta;
    }

    /**
     * @param oferta the oferta to set
     */
    public void setOferta(char oferta) {
        this.oferta = oferta;
    }

    /**
     * @return the fueraCatalogo
     */
    public char getFueraCatalogo() {
        return fueraCatalogo;
    }

    /**
     * @param fueraCatalogo the fueraCatalogo to set
     */
    public void setFueraCatalogo(char fueraCatalogo) {
        this.fueraCatalogo = fueraCatalogo;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the imagenes
     */
    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    /**
     * @return the caracteristicas
     */
    public ArrayList<Caractprod> getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(ArrayList<Caractprod> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    
    
    /**
     * @return the productosOferta
     */
    public ArrayList<Producto> getProductosOferta() {
        return DAOFactory.getDAOFactory().getProductoDAO().getProductos("WHERE p.Oferta = 's' AND p.FueraCatalogo = 'n' GROUP BY IdProducto LIMIT 5");
    }

    /**
     * @return the productosVendidos
     */
    public ArrayList<Producto> getProductosVendidos() {
        return DAOFactory.getDAOFactory().getProductoDAO().getProductos("INNER JOIN lineaspedidos AS l USING(IdProducto) WHERE p.FueraCatalogo = 'n' GROUP BY IdProducto LIMIT 6");
    }

    
    
}
