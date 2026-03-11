package Backtracking;

import Grafos.BreadthFirstSearch;

import java.util.ArrayList;

public class ConfigDeCuadricula {
    int[] sumaFilas, sumaColumnas;

    public int[][] existeConfiguracion(int[][] mat, ArrayList<Integer> lista, int f, int c) {
        solucion(mat, lista, 0, 0, f, c);
        return mat;
    }


    private void solucion(int[][] mat, ArrayList<Integer> lista, int fila, int col, int maxFila, int maxCol) {
        if (fila == mat.length) {
            return;
        }
        int sigFila = fila;// 0-1-N
        int sigCol = col + 1;

        if (sigCol == mat[0].length) {
            sigCol = 0;
            sigFila++;
        }

        for (int i = 0; i < lista.size()-1; i++) {

            int m = lista.get(i);

            mat[fila][col] = m; // sigCol me asegura tener el actual de la fila(c)
            sumaFilas[fila] += m;
            sumaColumnas[col] += m;

            if (sumaFilas[fila] > maxFila) {
                sumaFilas[fila] -= m;
                sumaColumnas[col] -= m;
                mat[fila][col] = 0;
                continue;
            }

            if (fila == mat.length - 1 && sumaColumnas[col] < maxCol) {
                sumaColumnas[col] -= m;
                sumaFilas[fila] -= m;
                mat[fila][col] = 0;
                continue;
            }
            lista.remove(i);
            solucion(mat, lista, sigFila, sigCol, maxFila, maxCol);
            lista.add(i, m);
            mat[fila][col] = 0;
            sumaColumnas[col] -= m;
            sumaFilas[fila] -= m;
        }
    }
}

