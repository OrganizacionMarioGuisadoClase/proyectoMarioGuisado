package es.albarregas.dao;

import es.albarregas.beans.Categoria;
import java.util.ArrayList;

public interface ICategoriaDAO {
    public ArrayList<Categoria> getCategorias(String where);
    public void closeConnection();
}
