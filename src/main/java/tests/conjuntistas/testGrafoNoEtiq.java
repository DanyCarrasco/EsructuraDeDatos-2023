package tests.conjuntistas;

import conjuntistas.GrafoNoEtiq;

public class testGrafoNoEtiq {
    public static void main(String[] args) {
        //testInsertarYEliminar();
        //testExisteVertice();
        //testExisteArco();
        //testExisteCamino();
        //testCaminoMasCorto();
        testCaminoMasLargo();
        //testListarEnProfundidad();
        //testListarEnAnchura();
        //testEsVacio();
        //testClone();
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

    public static void testExisteVertice() {
        System.out.println("Prueba de existe vertice:");
        GrafoNoEtiq g2 = new GrafoNoEtiq();
        System.out.println("Pruebo en grafo vacio buscar vertice 'A': " + g2.existeVertice("A"));
        System.out.println("Inserto vertices en grafo");
        g2.insertarVertice("A");
        g2.insertarVertice("B");
        g2.insertarVertice("C");
        g2.insertarVertice("D");
        System.out.println("Grafo g2: \n" + g2.toString());
        System.out.println("Pruebo en grafo con vertices buscar vertice 'A': " + g2.existeVertice("A"));
        System.out.println("Inserto arcos en grafo");
        g2.insertarArco("A", "B");
        g2.insertarArco("A", "D");
        g2.insertarArco("A", "C");
        g2.insertarArco("B", "D");
        g2.insertarArco("D", "C");
        g2.insertarArco("C", "B");
        System.out.println("Grafo g2: \n" + g2.toString());
        System.out.println("Pruebo en grafo con arcos buscar vertice 'A': " + g2.existeVertice("A"));
        System.out.println("Pruebo en grafo con arcos buscar vertice 'G': " + g2.existeVertice("G"));
    }

    public static void testExisteArco() {
        System.out.println("Prueba de existe arco:");
        GrafoNoEtiq g3 = new GrafoNoEtiq();
        System.out.println("Pruebo en grafo vacio buscar arco 'A' a 'B': " + g3.existeArco("A", "B"));
        System.out.println("Inserto vertices en grafo");
        g3.insertarVertice("A");
        g3.insertarVertice("B");
        g3.insertarVertice("C");
        g3.insertarVertice("D");
        System.out.println("Grafo g3: \n" + g3.toString());
        System.out.println("Pruebo en grafo con vertices buscar arco 'A' a 'B': " + g3.existeArco("A", "B"));
        System.out.println("Inserto arcos en grafo");
        g3.insertarArco("A", "B");
        g3.insertarArco("A", "D");
        g3.insertarArco("A", "C");
        g3.insertarArco("B", "D");
        g3.insertarArco("D", "C");
        g3.insertarArco("C", "B");
        System.out.println("Grafo g3: \n" + g3.toString());
        System.out.println("Pruebo en grafo con vertices buscar arco 'A' a 'B': " + g3.existeArco("A", "B"));
        System.out.println("Pruebo en grafo con vertices buscar arco 'A' a 'G': " + g3.existeArco("A", "G"));
    }

    public static void testExisteCamino() {
        System.out.println("Prueba de existe camino:");
        GrafoNoEtiq g4 = new GrafoNoEtiq();
        System.out.println("Pruebo en grafo vacio existe camino 'A' a 'B': " + g4.existeCamino("A", "B"));
        System.out.println("Inserto vertices en grafo");
        g4.insertarVertice("A");
        g4.insertarVertice("B");
        g4.insertarVertice("C");
        g4.insertarVertice("D");
        System.out.println("Grafo g4: \n" + g4.toString());
        System.out.println("Pruebo en grafo con vertices existe camino 'A' a 'B': " + g4.existeCamino("A", "B"));
        System.out.println("Inserto arcos en grafo");
        g4.insertarArco("A", "B");
        g4.insertarArco("A", "D");
        g4.insertarArco("A", "C");
        g4.insertarArco("B", "D");
        g4.insertarArco("D", "C");
        g4.insertarArco("C", "B");
        System.out.println("Grafo g4: \n" + g4.toString());
        System.out.println("Pruebo en grafo con vertices existe camino 'A' a 'C': " + g4.existeCamino("A", "B"));
        System.out.println("Pruebo en grafo con vertices existe camino 'A' a 'G': " + g4.existeCamino("A", "G"));
    }

    public static void testCaminoMasCorto() {
        System.out.println("Prueba de camino mas corto:");
        GrafoNoEtiq g5 = new GrafoNoEtiq();
        System.out.println("Pruebo en grafo vacio camino corto de 'A' a 'B': " + g5.caminoMasCorto("A", "B").toString());
        System.out.println("Inserto vertices en grafo");
        g5.insertarVertice("A");
        g5.insertarVertice("B");
        g5.insertarVertice("C");
        g5.insertarVertice("D");
        System.out.println("Grafo g5: \n" + g5.toString());
        System.out.println("Pruebo en grafo con vertices camino corto de 'A' a 'B': " + g5.caminoMasCorto("A", "B").toString());
        System.out.println("Inserto arcos en grafo");
        g5.insertarArco("A", "B");
        g5.insertarArco("A", "D");
        g5.insertarArco("A", "C");
        g5.insertarArco("B", "D");
        g5.insertarArco("D", "C");
        g5.insertarArco("C", "B");
        System.out.println("Grafo g5: \n" + g5.toString());
        System.out.println("Pruebo en grafo con vertices camino corto de 'A' a 'C': " + g5.caminoMasCorto("A", "C").toString());
        System.out.println("Pruebo en grafo con vertices camino corto de 'A' a 'G': " + g5.caminoMasCorto("A", "G").toString());
    }

    public static void testCaminoMasLargo() {
        System.out.println("Prueba de camino mas largo:");
        GrafoNoEtiq g6 = new GrafoNoEtiq();
        System.out.println("Pruebo en grafo vacio camino largo de 'A' a 'B': " + g6.caminoMasLargo("A", "B").toString());
        System.out.println("Inserto vertices en grafo");
        g6.insertarVertice("A");
        g6.insertarVertice("B");
        g6.insertarVertice("C");
        g6.insertarVertice("D");
        System.out.println("Grafo g6: \n" + g6.toString());
        System.out.println("Pruebo en grafo con vertices camino largo de 'A' a 'B': " + g6.caminoMasLargo("A", "B").toString());
        System.out.println("Inserto arcos en grafo");
        g6.insertarArco("A", "B");
        g6.insertarArco("A", "D");
        g6.insertarArco("A", "C");
        g6.insertarArco("B", "D");
        g6.insertarArco("D", "C");
        g6.insertarArco("C", "B");
        System.out.println("Grafo g6: \n" + g6.toString());
        System.out.println("Pruebo en grafo con vertices camino largo de 'A' a 'C': " + g6.caminoMasLargo("A", "C").toString());
        System.out.println("Pruebo en grafo con vertices camino largo de 'A' a 'G': " + g6.caminoMasLargo("A", "G").toString());
        System.out.println("Inserto E en el grafo");
        g6.insertarVertice("E");
        System.out.println("Inserto arcos de E");
        g6.insertarArco("E","D");
        g6.insertarArco("C","E");
        System.out.println("Grafo g6: \n" + g6.toString());
        System.out.println("Pruebo en grafo con vertices camino largo de 'A' a 'C': " + g6.caminoMasLargo("A", "C").toString());
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
        System.out.println("Grafo vacio: " + g9.esVacio());
        System.out.println("Se ingresa elemento A en en el grafo");
        g9.insertarVertice("A");
        System.out.println("Grafo g9: \n" + g9.toString());
        System.out.println("Grafo vacio: " + g9.esVacio());
    }

    public static void testClone() {
        System.out.println("Prueba de clone:");
        GrafoNoEtiq g10 = new GrafoNoEtiq();
        System.out.println("Grafo g10: \n" + g10.toString());
        System.out.println("Se hace un clone de grafo vacio");
        GrafoNoEtiq g11 = g10.clone();
        System.out.println("Se ingresa elemento A en el grafo original");
        g10.insertarVertice("A");
        System.out.println("Grafo g10: \n" + g10.toString());
        System.out.println("Grafo clone vacio: \n" + g11.toString());
        g10.insertarVertice("B");
        g10.insertarVertice("C");
        g10.insertarVertice("D");
        System.out.println("Se insertaron los vertices");
        System.out.println("Se crea otro grafo clone con vertices");
        GrafoNoEtiq g12 = g10.clone();
        System.out.println("Grafo g10: \n" + g10.toString());
        g10.insertarArco("A", "B");
        g10.insertarArco("A", "D");
        g10.insertarArco("B", "C");
        g10.insertarArco("B", "D");
        System.out.println("Se insertaron los arcos");
        System.out.println("Grafo g10: \n" + g10.toString());
        System.out.println("Grafo clone con vertices: \n" + g12.toString());
        System.out.println("Se crea un grafo clone con los arcos");
        GrafoNoEtiq g13 = g10.clone();
        System.out.println("Grafo g10: \n" + g10.toString());
        System.out.println("Grafo clone con arcos: \n" + g13.toString());
        System.out.println("Se agrega un vertice en ultimo grafo clonado: "+ g13.insertarVertice("G"));
        System.out.println("Se agrega un arco en el ultimo grafo clonado: "+ g13.insertarArco("C", "G"));
        System.out.println("Grafo g10: \n" + g10.toString());
        System.out.println("Ultimo grafo clonado: \n" + g13.toString());
    }
}
