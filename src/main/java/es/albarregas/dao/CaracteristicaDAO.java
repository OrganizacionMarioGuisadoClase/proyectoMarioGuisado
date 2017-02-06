package es.albarregas.dao;

import es.albarregas.beans.Caracteristica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaracteristicaDAO implements ICaracteristicaDAO {

    private PreparedStatement preparada = null;
    private ResultSet resultado = null;

    @Override
    public ArrayList<Caracteristica> getCaracteristicas(String where) {
        
        ArrayList<Caracteristica> caracteristicas = new ArrayList();
        Caracteristica caracteristica = null;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM caracteristicas " + where + ";");
            resultado = preparada.executeQuery();

            while (resultado.next()) {
                caracteristica = new Caracteristica();
                caracteristica.setIdCaracteristica(resultado.getInt("IdCaracteristica"));
                caracteristica.setIdCategoria(resultado.getInt("IdCategoria"));
                caracteristica.setNombre(resultado.getString("Nombre"));
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

        return caracteristicas;
    }
    
    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }


}
