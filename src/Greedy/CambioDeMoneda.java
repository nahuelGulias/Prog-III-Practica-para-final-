package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class CambioDeMoneda {
    ArrayList<Integer> solucion = new ArrayList<>();


    public ArrayList<Integer> solucionGreedy(ArrayList<Integer> monedas, int cantidad) {
        Collections.sort(monedas, Collections.reverseOrder());

        int i = 0;
        while (cantidad > 0 && i < monedas.size()) {

            int valor = monedas.get(i);

            if (valor <= cantidad) {
                solucion.add(valor);
                cantidad -= valor;
            }else
                i++;
        }
        return solucion;
    }


}

