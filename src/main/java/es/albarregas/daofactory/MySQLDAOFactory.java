package es.albarregas.daofactory;

import es.albarregas.dao.CaractProdsDAO;
import es.albarregas.dao.ICategoriaDAO;
import es.albarregas.dao.CategoriaDAO;
import es.albarregas.dao.ICaracteristicaDAO;
import es.albarregas.dao.CaracteristicaDAO;
import es.albarregas.dao.ICaractProdsDAO;
import es.albarregas.dao.IImagenDAO;
import es.albarregas.dao.IMarcaDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.dao.ImagenDAO;
import es.albarregas.dao.MarcaDAO;
import es.albarregas.dao.ProductoDAO;
import es.albarregas.dao.UsuarioDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public ICategoriaDAO getCategoriaDAO() {
        return new CategoriaDAO();
    }

    @Override
    public IMarcaDAO getMarcaDAO() {
        return new MarcaDAO();
    }

    @Override
    public IImagenDAO getImagenDAO() {
        return new ImagenDAO();
    }

    @Override
    public IProductoDAO getProductoDAO() {
        return new ProductoDAO();
    }

    @Override
    public ICaracteristicaDAO getCaracteristicaDAO() {
        return new CaracteristicaDAO();
    }

    @Override
    public ICaractProdsDAO getCaractProdsDAO() {
        return new CaractProdsDAO();
    }

    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }


}