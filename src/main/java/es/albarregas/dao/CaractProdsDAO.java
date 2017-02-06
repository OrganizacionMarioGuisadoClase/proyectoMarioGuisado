package es.albarregas.dao;

import es.albarregas.beans.Caractprod;
import es.albarregas.beans.Caracteristica;
import es.albarregas.beans.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CaractProdsDAO implements ICaractProdsDAO{

    private PreparedStatement preparada = null;
    private ResultSet resultado = null;
    
    @Override
    public Producto annadirCaracteristicas(Producto p) {
        
        Producto producto = p;
        Caractprod caractprod = null;
        Caracteristica caracteristica = null;
        ArrayList<Caractprod> caracteristicas = new ArrayList();
        
        
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM caractprods INNER JOIN caracteristicas USING(IdCaracteristica) where IdProducto = '"+producto.getIdProducto()+"';");
            resultado = preparada.executeQuery();            
            
            while(resultado.next()){
                caractprod = new Caractprod();
                caracteristica = new Caracteristica();
                caracteristica.setIdCaracteristica(resultado.getInt("IdCaracteristica"));
                caracteristica.setIdCategoria(resultado.getInt("IdCategoria"));
                caracteristica.setNombre(resultado.getString("Nombre"));
                caractprod.setCaracteristica(caracteristica);
                caractprod.setIdCaractprods(resultado.getInt("IdCaractProds"));
                caractprod.setIdProducto(resultado.getInt("IdProducto"));
                caractprod.setIdCaracteristica(resultado.getInt("IdCaracteristica"));
                caractprod.setDescripcion(resultado.getString("Descripcion"));
                caractprod.setIdx(resultado.getInt("Idx"));
                caracteristicas.add(caractprod);
            }
            producto.setCaracteristicas(caracteristicas);
            
        } catch (SQLException ex) {
            System.out.println("Error al crear sentencia");
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
                  
        return producto;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
    
}
