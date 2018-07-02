package com.aula114.model;

/**
 *
 * @author Jesús Sigler
 */
public class Slider {
    private String foto;
    private String nombre;
    private String descripcion;

    public Slider(String foto, String nombre, String descripcion) {
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Foto:" + foto + "\nNombre: " + nombre + "\nDescripcion: " + descripcion + '\n';
    }
    
    
}
