package tests.conjuntistas;

import conjuntistas.GrafoNoEtiq;

public class testGrafoNoEtiq {
    public static void main(String[] args) {
        //testInsertarYEliminar();
        //testListarEnprofundidad();
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

    public static void testListarEnprofundidad() {
        System.out.println("Prueba de listar en profundidad:");
        GrafoNoEtiq g2 = new GrafoNoEtiq();
        System.out.println("Grafo g2: \n" + g2.toString());
        System.out.println("Se enlista en un grafo vacio (retorna lista vacia): " + g2.listarEnProfundidad().esVacia());
        System.out.println("Se ingresa elemento A en el grafo");
        g2.insertarVertice("A");
        System.out.println("Grafo g2: \n" + g2.toString());
        System.out.println("Se enlista grafo g2: " + g2.listarEnProfundidad().toString());
        g2.insertarVertice("B");
        g2.insertarVertice("C");
        g2.insertarVertice("D");
        System.out.println("Se insertaron los vertices");
        System.out.println("Se enlista grafo g2: " + g2.listarEnProfundidad().toString());
        g2.insertarArco("A", "B");
        g2.insertarArco("A", "D");
        g2.insertarArco("B", "C");
        g2.insertarArco("B", "D");
        System.out.println("Grafo g2: \n" + g2.toString());
        System.out.println("Se enlista grafo g2: " + g2.listarEnProfundidad().toString());
    }

    public static void testListarEnAnchura() {
        System.out.println("Prueba de listar en anchura:");
        GrafoNoEtiq g3 = new GrafoNoEtiq();
        System.out.println("Grafo g3: \n" + g3.toString());
        System.out.println("Se enlista en un grafo vacio (retorna lista vacia): " + g3.listarEnProfundidad().esVacia());
        System.out.println("Se ingresa elemento A en el grafo");
        g3.insertarVertice("A");
        System.out.println("Grafo g3: \n" + g3.toString());
        System.out.println("Se enlista grafo g3: " + g3.listarEnProfundidad().toString());
        g3.insertarVertice("B");
        g3.insertarVertice("C");
        g3.insertarVertice("D");
        System.out.println("Se insertaron los vertices");
        System.out.println("Se enlista grafo g3: " + g3.listarEnProfundidad().toString());
        g3.insertarArco("A", "B");
        g3.insertarArco("A", "D");
        g3.insertarArco("B", "C");
        g3.insertarArco("B", "D");
        System.out.println("Se insertaron los arcos");
        System.out.println("Grafo g3: \n" + g3.toString());
        System.out.println("Se enlista grafo g3: " + g3.listarEnProfundidad().toString());
    }

    public static void testEsVacio() {
        System.out.println("Prueba de 'es vacio':");
        GrafoNoEtiq g4 = new GrafoNoEtiq();
        System.out.println("Grafo g4: \n" + g4.toString());
        System.out.println("Grafo vacio: "+ g4.esVacio());
        System.out.println("Se ingresa elemento A en en el grafo");
        g4.insertarVertice("A");
        System.out.println("Grafo g4: \n" + g4.toString());
        System.out.println("Grafo vacio: "+ g4.esVacio());
    }

    public static void testClone(){
        System.out.println("Prueba de clone:");
        GrafoNoEtiq g5 = new GrafoNoEtiq();

    }
}
