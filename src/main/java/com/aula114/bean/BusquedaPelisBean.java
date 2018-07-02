/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aula114.bean;

import com.aula114.model.Peliculas;
import com.aula114.service.ServicePelis;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alumnado
 */
@SessionScoped
@ManagedBean(name = "busqueda")
public class BusquedaPelisBean {

    private Peliculas peliSeleccionada = new Peliculas();
    private ServicePelis service = new ServicePelis();
    private Peliculas pelicula = new Peliculas();
    private List<Peliculas> allPelis = new ArrayList<>();
    private List<Peliculas> titulos;
    
    public List<Peliculas> completarTitulo(String titulo) {
        allPelis = service.listarPeliculas();
        peliSeleccionada = null;
        titulos = new ArrayList<>();
        for (int i = 0; i < allPelis.size(); i++) {
            Peliculas peli = allPelis.get(i);
            if (peli.getTitulo().toLowerCase().startsWith(titulo)) {
                titulos.add(peli);
            }
        }
        return titulos;
    }

    public String mostrarPeliSeleccionada() {
       for (int i = 0; i < titulos.size(); i++) {
        peliSeleccionada = titulos.get(i);
    }
        pelicula = new Peliculas();
        //titulos = null;
        pelicula = peliSeleccionada;
        peliSeleccionada = new Peliculas();
        return "infoPeli_Buscada.xhtml";
    }

    //GETTER& SETTER
    public Peliculas getPeliSeleccionada() {
        return peliSeleccionada;
    }

    public void setPeliSeleccionada(Peliculas peliSeleccionada) {
        this.peliSeleccionada = peliSeleccionada;
    }

    public ServicePelis getService() {
        return service;
    }

    public void setService(ServicePelis service) {
        this.service = service;
    }

     public Peliculas getPelicula() {
        return pelicula;
    }

    public void setPeli(Peliculas pelicula) {
        this.pelicula = pelicula;
    }

    public List<Peliculas> getAllPelis() {
        return allPelis;
    }

    public void setAllPelis(List<Peliculas> allPelis) {
        this.allPelis = allPelis;
    }

    public List<Peliculas> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Peliculas> titulos) {
        this.titulos = titulos;
    }
    
}
