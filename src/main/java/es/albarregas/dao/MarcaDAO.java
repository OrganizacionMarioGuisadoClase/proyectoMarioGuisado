package es.albarregas.dao;

import es.albarregas.beans.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarcaDAO implements IMarcaDAO {

    private PreparedStatement preparada = null;
    private ResultSet resultado = null;

    @Override
    public ArrayList<Marca> getMarcas(String where) {
        ArrayList<Marca> marcas = new ArrayList();
        Marca marca = null;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM marcas " + where + ";");
            resultado = preparada.executeQuery();

            while (resultado.next()) {
                marca = new Marca();
                marca.setIdMarca(resultado.getInt("IdMarca"));
                marca.setDenominacion(resultado.getString("Denominacion"));
                marcas.add(marca);
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

        return marcas;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
