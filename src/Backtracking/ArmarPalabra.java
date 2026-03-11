package Backtracking;

import java.util.ArrayList;

public class ArmarPalabra {
    ArrayList<String> list;
  //  Diccionario diccionario;
    boolean[] usados;

    public ArrayList<String> getPalabras(String[] letras, int maxLetras) {
        back(letras, maxLetras, " ");
        return list;
    }

    private void back(String[] letras, int maxLetras, String palabraActual) {
        if (palabraActual.length() == maxLetras){// && Diccionario.esPalabraValida(palabraActual)) {
            list.add(palabraActual);
            return;
        }

        for (int i = 0; i < letras.length; i++) {

            if (!usados[i]) {
                String letra = letras[i];

                if (palabraActual.isEmpty() && esVocal(letra))
                    continue;
                
                usados[i] = true;

                back(letras, maxLetras, palabraActual + letra);

                usados[i] = false;
            }
        }
    }

    private boolean esVocal(String letra) {
        return "aeiouAEIOU".contains(letra);
    }
}
