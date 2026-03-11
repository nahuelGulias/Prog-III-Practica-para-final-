package recursion;
//Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado
public class ejercicio1 {
    int [] array;
    boolean isOrder;

    public ejercicio1() {
        this.array = new int[] {2,4,5,7,9,10};
        this.isOrder = false;
    }

    public boolean isOrder(int index, int [] arr) {
        if (index == arr.length - 1) {
            return true;
        }
        if (arr[index] >= this.array[index + 1]) {
            return isOrder(index + 1, arr);
        } else {
            return false;
        }
    }
}
