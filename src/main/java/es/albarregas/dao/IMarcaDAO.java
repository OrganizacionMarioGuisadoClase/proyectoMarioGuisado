package es.albarregas.dao;

import es.albarregas.beans.Marca;
import java.util.ArrayList;


public interface IMarcaDAO {
    public ArrayList<Marca> getMarcas(String where);
    public void closeConnection();
}
