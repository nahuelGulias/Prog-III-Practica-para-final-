package listas;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public void insertInOrder(T info) { //ejemplo de llegada 1ro 3 2do 2 3ro 9 4to 5
        Node<T> newNodo = new Node<>(info,null);
        //ordena ascendente
        //suponiendo la llegada del 5 con la lista en este punto {{9->3->2}}
        if (this.first == null || info.compareTo(first.getInfo()) >= 0) {
            insertFront(newNodo.getInfo());
            return;
        }
        Node<T> aux = this.first; // = 9
        // sig de 9 -> 3
        // (5).compareTo(3) < 0 = 1 --> resultado => no entra
        while (aux.getNext() != null && info.compareTo(aux.getNext().getInfo()) < 0) {
            aux = aux.getNext();
        }
        // tampoco entra aca ya que a 9 le sigue 3
        if(aux.getNext() == null){
            aux.setNext(newNodo);
        }
        else{
            // newNodo(5) -> aux.setNext() aux= 9 next = 3
            newNodo.setNext(aux.getNext());
            // a este punto la lista queda => {9->5->3->2}
            aux.setNext(newNodo);
        }

    }


    public T extractFront() {
        if(this.first == null)
            return null;
        T tmp = this.first.getInfo();
        this.first = this.first.getNext();
        this.size--;
        return tmp;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
       int i = 0;
       Node<T> tmp = this.first;
       while (i <= index) {
           if(tmp != null)
            tmp = tmp.getNext();
           i++;
       }
       return tmp.getInfo();
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Node<T> tmp = this.first;
        String str = "";
        while (tmp != null) {
            str += tmp.getInfo();
            if(tmp.getNext() != null) {
                str += ", ";
            }
            tmp = tmp.getNext();

        }
        return str;
    }

    /*
    A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método int indexOf(T),
    que reciba un elemento y retorne el índice donde está almacenado ese elemento, o -1 si el elemento no existe en la lista.
     */
    public int indexOf(T info){
        Node<T> tmp = this.first;
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if(tmp != null && !tmp.getInfo().equals(info)) {
                tmp = tmp.getNext();
                index++;
            }
        }
        if(tmp == null)
            return -1;
        else
            return index;
    }

    //  dadas dos listas construya otra con los elementos comunes, suponiendo que:
    //
    //  a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
    public MySimpleLinkedList<T> construirListaOrdenada(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {

        MySimpleLinkedList<T> retorno = new MySimpleLinkedList<>();
        MyIterator<T> it1 = new MyIterator<>(lista1.getFirst());
        while (it1.hasNext()) {
            T next1 = it1.next();
            MyIterator<T> it2 = new MyIterator<>(lista2.getFirst());
            while (it2.hasNext()) {
                T next2 = it2.next();
                if (next1.equals(next2)) {
                    retorno.insertInOrder(next1);
                        break;
                }

            }
        }
        return retorno;
    }

    //b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada
    public MySimpleLinkedList<T> construirListaManteniendoElOrden(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
        MySimpleLinkedList<T> retorno = new MySimpleLinkedList<>();
        MyIterator<T> it1 = new MyIterator<>(lista1.getFirst());
        while (it1.hasNext()) {
            T info1 = it1.next();
            MyIterator<T> it2 = new MyIterator<>(lista2.getFirst());
            while (it2.hasNext()) {
                T info2 = it2.next();
                if (info1.equals(info2)) {
                    retorno.insertFront(info1);
                    break;
                }
                if(info1.compareTo(info2)<0){
                    break;
                }
            }
        }
        return retorno;
    }

    // dadas dos listas construya otra con los elementos que están en la primera pero no en la segunda.
    public MySimpleLinkedList<T> construirListaUnica(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
        MySimpleLinkedList<T> retorno = new MySimpleLinkedList<>();
        MyIterator<T> it1 = new MyIterator<>(lista1.getFirst());
        boolean encontrado;
        while (it1.hasNext()) {
            T info1 = it1.next();
            MyIterator<T> it2 = new MyIterator<>(lista2.getFirst());
            encontrado = false;
            while (it2.hasNext()) {
                T info2 = it2.next();
                if (info1.equals(info2)) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                retorno.insertFront(info1);
            }
        }
        return retorno;
    }





    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.first);
    }
}
