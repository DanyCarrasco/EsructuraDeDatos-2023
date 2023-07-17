package tests.conjuntistas;

import conjuntistas.GrafoNoEtiq;

public class testGrafoNoEtiq {
    public static void main(String[] args) {
        //testInsertarYEliminar();
        //testListarEnProfundidad();
        //testListarEnAnchura();
        testEsVacio();
    }

    public static void testInsertarYEliminar() {
        System.out.println("Insertar y eliminar vertices:");
        GrafoNoEtiq g1 = new GrafoNoEtiq();
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto A en el grafo: " + g1.insertarVertice("A"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto B en el grafo: " + g1.insertarVertice("B"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto C en el grafo: " + g1.insertarVertice("C"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto D en el grafo: " + g1.insertarVertice("D"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto E en el grafo: " + g1.insertarVertice("E"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto F en el grafo: " + g1.insertarVertice("F"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Elimina F en el grafo: " + g1.eliminarVertice("F"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Elimina E en el grafo: " + g1.eliminarVertice("E"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto G en el grafo: " + g1.insertarVertice("G"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Elimina E en el grafo (no se encuentra en el grafo): " + g1.eliminarVertice("E"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("-----------------------------------------------------");

        System.out.println("Insertar y eliminar arcos");
        System.out.println("Inserto arco de A a B: " + g1.insertarArco("A", "B"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto arco de A a D: " + g1.insertarArco("A", "D"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto arco de D a B: " + g1.insertarArco("D", "B"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto arco de B a C: " + g1.insertarArco("B", "C"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto arco de C a G: " + g1.insertarArco("C", "G"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Elimino arco de A a D: " + g1.eliminarArco("A", "D"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Elimino vertice G: " + g1.eliminarVertice("G"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto arco de C a G: " + g1.insertarArco("C", "G"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Elimino arco de C a G: " + g1.eliminarArco("C", "G"));
        System.out.println("Grafo g1: \n" + g1.toString());
        System.out.println("Inserto arco de A a C: " + g1.insertarArco("A", "C"));
        System.out.println("Grafo g1: \n" + g1.toString());
    }

    public static void testExisteVertice(){
        System.out.println("Prueba de existe vertice:");
        GrafoNoEtiq g2 = new GrafoNoEtiq();
    }

    public static void testExisteArco(){
        System.out.println("Prueba de existe arco:");
        GrafoNoEtiq g3 = new GrafoNoEtiq();
    }

    public static void testExisteCamino(){
        System.out.println("Prueba de existe camino:");
        GrafoNoEtiq g4 = new GrafoNoEtiq();
    }

    public static void testCaminoMasCorto(){
        System.out.println("Prueba de camino mas corto:");
        GrafoNoEtiq g5 = new GrafoNoEtiq();
    }

    public static void testCaminoMasLargo(){
        System.out.println("Prueba de camino mas largo:");
        GrafoNoEtiq g6 = new GrafoNoEtiq();
    }

    public static void testListarEnProfundidad() {
        System.out.println("Prueba de listar en profundidad:");
        GrafoNoEtiq g7 = new GrafoNoEtiq();
        System.out.println("Grafo g7: \n" + g7.toString());
        System.out.println("Se enlista en un grafo vacio (retorna lista vacia): " + g7.listarEnProfundidad().esVacia());
        System.out.println("Se ingresa elemento A en el grafo");
        g7.insertarVertice("A");
        System.out.println("Grafo g7: \n" + g7.toString());
        System.out.println("Se enlista grafo g2: " + g7.listarEnProfundidad().toString());
        g7.insertarVertice("B");
        g7.insertarVertice("C");
        g7.insertarVertice("D");
        System.out.println("Se insertaron los vertices");
        System.out.println("Se enlista grafo g7: " + g7.listarEnProfundidad().toString());
        g7.insertarArco("A", "B");
        g7.insertarArco("A", "D");
        g7.insertarArco("B", "C");
        g7.insertarArco("B", "D");
        System.out.println("Grafo g7: \n" + g7.toString());
        System.out.println("Se enlista grafo g7: " + g7.listarEnProfundidad().toString());
    }

    public static void testListarEnAnchura() {
        System.out.println("Prueba de listar en anchura:");
        GrafoNoEtiq g8 = new GrafoNoEtiq();
        System.out.println("Grafo g8: \n" + g8.toString());
        System.out.println("Se enlista en un grafo vacio (retorna lista vacia): " + g8.listarEnProfundidad().esVacia());
        System.out.println("Se ingresa elemento A en el grafo");
        g8.insertarVertice("A");
        System.out.println("Grafo g8: \n" + g8.toString());
        System.out.println("Se enlista grafo g8: " + g8.listarEnProfundidad().toString());
        g8.insertarVertice("B");
        g8.insertarVertice("C");
        g8.insertarVertice("D");
        System.out.println("Se insertaron los vertices");
        System.out.println("Se enlista grafo g8: " + g8.listarEnProfundidad().toString());
        g8.insertarArco("A", "B");
        g8.insertarArco("A", "D");
        g8.insertarArco("B", "C");
        g8.insertarArco("B", "D");
        System.out.println("Se insertaron los arcos");
        System.out.println("Grafo g8: \n" + g8.toString());
        System.out.println("Se enlista grafo g8: " + g8.listarEnProfundidad().toString());
    }

    public static void testEsVacio() {
        System.out.println("Prueba de 'es vacio':");
        GrafoNoEtiq g9 = new GrafoNoEtiq();
        System.out.println("Grafo g9: \n" + g9.toString());
        System.out.println("Grafo vacio: "+ g9.esVacio());
        System.out.println("Se ingresa elemento A en en el grafo");
        g9.insertarVertice("A");
        System.out.println("Grafo g9: \n" + g9.toString());
        System.out.println("Grafo vacio: "+ g9.esVacio());
    }

    public static void testClone(){
        System.out.println("Prueba de clone:");
        GrafoNoEtiq g10 = new GrafoNoEtiq();

    }
}
