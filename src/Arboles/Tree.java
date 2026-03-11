package Arboles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree<T> {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getInfo() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getInfo() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public TreeNode getRoot(){
        if(this.root!=null)
            return this.root;
        return null;
    }

    public boolean hasElement(TreeNode actual, int value){
        if(actual == null)
            return false;

        if(actual.getInfo() == value)
            return true;

        if(actual.getInfo() > value)
            return hasElement(actual.getLeft(),value);
        else
            return hasElement(actual.getRight(),value);
    }

    public int getHeight (TreeNode<T> node) {
        if (node == null)
            return -1;

        int alturaIzquierda = getHeight(node.getLeft());
        int alturaDerecha = getHeight(node.getRight());

        if(alturaIzquierda > alturaDerecha)
            return 1 + alturaIzquierda;
        else
            return 1 + alturaDerecha;
    }

    public List<Integer> getLongestBranch(TreeNode<T> node) {
        List<Integer> longestBranch = getLongestBranchR(node);
        return longestBranch;

    }
    private List<Integer> getLongestBranchR(TreeNode<T> node) {
        if (node == null)
            return new LinkedList<>();

        List<Integer> branchRight = getLongestBranchR(node.getRight());
        List<Integer> branchLeft = getLongestBranch(node.getLeft());

        if (branchRight.size() > branchLeft.size()) {
            branchRight.add(0, node.getInfo());
            return branchRight;
        } else{
            branchLeft.add(0,node.getInfo());
            return branchLeft;
        }
    }
    
    public List<Integer> getFrontera(TreeNode<T> node) {
        List<Integer> fronteral = getFronteraR(node);
        return fronteral;
    }
    private List<Integer> getFronteraR(TreeNode<T> node) {
        if (node == null)
            return new LinkedList<>();


        LinkedList<Integer> frontera = new LinkedList<>();
        if (node.getLeft() == null && node.getRight() == null) {
            frontera.add(node.getInfo());
            return frontera;
        }

        frontera.addAll(getFronteraR(node.getLeft()));
        frontera.addAll(getFronteraR(node.getRight()));


        return frontera;
    }

    public int getMaxElement(TreeNode<T> node) {
        return getMaxElementR(node);
    }
    // El valor más a la derecha será el mayor
    private int getMaxElementR(TreeNode<T> node) {
      if (node == null)
          return -1;

      if(node.getRight() == null){
          return node.getInfo();
      }

      return getMaxElementR(node.getRight());
    }

    public LinkedList<Integer> getElementAtLevel(TreeNode<T> node, int level){
        int count = 0;
        LinkedList<Integer> list = getElementAtLevelR(node,level,count);
        return list;
    }

    private LinkedList<Integer> getElementAtLevelR(TreeNode<T> node, int level, int count) {
        if (node == null)
            return new LinkedList<>();

        LinkedList<Integer> retorno = new LinkedList<>();

        if(level == count){
            retorno.add(node.getInfo());
            return retorno;
        }

        retorno.addAll(getElementAtLevelR(node.getLeft(),level,count+1));
        retorno.addAll(getElementAtLevelR(node.getRight(),level,count+1));

        return retorno;
    }

    public void imprimirPosOrden(TreeNode<T> node){
        if (node == null)
            return;
        imprimirPosOrden(node.getLeft());
        imprimirPosOrden(node.getRight());
        System.out.print(node.getInfo() + " ");
    }

    public void imprimirPreOrden(TreeNode<T> node){
        if (node == null)
            return;
        System.out.println(node.getInfo() + " ");
        imprimirPreOrden(node.getLeft());
        imprimirPreOrden(node.getRight());
    }

    public void imprimirInOrden(TreeNode<T> node){
        if (node == null)
            return;
        imprimirInOrden(node.getLeft());
        System.out.print(node.getInfo() + " ");
        imprimirInOrden(node.getRight());
    }

    public  boolean borrar(int value) {
        if (root == null) {
            System.out.println("Arbol vacio");
            return false;
        }
        if (!hasElement(root, value)) {
            return false;
        }
        root = borrarR(this.root, value);
        return true;
    }

    private TreeNode<T> borrarR(TreeNode<T> cursor, int value) {
        if (cursor == null)
            return null;

        if (value < cursor.getInfo()) {
            cursor.setLeft(borrarR(cursor.getLeft(),value)); // reconstruye el camino de vuelta por izquierda
        }
        else if (value > cursor.getInfo()) {
            cursor.setRight(borrarR(cursor.getRight(),value)); // reconstruye el camino de vuelta por derecha
        }
        else{
            // Es una hoja
            if(cursor.getLeft() == null && cursor.getRight() == null){
                return null; // acomodo el puntero que va del padre al hijo
            }
            // Tiene un hijo al menos
            if(cursor.getLeft() == null || cursor.getRight() == null){
                if(cursor.getLeft() == null){ // si no tengo izquierda
                    return cursor.getRight(); // devuelvo mi nuevo valor
                }
                else{
                    return cursor.getLeft(); // tengo izquierda, la devuelvo, es decir no tengo derecha, mi nuevo valor es mi hijo a derecha
                }
            } else{ //Caso de dos hijos
                int replace = buscarReemplazo(cursor.getRight()); // busco mi valor reemplazante
                cursor.setInfo(replace); // reemplazo
                cursor.setRight(borrarR(cursor.getRight(),replace)); // me llamo desde mi derecha para borrar el duplicado
            }
        }
        return cursor;
    }

    private int buscarReemplazo(TreeNode<T> cursor) {
        while (cursor.getLeft() != null){
            cursor = cursor.getLeft();
        }
        return cursor.getInfo();
    }


    /*Ejercicio 2 Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo que retorne la suma de todos los nodos internos del árbol. */
    public int getSumaTotal(){
        int count = 0;
        count += getSumaTotalR(root);
        return count;
    }

    private int getSumaTotalR(TreeNode<T> node) {
        if (node == null)
            return 0;


        int sum = node.getInfo();
        sum += getSumaTotalR(node.getLeft());
        sum += getSumaTotalR(node.getRight());

        return sum;

    }

          /*
    Ejercicio 3
    Dado un árbol binario de búsqueda que almacena números enteros y un valor de entrada K, implementar un algoritmo que permita
    obtener un listado con los valores de todas las hojas cuyo valor supere K.
    Por ejemplo, para el árbol de la derecha, con un valor K = 8, el resultado debería ser [9, 11].
    */

    public LinkedList<T> getListadoDeHojasQueSuperanK(int k){
        LinkedList<T> listado = new LinkedList<>();
        if (root == null)
            return null;
        listado = getListadoDeHojasQueSuperanKR(this.root,k);
        return listado;
    }

    private LinkedList<Integer> getListadoDeHojasQueSuperanKR(TreeNode<T> cursor, int k) {
        LinkedList<Integer> listado = new LinkedList<>();
        if (cursor == null)
            return new LinkedList<>();


        if(cursor.getLeft() == null && cursor.getRight() == null){
            if(cursor.getInfo() > k){
                listado.add(cursor.getInfo());
                return listado;
            }
        }
        listado.addAll(getListadoDeHojasQueSuperanKR(cursor.getLeft(),k));
        listado.addAll(getListadoDeHojasQueSuperanKR(cursor.getRight(),k));

        return listado;

    }

    /*
    Se posee un árbol binario (no de búsqueda), donde los nodos internos están vacíos, mientras que las hojas tienen valores enteros.
    Se debe implementar un método que recorra el árbol y coloque valores en los nodos vacíos (los nodos internos).
    El valor de cada nodo interno debe ser igual al valor de su hijo derecho, menos el valor de su hijo izquierdo.
    En caso de que el nodo tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0.
     */

    public void armarArbol(){
        armarArbol(root);
    }
    private int armarArbol(TreeNode<T> cursor){
        if (cursor == null)
            return 0;

        if (cursor.getLeft() == null && cursor.getRight() == null) {
            return cursor.getInfo();
        }
        int valorIzquierdo = armarArbol(cursor.getLeft());
        int valorDerecho = armarArbol(cursor.getRight());

        int valor = valorIzquierdo - valorDerecho;
        cursor.setInfo(valor);
        return valor;
    }


    /*
    Dado un árbol binario donde todos los nodos poseen un carácter, de manera que cada rama del árbol contiene una palabra,
    implementar un algoritmo que busque y retorne todas las palabras que posea exactamente N vocales (ni más ni menos).
    Por ejemplo, para el siguiente árbol, con una entrada de N = 1, el algoritmo debería retornar [“MAL”].
    En cambio, para un N = 2, debería retornar [“MANA”, “MANO”, “MISA”, “MIO”].
    */
    public LinkedList<String> getPalabras(int n){
        LinkedList<String> listado = new LinkedList<>();
        if (root == null)
            getPalabrasR(this.root,n, "" ,0,listado);
        return listado;
    }

    private void getPalabrasR(TreeNode<T> cursor, int n, String palabraActual , int count, LinkedList<String> listado) {
//        if(cursor == null)
//            return;
//
//        String letra = cursor.getInfo().toString();
//        palabraActual += letra;
//
//        if (esVocal(letra))
//            count++;
//
//        if(cursor.getLeft() == null && cursor.getRight() == null){
//            if (count == n){
//                listado.add(palabraActual);
//            }
//        }
//
//        getPalabrasR(cursor.getLeft(),n, palabraActual, count, listado);
//        getPalabrasR(cursor.getRight(),n, palabraActual, count, listado);

    }

    private boolean esVocal(String letra){
        String palabra = "aeiouAEIOU";
        return palabra.contains(letra);
    }






// Escriba un algoritmo en JAVA que dado un árbol de búsqueda binario y dos valores de umbral M y N retorne una lista de
// todos los valores en el rango [M, N] contenidos en el árbol. La lista resultante debe estar ordenada de menor a mayor.
    public ArrayList<Integer> getValoresEnRango(TreeNode<T> root, int m, int n) {
        ArrayList<Integer> resultado = new ArrayList<>();
        obtenerEnRango(root, m, n, resultado);
        return resultado;
    }

    public void obtenerEnRango(TreeNode<T> root, int m, int n, ArrayList<Integer> valoresEnRango) {

        if(root == null)
            return;

        // Si el valor es mayor que m, puede haber valores válidos a la izquierda
        if (root.getInfo() > m)
            getValoresEnRango(root.getLeft(),m,n);

        if(root.getInfo() >= m && root.getInfo() <= n){
            valoresEnRango.add(root.getInfo());
        }

        // Si el valor es menor que n, puede haber valores válidos a la derecha
        if(root.getInfo() < n)
            getValoresEnRango(root.getRight(),m,n);

    }





}
