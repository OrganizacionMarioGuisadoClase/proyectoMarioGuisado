/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controladores;

import es.albarregas.beans.Usuario;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mario
 */
@WebServlet(name = "ControlUsuario", urlPatterns = {"/ControlUsuario"})
public class ControlUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String where = "";
        String salida = "";
        IUsuarioDAO usuariodao = DAOFactory.getDAOFactory().getUsuarioDAO();
        ArrayList<Usuario> usuarios;
        Usuario usuario;

        switch (request.getParameter("opcion")) {
            case "entrar":
                where = "inner join clientes on IdUsuario=IdCliente where Email = '" + request.getParameter("email") + "' and Clave = password('" + request.getParameter("password") + "') and Bloqueado='n'";
                usuarios = usuariodao.getUsuarios(where);
                if (usuarios.isEmpty()) {
                    salida = "/jsp/formularioEntrada.jsp";
                    request.setAttribute("errorEntrada", "Usuario o contraseña incorrectos");
                } else {
                    usuario = usuarios.get(0);
                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("USUARIO", usuario);
                }
                break;
            case "registro":
                where = "inner join clientes on IdUsuario=IdCliente where Email = '" + request.getParameter("email") + "'";
                usuarios = usuariodao.getUsuarios(where);
                if (usuarios.isEmpty()) {
                    usuario = new Usuario();
                    usuario.setEmail(request.getParameter("email"));
                    usuario.setClave(request.getParameter("password"));
                    String resultado = usuariodao.anadirUsuario(usuario);
                    if (resultado.equals("error")) {
                        salida = "/jsp/formularioEntrada.jsp";
                        request.setAttribute("errorRegistro", "El Email introducido ya esta dado de alta");
                    } else {
                        salida = "";
                        where = "inner join clientes on IdUsuario=IdCliente where Email = '" + request.getParameter("email") + "' and Clave = password('" + request.getParameter("password") + "')";
                        usuario = usuariodao.getUsuarios(where).get(0);
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("USUARIO", usuario);
                    }
                } else {
                    salida = "/jsp/formularioEntrada.jsp";
                    request.setAttribute("errorRegistro", "El Email introducido ya esta dado de alta");
                }
                break;
        }
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
