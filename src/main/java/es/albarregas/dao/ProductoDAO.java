package es.albarregas.dao;

import es.albarregas.beans.Producto;
import es.albarregas.beans.Imagen;
import es.albarregas.beans.Categoria;
import es.albarregas.beans.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductoDAO implements IProductoDAO{
    
    private PreparedStatement preparada = null;
    private ResultSet resultado = null;

    @Override
    public ArrayList<Producto> getProductos(String where) {
        
        ArrayList<Producto> productos = new ArrayList();        
        ArrayList<Imagen> imagenes = new ArrayList();
        Producto producto = null;
        Categoria categoria = null;
        Marca marca = null;
        Imagen imagen = null;
        int idProducto = -1;
        
        try {
            
            preparada = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM productos AS p INNER JOIN imagenes USING(IdProducto) INNER JOIN categorias AS c USING(IdCategoria) INNER JOIN marcas AS m USING(IdMarca) " + where + ";");
            resultado = preparada.executeQuery();  
            while(resultado.next()){
                if(idProducto!=resultado.getInt("p.IdProducto")){
                    if(producto!=null){                        
                        producto.setImagenes(imagenes);
                        productos.add(producto);
                        imagenes = new ArrayList();
                    }
                    idProducto = resultado.getInt("p.IdProducto");
                    producto = new Producto();
                    producto.setIdProducto(resultado.getInt("p.IdProducto"));                    
                    producto.setIdCategoria(resultado.getInt("p.IdCategoria"));
                    producto.setIdMarca(resultado.getInt("p.IdMarca"));
                    producto.setDenominacion(resultado.getString("p.Denominacion"));
                    producto.setDescripcion(resultado.getString("p.Descripcion"));
                    producto.setIdProveedor(resultado.getInt("p.IdProveedor"));
                    producto.setPrecioUnitario(resultado.getDouble("p.PrecioUnitario"));
                    producto.setStock(resultado.getInt("p.Stock"));
                    producto.setStockMinimo(resultado.getInt("p.StockMinimo"));
                    producto.setFechaAlta(resultado.getDate("p.FechaAlta"));
                    producto.setOferta(resultado.getString("p.Oferta").charAt(0));
                    producto.setFueraCatalogo(resultado.getString("p.FueraCatalogo").charAt(0));
                    categoria = new Categoria();
                    categoria.setIdCategoria(resultado.getInt("p.IdCategoria"));
                    categoria.setNombre(resultado.getString("c.Nombre"));
                    producto.setCategoria(categoria);
                    marca = new Marca();
                    marca.setIdMarca(resultado.getInt("p.IdMarca"));
                    marca.setDenominacion(resultado.getString("m.Denominacion"));
                    producto.setMarca(marca);
                    imagen = new Imagen();
                    imagen.setIdImagen(resultado.getInt("IdImagen"));
                    imagen.setIdProducto(resultado.getInt("p.IdProducto"));
                    imagen.setImagen(resultado.getString("Imagen"));
                    imagen.setIdx(resultado.getInt("Idx"));
                    imagenes.add(imagen);
                }else{
                    imagen = new Imagen();
                    imagen.setIdImagen(resultado.getInt("IdImagen"));
                    imagen.setIdProducto(resultado.getInt("p.IdProducto"));
                    imagen.setImagen(resultado.getString("Imagen"));
                    imagen.setIdx(resultado.getInt("Idx"));
                    imagenes.add(imagen);
                }               
            }
            if(producto!=null){
                producto.setImagenes(imagenes);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            if (preparada != null) {
                preparada.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        this.closeConnection();
                  
        return productos;
    }
    
    
    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
    
}
