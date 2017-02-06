
package es.albarregas.dao;

import es.albarregas.beans.Usuario;
import java.util.ArrayList;


public interface IUsuarioDAO {
    public ArrayList<Usuario> getUsuarios(String where);
    public String anadirUsuario(Usuario usuario);
    public void closeConnection();
}
