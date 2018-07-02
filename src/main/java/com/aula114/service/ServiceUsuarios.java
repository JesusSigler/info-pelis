package com.aula114.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.aula114.model.*;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

//  Nombre del Bean
@ManagedBean(name = "serviceUsuario")
//  El objeto vivira durante el tiempo que la aplicacion permanezca arrancada
@ApplicationScoped
public class ServiceUsuarios implements Serializable {

    private Connection conn;
    private PreparedStatement stmt;
    private List<Usuarios> listaUsuarios;
    private String userCorrecto;
    private String passBuena;
    private String rol;
    private Usuarios u;
    private String nombre;

    //Metodo que permite la conexion
    private void Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas?useSSL=false", "root",
                    "root114");

        } catch (ClassNotFoundException e) {
            System.out.println("No se puede conectar");
        } catch (SQLException e) {
            System.out.println("No se ha importado el driver");
        }
    }

    //Metodo que permite la desconexion de la base de datos
    private void desconectar() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
        Comprueba si existe el usuario por medio de su password, si el password
        introducido corresponde con el de la base de datos sera valido, si no se
        le denegara el acceso
    
     */
    public boolean verificarUsuario(Usuarios u) {

        String sql = "select password, rol from Usuario where nombre = '" + u.getNombre() + "'";
        System.out.println(sql);
        try {
            Conectar();
            stmt = conn.prepareStatement(sql);
            ResultSet rset = stmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {

                    passBuena = rset.getString("password");
                    rol = rset.getString("rol");
                    if (u.getPassword().equals(passBuena)) {
                        return true;
                    }
                }
                rset.close();
            }

        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            desconectar();
        }
        return false;

    }

    /*
        Metodo utilizado durante el registro, en este caso se validara que el
        nombre de usuario no exista para no permitir que al pulsar el boton de
        guardar la web redireccione al login y en cambio permanezca en la vista
        de registro.
     */
    public boolean existeUsuario(Usuarios u) {

        String sql = "select nombre from Usuario where nombre = '" + u.getNombre() + "'";
        System.out.println(sql);
        try {
            Conectar();
            stmt = conn.prepareStatement(sql);
            ResultSet rset = stmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {
                    nombre = rset.getString("nombre");
                    if (u.getNombre().equals(nombre)) {
                        return true;
                    }
                }
                rset.close();
            }

        } catch (SQLException e) {
            // TODO: handle exception
        } finally {
            desconectar();
        }
        return false;

    }
    //Lista los usuarios registrados

    public List<Usuarios> ListaUsuarios() {
        String sql = "select nombre, password, email, rol from Usuario";
        //System.out.println(sql);
        try {
            listaUsuarios = new ArrayList<>();
            Conectar();
            PreparedStatement stmt1 = conn.prepareStatement(sql);
            ResultSet rset = stmt1.executeQuery();
            if (rset != null) {
                while (rset.next()) {
                    u = new Usuarios();
                    u.setNombre(rset.getString("nombre"));
                    u.setPassword(rset.getString("password"));
                    u.setEmail(rset.getString("email"));
                    u.setRol(rset.getString("rol"));
                    listaUsuarios.add(u);
                    //System.out.println("La lista " + listaUsuarios);
                }
                rset.close();

            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            desconectar();
        }
        return listaUsuarios;
    }

    /*
        Metodo utilizado para mostrar el perfil del usuario
     */
    public Usuarios obtenerUsuario(String nombre) {

        String sql = "select nombre, password, email, rol from Usuario where nombre = '" + nombre + "'";
        //System.out.println(sql);
        try {
            Conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rset = stmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {
                    u = new Usuarios();
                    u.setNombre(rset.getString("nombre"));
                    u.setPassword(rset.getString("password"));
                    u.setEmail(rset.getString("email"));
                    u.setRol(rset.getString("rol"));
                }
                rset.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            desconectar();
        }

        return u;

    }

    //Metodo que permite la insercion del usuario
    public void insert(Usuarios u) {
        boolean fila = false;
        try {
            Conectar();

            String sql = "Insert into Usuario (nombre, password, email, rol) values(?,?,?,?)";
            //System.out.println(sql);
            PreparedStatement stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, u.getNombre());
            stmt1.setString(2, u.getPassword());
            stmt1.setString(3, u.getEmail());
            stmt1.setString(4, u.getRol());
            if (!verificarUsuario(u)) {
                fila = stmt1.execute();
            }

            if (fila) {
                System.out.println("Se ha insertado una fila");
            }

        } catch (SQLException e) {

            e.getMessage();
        } finally {
            desconectar();
        }

    }

    //Permite el borrado del usuario
    public void delete(String nombre) {
        try {
            Conectar();
            String sql = "delete from Usuario where nombre = '" + nombre + "'";
            PreparedStatement stmt2 = conn.prepareStatement(sql);
            int numFila = stmt2.executeUpdate();

            if (numFila > 0) {
                System.out.println("Se ha eliminado " + numFila + " fila");
            }

        } catch (SQLException e) {

            e.getMessage();
        } finally {
            desconectar();
        }

    }

    //Permite la actualizcion de los datos del usuario
    public void updateUsuario(Usuarios u) {

        Conectar();

        String sql = "update Usuario set nombre = '" 
                + u.getNombre() 
                + "', password = '" 
                + u.getPassword() 
                + "', email = '" 
                + u.getEmail() 
                + "', rol = '" 
                + u.getRol()
                + "' where nombre =  '" 
                + u.getNombre() + "'";
        //System.out.println(sql);

        try {
            stmt = conn.prepareStatement(sql);

            int fila = stmt.executeUpdate();

            if (fila > 0) {

                //System.out.println("La persona con nombre " + u.getNombre() + ", ha sido modificada correctamente ");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        } finally {
            desconectar();
        }

    }

}
