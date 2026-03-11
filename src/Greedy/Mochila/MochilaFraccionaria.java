package Greedy.Mochila;

import java.util.ArrayList;
import java.util.Collections;

public class MochilaFraccionaria {

    ArrayList<ObjetoMochila> mochila = new ArrayList<>();


    public ArrayList<ObjetoMochila> getMochilaFraccionaria(ArrayList<ObjetoMochila> objetos, int capacidad) {

        Collections.sort(objetos);

        int i = 0;

        ObjetoMochila obj = objetos.get(i);

        while (i < objetos.size() && capacidad > 0 ) {

            if (obj.getPeso() <= capacidad) {
                mochila.add(obj);
                capacidad -= obj.getPeso();

            } else {
                double fraccion = (double) capacidad / obj.getPeso();
                double nuevoValor =  obj.getValor()*fraccion;
                mochila.add(new ObjetoMochila((int) nuevoValor, capacidad));
                capacidad = 0;
            }
            i++;

        }
        return mochila;
    }


}
