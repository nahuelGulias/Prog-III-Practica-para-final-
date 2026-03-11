package Ejercicio8_TPArboles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Biblioteca {
    private int idLibro;
    private HashMap<Integer, Libro> librosPorId;
    private HashMap<String, ArrayList<Libro>> librosPorGenero;
    private TreeMap<Integer, ArrayList<Libro>> librosPorAnio;

    public Biblioteca() {
        this.idLibro = 0;
        this.librosPorId = new HashMap<>();
        this.librosPorGenero = new HashMap<>();
        this.librosPorAnio = new TreeMap<>();
    }

    public void addLibro(Libro libro) {
        if (libro != null) {
            libro.setIdLibro(this.idLibro++);
            librosPorId.put(idLibro++, libro);

            for (String genero : libro.getGeneros()) {
                if (!this.librosPorGenero.containsKey(genero)) {
                    this.librosPorGenero.put(genero, new ArrayList<>());
                }
                this.librosPorGenero.get(genero).add(libro);
            }
            int anio = libro.getAnio();
            if (!this.librosPorAnio.containsKey(anio)) {
                this.librosPorAnio.put(anio, new ArrayList<>());
            }
            this.librosPorAnio.get(anio).add(libro);

        }
    }

    public int getCantLibros(int idLibro) {
        Libro ll = librosPorId.get(idLibro);
        if (ll != null)
            return ll.getCantEjemplares();
        return 0;
    }

    public ArrayList<Libro> getCantLibrosPorGenero(String genero) {
        if (!this.librosPorGenero.containsKey(genero))
            return librosPorGenero.get(genero);
        return new ArrayList<>();
    }

    public ArrayList<Libro> getCantLibrosEntreAnios(int anio1, int anio2) {
        ArrayList<Libro> resultado = new ArrayList<>();

        // subMap devuelve SOLO las claves dentro del rango
        for (ArrayList<Libro> lista : librosPorAnio.subMap(anio1, true, anio2, true).values()) {
            resultado.addAll(lista);
        }

        return resultado;

    }

    
}
