package es.albarregas.dao;

import es.albarregas.beans.Imagen;
import java.util.ArrayList;


public interface IImagenDAO {
    public ArrayList<Imagen> getImagenes(String where);
    public void closeConnection();
}
