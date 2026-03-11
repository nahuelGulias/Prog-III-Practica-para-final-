package Arboles.Ejercicios;

import Arboles.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ObtenerNivel <T>{

    public ArrayList<Integer> getValores(TreeNode<T> node, int k){
        if(node == null)
            return null;
       ArrayList<Integer> listado = new ArrayList<>();
        solucion(node, k, 0, listado);
        return listado;

    }

    private void solucion(TreeNode<T> node, int k, int i, ArrayList<Integer> listado) {

        if (node == null)
            return;

        if (i == k) {
            listado.add(node.getInfo());
        }

       solucion(node.getRight(), k, i, listado);
       solucion(node.getLeft(), k, i, listado);

    }


}
