package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO implements IUsuarioDAO {

    private PreparedStatement preparada = null;
    private ResultSet resultado = null;

    @Override
    public ArrayList<Usuario> getUsuarios(String where) {
        ArrayList<Usuario> usuarios = new ArrayList();
        Usuario usuario = null;
        Cliente cliente = null;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM usuarios " + where + ";");
            resultado = preparada.executeQuery();

            while (resultado.next()) {
                usuario = new Usuario();
                cliente = new Cliente();
                usuario.setIdUsuario(resultado.getInt("IdUsuario"));
                usuario.setClave(resultado.getString("Clave"));
                usuario.setUltimoAcceso(resultado.getDate("UltimoAcceso"));
                usuario.setTipo(resultado.getString("Tipo").charAt(0));
                usuario.setBloqueado(resultado.getString("Bloqueado").charAt(0));
                usuario.setEmail(resultado.getString("Email"));
                cliente.setIdCliente(resultado.getInt("IdCliente"));
                cliente.setNombre(resultado.getString("Nombre"));
                cliente.setApellidos(resultado.getString("Apellidos"));
                cliente.setNif(resultado.getString("NIF"));
                cliente.setFechaNacimiento(resultado.getDate("FechaNacimiento"));
                cliente.setFechaAlta(resultado.getDate("FechaAlta"));
                usuario.setCliente(cliente);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            System.out.println("Error al crear sentencia");
            ex.printStackTrace();
        }

        try {
            if (preparada != null) {
                preparada.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.closeConnection();

        return usuarios;
    }
    
    @Override
    public String anadirUsuario(Usuario usuario){
        String error = "";
        String sentencia = "insert into usuarios values (0,password(?),now(),'u','n',?);";
        
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sentencia);
            preparada.setString(1, usuario.getClave());
            preparada.setString(2, usuario.getEmail());
            preparada.executeUpdate();
            
            sentencia = "insert into clientes values (0,'nombre','apellidos','nif',null,now());";
            preparada = ConnectionFactory.getConnection().prepareStatement(sentencia);            
            preparada.executeUpdate();            

        } catch (SQLException ex) {
            System.out.println("Error al crear sentencia");
            error = "error";
            ex.printStackTrace();
        }

        try {
            if (preparada != null) {
                preparada.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.closeConnection();
        return error;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
