package tests.conjuntistas;

import conjuntistas.HeapMin;

public class testHeapMin {
    public static void main(String[] args) {
        //testInsertarYToString();
        //testEliminarCima();
        //testRecuperarCima();
        testEsVacio();
    }

    public static void testInsertarYToString() {
        HeapMin a1 = new HeapMin();
        System.out.println("Se creo un arbol vacio: " + a1.toString());
        HeapMin a2 = new HeapMin();
        a2.insertar(23);
        System.out.println("Se creo un arbol con un elemento: " + a2.toString());
        HeapMin a3 = new HeapMin();
        a3.insertar(15);
        a3.insertar(15);
        System.out.println("Se crea un arbol con dos elementos iguales: " + a3.toString());
        HeapMin a4 = new HeapMin();
        a4.insertar(23);
        a4.insertar(15);
        System.out.println("Se crea un arbol con dos elementos, uno mayor y uno menor: " + a4.toString());
        HeapMin a5 = new HeapMin();
        a5.insertar(30);
        a5.insertar(15);
        a5.insertar(23);
        System.out.println("Se creo un arbol con tres elementos; uno mayor y dos menores: " + a5.toString());
    }

    public static void testEliminarCima() {
        HeapMin a6 = new HeapMin();
        System.out.println(a6.toString());
        System.out.println("Se elimina cima en arbol vacio, retorna false: " + a6.eliminarCima());
        System.out.println(a6.toString() + "\n");
        a6.insertar(15);
        System.out.println(a6.toString());
        System.out.println("Se elimina cima en arbol con un elemento, retorna true: " + a6.eliminarCima());
        System.out.println(a6.toString() + "\n");
        a6.insertar(15);
        a6.insertar(12);
        a6.insertar(13);
        System.out.println(a6.toString());
        System.out.println("Se elimina cima en arbol con elementos, retorna true: " + a6.eliminarCima());
        System.out.println(a6.toString() + "\n");
    }

    public static void testRecuperarCima() {
        HeapMin a7 = new HeapMin();
        System.out.println(a7.toString());
        System.out.println("Se recupera cima en arbol vacio, retorna null (true): " + (a7.recuperarCima() == null));
        System.out.println(a7.toString() + "\n");
        a7.insertar(15);
        System.out.println(a7.toString());
        System.out.println("Se recupera cima en arbol con un elemento, retorna null (false): " + (a7.recuperarCima() == null));
        System.out.println(a7.toString() + "\n");
        a7.insertar(12);
        a7.insertar(13);
        System.out.println(a7.toString());
        System.out.println("Se recupera cima en arbol con elementos, retorna null (false): " + (a7.recuperarCima() == null));
        System.out.println(a7.toString() + "\n");
    }

    public static void testEsVacio() {
        HeapMin a7 = new HeapMin();
        System.out.println(a7.toString());
        System.out.println("Arbol vacio, retorna true: " + a7.esVacio() + "\n");
        a7.insertar(15);
        System.out.println(a7.toString());
        System.out.println("Arbol con elemento, retorna false: " + a7.esVacio());
    }
}


