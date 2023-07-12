package tests.conjuntistas;

import conjuntistas.GrafoNoEtiq;

public class testGrafoNoEtiq {
    public static void main(String[] args) {
        insertarYEliminar();
    }

    public static void insertarYEliminar(){
        GrafoNoEtiq g1 = new GrafoNoEtiq();
        System.out.println("Grafo g1: "+g1.toString());
        System.out.println("Inserto A en el grafo: "+ g1.insertarVertice("A"));
        System.out.println("Grafo g1: "+g1.toString());
        System.out.println("Inserto B en el grafo: "+ g1.insertarVertice("B"));
        System.out.println("Grafo g1: "+g1.toString());
        System.out.println("Inserto C en el grafo: "+ g1.insertarVertice("C"));
        System.out.println("Grafo g1: "+g1.toString());
        System.out.println("Inserto D en el grafo: "+ g1.insertarVertice("D"));
        System.out.println("Grafo g1: "+g1.toString());
    }
}
