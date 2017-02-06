package es.albarregas.dao;

import es.albarregas.beans.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO implements ICategoriaDAO {

    private PreparedStatement preparada = null;
    private ResultSet resultado = null;
    
    @Override
    public ArrayList<Categoria> getCategorias(String where) {
        
        ArrayList<Categoria> categorias = new ArrayList();
        Categoria categoria = null;
        
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM categorias " + where + ";");
            resultado = preparada.executeQuery();
            
            while(resultado.next()){
                categoria = new Categoria();            
                categoria.setIdCategoria(resultado.getInt("IdCategoria"));
                categoria.setNombre(resultado.getString("Nombre"));
                categorias.add(categoria);
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
        
        return categorias;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
    
}
