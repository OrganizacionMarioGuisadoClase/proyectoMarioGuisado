package es.albarregas.dao;

import es.albarregas.beans.Producto;
import java.util.ArrayList;


public interface IProductoDAO {
    public ArrayList<Producto> getProductos(String where);
    public void closeConnection();
}
