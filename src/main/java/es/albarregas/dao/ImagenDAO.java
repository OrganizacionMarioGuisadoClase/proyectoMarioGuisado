package es.albarregas.dao;

import es.albarregas.beans.Imagen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ImagenDAO implements IImagenDAO{
    
    private PreparedStatement preparada = null;
    private ResultSet resultado = null;

    @Override
    public ArrayList<Imagen> getImagenes(String where) {
        
        ArrayList<Imagen> imagenes = new ArrayList();
        Imagen imagen = null;
        
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM imagenes " + where + ";");
            resultado = preparada.executeQuery();
            
            while(resultado.next()){
                imagen = new Imagen();            
                imagen.setIdImagen(resultado.getInt("IdImagen"));
                imagen.setIdProducto(resultado.getInt("IdProducto"));
                imagen.setImagen(resultado.getString("Imagen"));
                imagen.setIdx(resultado.getInt("Idx"));
                imagenes.add(imagen);
            }
            
            
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
        
        return imagenes;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
    
}
