package es.albarregas.dao;

import es.albarregas.beans.Caracteristica;
import java.util.ArrayList;


public interface ICaracteristicaDAO {
    public ArrayList<Caracteristica> getCaracteristicas(String where);
    public void closeConnection();
}
