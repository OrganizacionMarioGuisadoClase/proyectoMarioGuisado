package es.albarregas.controladores;

import es.albarregas.beans.Categoria;
import es.albarregas.beans.Marca;
import es.albarregas.beans.Producto;
import es.albarregas.dao.ICaractProdsDAO;
import es.albarregas.dao.ICategoriaDAO;
import es.albarregas.dao.IMarcaDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Peticion", urlPatterns = {"/Peticion"})
public class Peticion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String salida = "";
        String where = ""; // En donde escribiré la clausula where de las consultas
        IProductoDAO productodao; // Objeto para consultar productos
        ICaractProdsDAO caractprodsdao; // Objeto para consultar las caracteristicas de los productos
        Producto producto;
        ArrayList<Producto> productos; // Donde almacenare el resultado de la consulta a productos
        ICategoriaDAO categoriadao; // Objeto para consultar categorias
        ArrayList<Categoria> categorias; // Donde almacenare el resultado de la consulta a categorias
        IMarcaDAO marcadao; // Objeto para consultar marcas
        ArrayList<Marca> marcas; // Donde almacenare el resultado de la consulta a marcas
        

        switch (request.getParameter("peticion")) {
            case "producto":
                productodao = DAOFactory.getDAOFactory().getProductoDAO();
                caractprodsdao = DAOFactory.getDAOFactory().getCaractProdsDAO();
                where = "where IdProducto = " + request.getParameter("producto") + " and p.FueraCatalogo = 'n'";
                producto = productodao.getProductos(where).get(0);
                producto = caractprodsdao.annadirCaracteristicas(producto);
                salida = "jsp/producto.jsp";
                request.setAttribute("producto", producto);
                break;
            case "listaProductos":
                productodao = DAOFactory.getDAOFactory().getProductoDAO();
                switch (request.getParameter("campo")) {
                    case "oferta":
                        where = "where Oferta = 's' and FueraCatalogo = 'n'";
                        request.setAttribute("oferta", true);
                        break;
                    case "categoria":
                        where = "where IdCategoria = '" + request.getParameter("categoria") + "' and FueraCatalogo = 'n'";
                        request.setAttribute("categoriaBuscada", request.getParameter("categoria"));
                        break;
                    case "marca":
                        where = "where IdMarca = '" + request.getParameter("marca") + "' and FueraCatalogo = 'n'";
                        request.setAttribute("marcaBuscada", request.getParameter("marca"));
                        break;
                    case "simple":
                        where = "where p.Denominacion like '%"+request.getParameter("nombre")+"%' and FueraCatalogo = 'n'";
                        break;
                    case "masVendidos":
                        where = "inner join lineaspedidos as l using(IdProducto) where FueraCatalogo = 'n' group by IdProducto order by cantidad desc";
                        break;
                    case "avanzada":
                        where = "";
                        if(!request.getParameter("categoria").equals("-1")){
                            where += "where IdCategoria = '" + request.getParameter("categoria") + "'";
                            request.setAttribute("categoriaBuscada", request.getParameter("categoria"));
                        }
                        if(!request.getParameter("marca").equals("-1")){
                            if(!where.isEmpty()){
                                where += " and ";
                            }else{
                                where = "where ";
                            }
                            where += "IdMarca = '" + request.getParameter("marca") + "'";
                            request.setAttribute("marcaBuscada", request.getParameter("marca"));
                        }
                        if(!request.getParameter("precio").equals("-1")){
                            if(!where.isEmpty()){
                                where += " and ";
                            }else{
                                where = "where ";
                            }
                            where += "PrecioUnitario < "+ request.getParameter("precio");
                            request.setAttribute("precioBuscado", request.getParameter("precio"));
                        }
                        if(request.getParameter("oferta")!=null){
                            if(!where.isEmpty()){
                                where += " and ";
                            }else{
                                where = "where ";
                            }
                            where += "Oferta = 's'";
                            request.setAttribute("oferta", true);
                        }
                        if(!where.isEmpty()){
                                where += " and ";
                            }else{
                                where = "where ";
                            }
                        where += "FueraCatalogo = 'n'";
                        break;
                }
                productos = productodao.getProductos(where);
                salida = "jsp/listaproductos.jsp";
                request.setAttribute("productos", productos);
                break;
        }
        
        categoriadao = DAOFactory.getDAOFactory().getCategoriaDAO();
        categorias = categoriadao.getCategorias("");
        request.setAttribute("categorias", categorias);
        
        marcadao = DAOFactory.getDAOFactory().getMarcaDAO();
        marcas = marcadao.getMarcas("order by Denominacion");
        request.setAttribute("marcas", marcas);

        request.getRequestDispatcher(salida).forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
