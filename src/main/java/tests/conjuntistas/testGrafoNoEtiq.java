package tests.conjuntistas;

import conjuntistas.GrafoNoEtiq;

public class testGrafoNoEtiq {
    public static void main(String[] args) {
        insertarYEliminar();
    }

    public static void insertarYEliminar(){
        System.out.println("Insertar y eliminar vertices:");
        GrafoNoEtiq g1 = new GrafoNoEtiq();
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto A en el grafo: "+ g1.insertarVertice("A"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto B en el grafo: "+ g1.insertarVertice("B"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto C en el grafo: "+ g1.insertarVertice("C"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto D en el grafo: "+ g1.insertarVertice("D"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto E en el grafo: "+ g1.insertarVertice("E"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto F en el grafo: "+ g1.insertarVertice("F"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Elimina F en el grafo: "+ g1.eliminarVertice("F"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Elimina E en el grafo: "+ g1.eliminarVertice("E"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto G en el grafo: "+ g1.insertarVertice("G"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Elimina E en el grafo (no se encuentra en el grafo): "+ g1.eliminarVertice("E"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("-----------------------------------------------------");

        System.out.println("Insertar y eliminar arcos");
        System.out.println("Inserto arco de A a B: "+ g1.insertarArco("A","B"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto arco de A a D: "+ g1.insertarArco("A","D"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto arco de D a B: "+ g1.insertarArco("D","B"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto arco de B a C: "+ g1.insertarArco("B","C"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto arco de C a G: "+ g1.insertarArco("C","G"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Elimino arco de A a D: "+ g1.eliminarArco("A","D"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Elimino vertice G: "+ g1.eliminarVertice("G"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto arco de C a G: "+ g1.insertarArco("C","G"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Elimino arco de C a G: "+ g1.eliminarArco("C","G"));
        System.out.println("Grafo g1: \n"+g1.toString());
        System.out.println("Inserto arco de A a C: "+ g1.insertarArco("A","C"));
        System.out.println("Grafo g1: \n"+g1.toString());
    }
}
