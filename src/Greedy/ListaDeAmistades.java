package Greedy;

import Grafos.Grafo;
import Grafos.GrafoNoDirigido;

import javax.xml.transform.SourceLocator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class ListaDeAmistades <T>{

    Set<Integer> listaDeAmistades;
    Set<Integer> cubiertos;

    public Set<Integer> getListaDeAmistades(GrafoNoDirigido<T> amistades) {

        while (cubiertos.size() < amistades.cantidadVertices()){

            int personaAmistosa = calcularGrado(amistades);

            listaDeAmistades.add(personaAmistosa);
            cubiertos.add(personaAmistosa);

            for (Iterator<Integer> it = amistades.obtenerAdyacentes(personaAmistosa); it.hasNext(); ) {
                cubiertos.add(it.next());
            }
        }
        return listaDeAmistades;
    }


    private int calcularGrado(Grafo<T> amistades) {
        return 0;
    }


}
