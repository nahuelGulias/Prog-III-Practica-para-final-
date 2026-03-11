package Ejercicio8_TPArboles;

import java.util.ArrayList;

/*
(título, autor, géneros, año de publicación, cantidad de ejemplares, etc.)
 */
public class Libro {
    private int idLibro;
    private String titulo;
    private String autor;
    private ArrayList<String> generos;
    private int anio;
    private int cantEjemplares = 0;

    public Libro(String titulo, String autor, int anio, int cantEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.generos = new ArrayList<>();
        this.cantEjemplares = cantEjemplares;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
       this.cantEjemplares = cantEjemplares;
    }

    public ArrayList<String> getGeneros() {
        return new ArrayList<>(generos);
    }
}
