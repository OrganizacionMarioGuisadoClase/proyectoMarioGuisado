package es.albarregas.dao;

import es.albarregas.beans.Producto;


public interface ICaractProdsDAO {
    public Producto annadirCaracteristicas(Producto p);
    public void closeConnection();
}
