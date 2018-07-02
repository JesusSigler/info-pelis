package com.aula114.service;

import com.aula114.model.Peliculas;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedProperty;

@ApplicationScoped
public class ServicePelis implements Serializable {

    private Peliculas p;
    private List<Peliculas> listaPelis;
    private List<Peliculas> listaPorGenero;
    List<Peliculas> listaPorTitulo;
    private Connection conn;
    private PreparedStatement stmt;

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

    public List<Peliculas> listarPeliculas() {
        String sql = "select idPelicula,titulo,psinosis,imagen,genero,trailer,a\u00f1o from Peliculas";
        try {
            listaPelis = new ArrayList<>();
            Conectar();
            stmt = conn.prepareStatement(sql);
            //System.out.println(sql);
            ResultSet rset = stmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {
                    p = new Peliculas();
                    p.setIdPelicula(rset.getInt("idPelicula"));
                    p.setTitulo(rset.getString("titulo"));
                    p.setPsinosis(rset.getString("psinosis"));
                    p.setImagen(rset.getString("imagen"));
                    p.setGenero(rset.getString("genero"));
                    p.setTrailer(rset.getString("trailer"));
                    p.setAnio(rset.getInt("a\u00f1o"));
                    listaPelis.add(p);
                    //System.out.println("La lista " + listaPelis);
                }
                rset.close();

            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            desconectar();
        }
        return listaPelis;
    }

    public List<Peliculas> listarPeliculasPorGenero(String genero) {
        String sql = "select idPelicula,titulo,psinosis,imagen,genero,trailer,a\u00f1o from Peliculas where genero = '" + genero + "'";
        try {
            listaPorGenero = new ArrayList<>();
            Conectar();
            stmt = conn.prepareStatement(sql);
            //System.out.println(sql);
            ResultSet rset = stmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {
                    p = new Peliculas();
                    p.setIdPelicula(rset.getInt("idPelicula"));
                    p.setTitulo(rset.getString("titulo"));
                    p.setPsinosis(rset.getString("psinosis"));
                    p.setImagen(rset.getString("imagen"));
                    p.setGenero(rset.getString("genero"));
                    p.setTrailer(rset.getString("trailer"));
                    p.setAnio(rset.getInt("a\u00f1o"));
                    listaPorGenero.add(p);
                    //System.out.println("La lista " + listaPelis);
                }
                rset.close();

            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            desconectar();
        }
        return listaPelis;
    }

    /*public Peliculas mostrarPelicula(int id) {

        String sql = "select titulo,psinosis,imagen,genero,trailer,a\u00f1o from Peliculas from idPelicula = " + id;
        try {
            Conectar();
            stmt = conn.prepareStatement(sql);
            //System.out.println(sql);
            ResultSet rset = stmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {

                    p = new Peliculas();
                    p.setTitulo(rset.getString("titulo"));
                    p.setPsinosis(rset.getString("psinosis"));
                    p.setImagen(rset.getString("imagen") + ".jpg");
                    p.setGenero(rset.getString("genero"));
                    p.setTrailer(rset.getString("trailer"));
                    p.setAnio(rset.getInt("a\u00f1o"));
                }
                rset.close();

            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            desconectar();
        }
        return p;
    }*/

    /*public List<Peliculas> buscarPeliculaPorTitulo(String titulo) {

        String sql = "select idPelicula,titulo,psinosis,imagen,genero,trailer,a\u00f1o from Peliculas from idPelicula = '" + titulo + "'";
        try {
            listaPorTitulo = new ArrayList<>();
            Conectar();
            stmt = conn.prepareStatement(sql);
            //System.out.println(sql);
            ResultSet rset = stmt.executeQuery();
            if (rset != null) {
                while (rset.next()) {
                    p = new Peliculas();
                    p.setIdPelicula(rset.getInt("idPelicula"));
                    p.setTitulo(rset.getString("titulo"));
                    p.setPsinosis(rset.getString("psinosis"));
                    p.setImagen(rset.getString("imagen") + ".jpg");
                    p.setGenero(rset.getString("genero"));
                    p.setTrailer(rset.getString("trailer"));
                    p.setAnio(rset.getInt("a\u00f1o"));
                    if (p.getTitulo().startsWith(titulo)) {
                        listaPorTitulo.add(p);
                    }

                }
                rset.close();

            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            desconectar();
        }
        return listaPorTitulo;
    }*/

    //Metodo que permite la insercion del usuario
    public void insert(Peliculas p) {
        boolean fila;
        try {
            Conectar();

            String sql = "Insert into Peliculas (titulo, psinosis, imagen, genero, trailer, a\u00f1o) values(?,?,?,?,?,?)";
            PreparedStatement stmt1 = conn.prepareStatement(sql);
            stmt1.setString(1, p.getTitulo());
            stmt1.setString(2, p.getPsinosis());
            stmt1.setString(3, p.getImagen());
            stmt1.setString(4, p.getGenero());
            stmt1.setString(5, p.getTrailer());
            stmt1.setInt(6, p.getAnio());

            fila = stmt1.execute();
            System.out.println(sql);
            if (fila) {
                System.out.println("Se ha insertado una fila");
            }

        } catch (SQLException e) {

            e.getMessage();
        } finally {
            desconectar();
        }

    }

    //Permite la actualizacion de los datos del usuario
    public void updatePelis(Peliculas p) {

        Conectar();

        String sql = "update Peliculas set titulo = '" + p.getTitulo()
                + "', psinosis = '" + p.getPsinosis()
                + "', imagen = '" + p.getImagen()
                + "', genero = '" + p.getGenero()
                + "', trailer = '" + p.getTrailer()
                + "', a\u00f1o = " + p.getAnio()
                + " where idPelicula =  " + p.getIdPelicula();
        System.out.println(sql);

        try {
            stmt = conn.prepareStatement(sql);

            int fila = stmt.executeUpdate();

            if (fila > 0) {

                System.out.println("La persona con nombre " + p.getTitulo() + ", ha sido modificada correctamente ");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        } finally {
            desconectar();
        }

    }

    //Permite el borrado de la pelicula
    public void delete(int id) {
        try {
            Conectar();
            String sql = "delete from Peliculas where idPelicula = '" + id + "'";
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

    public Peliculas getP() {
        return p;
    }

    public void setP(Peliculas p) {
        this.p = p;
    }

    public List<Peliculas> getListaPelis() {
        return listaPelis;
    }

    public void setListaPelis(List<Peliculas> listaPelis) {
        this.listaPelis = listaPelis;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public List<Peliculas> getListaPorGenero() {
        return listaPorGenero;
    }

    public void setListaPorGenero(List<Peliculas> listaPorGenero) {
        this.listaPorGenero = listaPorGenero;
    }

    public List<Peliculas> getListaPorTitulo() {
        return listaPorTitulo;
    }

    public void setListaPorTitulo(List<Peliculas> listaPorTitulo) {
        this.listaPorTitulo = listaPorTitulo;
    }
    
    
}
