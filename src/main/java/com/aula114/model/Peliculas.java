package com.aula114.model;

import java.io.Serializable;

public class Peliculas implements Serializable {

    private int idPelicula;
    private String titulo;
    private String psinosis;
    private String imagen;
    private String genero;
    private String trailer;
    private int anio;

    public Peliculas() {
    }

    public Peliculas(int idPelicula, String titulo, String psinosis, String imagen, String genero,String trailer, int anio) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.psinosis = psinosis;
        this.imagen = imagen;
        this.genero = genero;
        this.trailer = trailer;
        this.anio = anio;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPsinosis() {
        return psinosis;
    }

    public void setPsinosis(String psinosis) {
        this.psinosis = psinosis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "ID: " + idPelicula + "\nTitulo: " + titulo + "\nPsinosis: " + psinosis + "\nImagen: " + imagen + "\nGenero:" + genero + "\nTrailer: "+ trailer + "\na\u00f1o: " + anio + '}';
    }

}
