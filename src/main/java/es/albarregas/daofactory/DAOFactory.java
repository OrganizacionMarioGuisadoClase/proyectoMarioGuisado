package es.albarregas.daofactory;

import es.albarregas.dao.ICaractProdsDAO;
import es.albarregas.dao.ICaracteristicaDAO;
import es.albarregas.dao.ICategoriaDAO;
import es.albarregas.dao.IImagenDAO;
import es.albarregas.dao.IMarcaDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IUsuarioDAO;


public abstract class DAOFactory {
    
    public abstract ICategoriaDAO getCategoriaDAO();
    public abstract IMarcaDAO getMarcaDAO();
    public abstract IImagenDAO getImagenDAO();
    public abstract IProductoDAO getProductoDAO();
    public abstract ICaracteristicaDAO getCaracteristicaDAO();
    public abstract ICaractProdsDAO getCaractProdsDAO();
    public abstract IUsuarioDAO getUsuarioDAO();
    
    public static DAOFactory getDAOFactory(){
        
        DAOFactory daof = new MySQLDAOFactory();
        
        return daof;
    }
    
}