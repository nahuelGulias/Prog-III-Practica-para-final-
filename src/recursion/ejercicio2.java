package recursion;
//Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado ascendentemente.
public class ejercicio2 {

    public boolean searchElement( int element, int[] array, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (array[mid] == element) {
            return true;
        }
        if( element < array[mid]) {
            return searchElement(element,array,left,mid);
        }
        return searchElement(element,array,mid+1,right);
    }
}
