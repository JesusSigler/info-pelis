/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aula114.bean;

import com.aula114.service.ServicePelis;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import com.aula114.model.Peliculas;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Jesús Sigler
 */
@ManagedBean(name = "pelicula")
@SessionScoped
public class PeliculasBean implements Serializable {

    //@ManagedProperty("#{ServicePelis}")
    private ServicePelis servicePelis = new ServicePelis();
    private Peliculas peli = new Peliculas();
    private List<Peliculas> listaPelis = new ArrayList<>();
    private List<Peliculas> filterPelis = new ArrayList<>();
    private List<Peliculas> listaGenero = new ArrayList<>();

    private boolean edit;
    //Ruta desde donde se obtiene la imagen
    String origen = "../../Escritorio/";
    //"/home/alumnado/Escritorio/";
    //ruta a donde se quiere copiar la imagen
    String destino1 = "../../NetBeansProjects/Peliculasv3/src/main/webapp/resources/imagenes/pelis/"; 
    //"../../../peliculas/resources/imagenes/pelis/"; 
    
    //metodo que se carga al inicio del despliegue de la aplicacion
    @PostConstruct
    public void init() {
        listaPelis = servicePelis.listarPeliculas();
        generarListaGeneros();
    }
    //Genera la lista de generos disponibles de las peliculas
    private void generarListaGeneros() {
        Map<String, Peliculas> genero = new HashMap<String, Peliculas>(listaPelis.size());
        for (Peliculas p : listaPelis) {
            genero.put(p.getGenero(), p);
        }
        for (Entry<String, Peliculas> p : genero.entrySet()) {
            this.listaGenero.add(p.getValue());
        }
    }

    public List<Peliculas> getListarPelisPorGenero() {
        String genero = peli.getGenero();
        servicePelis.listarPeliculasPorGenero(genero);
        return servicePelis.getListaPorGenero();
    }

    public String mostrarPelicula(Peliculas pelicula) {
        this.peli = pelicula;
        return "infoPeli.xhtml";
    }

    public void copyFile(String fileName, InputStream in) {
        //se obtiene la raiz del proyecto
        //String absolutePath = "/"+FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(destino1);
        //System.out.println(absolutePath);
        File file = new File(destino1);
        try {
            OutputStream out = new FileOutputStream(new File(origen + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            String ruta1 = origen + fileName;
            String ruta2 = file + "/" + fileName;
            File archivo = new File(ruta1);
            archivo.renameTo(new File(ruta2));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    //Se encarga de setear el objeto imagen para ser insertada en la base de datos
    public void subirImagen(FileUploadEvent event) {
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            String imagen = event.getFile().getFileName();
            String nombreImagen = imagen.substring(0, imagen.lastIndexOf('.'));
            peli.setImagen(nombreImagen);
            FacesMessage message = new FacesMessage("El archivo se ha subido con éxito!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Para limpiar los campos del formulario de insersion
    public String nuevaPeli() {
        peli = new Peliculas();
        return "nuevaPeli";
    }
    //Llama al metodo insertar y refresca la lista de peliculas
    public String add() {
        listaPelis.add(peli);
        servicePelis.insert(peli);
        peli = new Peliculas();
        listaPelis = servicePelis.listarPeliculas();
        return "gestionPeliculas";
    }

    /*
        Metodo que permite recoger los datos de la pelicula seleccionada para ser 
        editada en la tabla y permitira editar los campos.    
     */
    public void edit(Peliculas pelicula) {
        this.peli = pelicula;
        edit = true;
    }

    /*
        Metodo que guardara los datos ya editados.    
     */
    public void save() {
        servicePelis.updatePelis(peli);
        listaPelis = servicePelis.listarPeliculas();
        edit = false;
    }

    //Metodo para eliminar la pelicula seleccionada
    public void delete(Peliculas peli) {
        listaPelis.remove(peli);
        servicePelis.delete(peli.getIdPelicula());
        listaPelis = servicePelis.listarPeliculas();
    }

    //Getter & Setter
    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public List<Peliculas> getListaPelis() {
        return listaPelis;
    }

    public void setListaPelis(List<Peliculas> listaPelis) {
        this.listaPelis = listaPelis;
    }

    public ServicePelis getServicePelis() {
        return servicePelis;
    }

    public void setServicePelis(ServicePelis servicePelis) {
        this.servicePelis = servicePelis;
    }

    public Peliculas getPeli() {
        return peli;
    }

    public void setPeli(Peliculas peli) {
        this.peli = peli;
    }

    public List<Peliculas> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<Peliculas> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public List<Peliculas> getFilterPelis() {
        return filterPelis;
    }

    public void setFilterPelis(List<Peliculas> filterPelis) {
        this.filterPelis = filterPelis;
    }
}
