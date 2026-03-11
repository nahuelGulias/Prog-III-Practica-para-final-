package listas;

public class DoubleList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public DoubleList(Node<T> first, Node<T> last) {
        this.first = first;
        this.last = last;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> nuevoNodo = new Node<>(info,null);
        if(this.first == null){
            this.first = nuevoNodo;
            this.last = nuevoNodo;
        }
        else {
            nuevoNodo.setNext(this.first);
            this.first.setPrevious(nuevoNodo);
            this.first = nuevoNodo;
        }
        this.size++;
    }

    public T extractFront() {

        if(this.first == null){
            return null;
        }

        T info = first.getInfo();

        if(first == last){
            first = null;
            last = null;
        }
        else {
            first = first.getNext();
            first.setPrevious(null);
        }
        this.size--;
        return info;
    }

    public T extractLast() {
        if(this.last == null){
            return null;
        }
        T info = last.getInfo();
        if(last == first){
            last = null;
            first = null;
        }
        else{
            last = last.getPrevious();
            last.setNext(null);
        }

        this.size--;
        return info;
    }

    public void addPos(T info, int pos) {

        Node<T> nuevoNodo = new Node<>(info,null);
        if(this.first == null){
            this.first = nuevoNodo;
        }

        int i = -1;
        Node<T> tmp = this.first;

        while (tmp != null && (i < this.size || i != pos)) {
            tmp = tmp.getNext();
            i++;
        }

        tmp.setPrevious(nuevoNodo);
        nuevoNodo.setNext(tmp);
        tmp = nuevoNodo;
        this.size++;
    }

    public boolean delete(T info) {

        if(this.first == null){
            return false;
        }

        if(this.first.getInfo().equals(info) && this.last.getInfo().equals(info)){
            first = null;
            last = null;
            size = 0;
            return true;
        }

        if(this.first.getInfo().equals(info)){
            this.first = this.first.getNext();
            first.setPrevious(null);
            size--;
            return true;
        }

        if(this.last.getInfo().equals(info)){
            this.last = this.last.getPrevious();
            this.last.setNext(null);
            size--;
            return true;
        }

        int i = 0;
        Node<T> temp = this.first;

        while(temp != null){// && i < this.size){ temp!=null controla todo
            if(temp.getInfo().equals(info)){
                temp.getNext().setPrevious(temp.getPrevious());
                temp.getPrevious().setNext(temp.getNext());
                size--;
                return true;
            }
            temp = temp.getNext();
            i++;
        }
        return false;
    }

}
