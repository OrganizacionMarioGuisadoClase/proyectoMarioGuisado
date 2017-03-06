package es.albarregas.controladores;

import es.albarregas.beans.Categoria;
import es.albarregas.beans.Producto;
import es.albarregas.dao.ICategoriaDAO;
import es.albarregas.dao.IProductoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PeticionAjax", urlPatterns = {"/PeticionAjax"})
public class PeticionAjax extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Variables que voy a usar
        String respuesta = ""; // En donde mandaré la respuesta
        String where = ""; // En donde escribiré la clausula where de las consultas
        IProductoDAO productodao; // Objeto para consultar productos
        ICategoriaDAO categoriadao; // Objeto para consultar categorias
        ArrayList<Producto> productos; // Donde almacenare el resultado de la consulta a productos
        ArrayList<Categoria> categorias; // Donde almacenare el resultado de la consulta a categorias

        // Compruebo que peticion viene de ayax y decido que hacer
        if (request.getParameter("peticion") != null) {
            switch (request.getParameter("peticion")) {

                // En caso de que pida llenar el menu categorias
                case "menuCategorias":
                    categoriadao = DAOFactory.getDAOFactory().getCategoriaDAO();
                    categorias = categoriadao.getCategorias(where);
                    // Monto el JSON que mandaré de respuesta con la informacion que me viene de la base de datos
                    respuesta = "[";
                    for (Categoria c : categorias) {
                        respuesta += "{\"idCategoria\":\"" + c.getIdCategoria() + "\",\"nombre\":\"" + c.getNombre() + "\"},";
                    }
                    respuesta = respuesta.substring(0, respuesta.length() - 1).concat("]");
                    break;
            }
            // Mando la respuesta
            response.getWriter().append(respuesta);
        }
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
