package Arboles;

public class Main {
    public static void main(String[] args) {
        Tree abb = new Tree();

        abb.add(10);
        abb.add(5);
        abb.add(15);
        abb.add(20);
        abb.add(3);
        abb.add(7);
        abb.add(12);

//        LinkedList<Integer> list = new LinkedList<>();
//        list= abb.getElementAtLevel(abb.getRoot(),2);
//        for(Integer i : list){
//            System.out.println(i);
//        }

        System.out.println(abb.getListadoDeHojasQueSuperanK(2));
    }
}
