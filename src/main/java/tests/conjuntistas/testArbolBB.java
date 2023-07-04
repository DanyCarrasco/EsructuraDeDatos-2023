package tests.conjuntistas;

import conjuntistas.ArbolBB;

public class testArbolBB {
    public static void main(String[] args) {
        testInt();
        testString();
    }

    public static void testString(){
        /*testInsertarYToString();
        testEliminar();
        testPertenece();
        testEsVacio();
        testListar();
        testListarRango();
        testMinimoElem();
        testMaximoElem();
        testVaciar();
        testClone();*/
    }

    public static void testInt(){
        testInsertarYToString();
        testEliminar();
        /*testPertenece();
        testEsVacio();
        testListar();
        testListarRango();
        testMinimoElem();
        testMaximoElem();
        testVaciar();
        testClone();*/
    }

    public static void testInsertarYToString() {
        ArbolBB a1 = new ArbolBB();
        System.out.println("Arbol a1: " + a1.toString());
        System.out.println("Se inserta un elemento en arbol a1: " + a1.insertar(3));
        System.out.println("Arbol a1: \n" + a1.toString());

        ArbolBB a2 = new ArbolBB();
        System.out.println("Se inserta elemento 8 en arbol a2: " + a2.insertar(8));
        System.out.println("Se inserta elemento 6 en arbol a2: " + a2.insertar(6));
        System.out.println("Se inserta elemento 10 en arbol a2: " + a2.insertar(10));
        System.out.println("Arbol a2: \n" + a2.toString());

        ArbolBB a3 = new ArbolBB();
        System.out.println("Se inserta elemento 6 en arbol a3: " + a3.insertar(6));
        System.out.println("Se inserta elemento 10 en arbol a3: " + a3.insertar(10));
        System.out.println("Se inserta elemento 4 en arbol a3: " + a3.insertar(4));
        System.out.println("Se inserta elemento 10 en arbol a3 (retorna false): " + a3.insertar(10));
        System.out.println("Arbol a3: \n" + a3.toString());
    }

    public static void testEliminar() {
        ArbolBB a4 = new ArbolBB();
        System.out.println("Arbol a4: \n" + a4.toString());
        System.out.println("Elimina en arbol a4: " + a4.eliminar(1));
        a4.insertar(60);
        System.out.println("Arbol a4: \n" + a4.toString());
        System.out.println("Elimina 60 en arbol a4: " + a4.eliminar(60));
        System.out.println("Arbol a4: \n" + a4.toString());

        ArbolBB a5 = new ArbolBB();
        a5.insertar(50);
        a5.insertar(13);
        a5.insertar(60);
        a5.insertar(11);
        a5.insertar(15);
        a5.insertar(55);
        a5.insertar(77);
        System.out.println("Arbol a5: \n" + a5.toString());
        System.out.println("Elimina hoja 55: " + a5.eliminar(55));
        System.out.println("Arbol a5: \n" + a5.toString());
        System.out.println("Elimina 60 con un hijo: " + a5.eliminar(60));
        System.out.println("Arbol a5: \n" + a5.toString());
        System.out.println("Elimina 13 con dos hijos: " + a5.eliminar(13));
        System.out.println("Arbol a5: \n" + a5.toString());
        System.out.println("Elimina 10, retorna false: " + a5.eliminar(10));
    }

    public static void testPertenece() {
        ArbolBB a6 = new ArbolBB();
        System.out.println("Arbol a6: \n" + a6.toString());
        System.out.println("Busca en arbol a6: " + a6.pertenece(1) + "\n");

        a6.insertar(17);
        System.out.print("Arbol a6: \n" + a6.toString());
        System.out.println("Busca 17 en arbol a6: " + a6.pertenece(17) + "\n");

        ArbolBB a7 = new ArbolBB();
        a7.insertar(8);
        a7.insertar(6);
        a7.insertar(10);
        System.out.println("Arbol a7: \n" + a7.toString());
        System.out.println("Busca 10 en arbol a7: " + a7.pertenece(10));
        System.out.println("Buscas 6 en arbol a7: " + a7.pertenece(6) + "\n");

        ArbolBB a8 = new ArbolBB();
        a8.insertar(6);
        a8.insertar(10);
        a8.insertar(4);
        System.out.println("Arbol a8: \n" + a8.toString());
        System.out.println("Busca 6 en arbol a8: " + a8.pertenece(6));
        System.out.println("Busca 10 en arbol a8: " + a8.pertenece(10));
        System.out.println("Busca 11 en arbol a8: " + a8.pertenece(11));
    }

    public static void testEsVacio() {
        ArbolBB a9 = new ArbolBB();
        System.out.println("Arbol a9: \n" + a9.toString());
        System.out.println("Arbol a9 esta vacio: " + a9.esVacio());
        a9.insertar(1);
        System.out.println("Arbol a9: \n" + a9.toString());
        System.out.println("Arbol a9 esta vacio: " + a9.esVacio());
    }

    public static void testListar() {
        ArbolBB a10 = new ArbolBB();
        System.out.println("Arbol a10: \n" + a10.toString());
        System.out.println("Lista de arbol a10: " + a10.listar().toString());
        a10.insertar(50);
        System.out.println("Arbol a10: \n" + a10.toString());
        System.out.println("Lista de arbol a10: " + a10.listar().toString());
        a10.insertar(13);
        a10.insertar(60);
        a10.insertar(11);
        a10.insertar(15);
        a10.insertar(55);
        a10.insertar(77);
        System.out.println("Arbol a10: \n" + a10.toString());
        System.out.println("Lista de arbol a10: " + a10.listar().toString());
    }

    public static void testListarRango() {
        ArbolBB a11 = new ArbolBB();
        System.out.println("Arbol a11: \n" + a11.toString());
        System.out.println("Lista de arbol a11: " + a11.listarRango(11, 60).toString());
        a11.insertar(50);
        System.out.println("Arbol a11: \n" + a11.toString());
        System.out.println("Lista de arbol a11: " + a11.listarRango(40, 60).toString());
        a11.insertar(13);
        a11.insertar(60);
        a11.insertar(11);
        a11.insertar(15);
        a11.insertar(55);
        a11.insertar(77);
        System.out.println("Arbol a11: \n" + a11.toString());
        System.out.println("Lista de arbol a11: " + a11.listar().toString());
        System.out.println("Lista (15;60) de arbol a11: " + a11.listarRango(15, 60).toString());
        System.out.println("Lista (10;55) de arbol a11: " + a11.listarRango(10, 55).toString());
        System.out.println("Lista (30;80) de arbol a11: " + a11.listarRango(30, 80).toString());
        System.out.println("Lista (14;51) de arbol a11: " + a11.listarRango(14, 51).toString());
    }

    public static void testMinimoElem() {
        ArbolBB a12 = new ArbolBB();
        System.out.println("Arbol a12: \n" + a12.toString());
        System.out.println("Retorna null: " + (a12.minimoElem() == null));
        a12.insertar(50);
        System.out.println("Arbol a12: \n" + a12.toString());
        System.out.println("Retorna 50: " + a12.minimoElem());
        a12.insertar(13);
        a12.insertar(60);
        a12.insertar(11);
        a12.insertar(15);
        a12.insertar(55);
        a12.insertar(77);
        System.out.println("Arbol a12: \n" + a12.toString());
        System.out.println("Retorna 11: " + a12.minimoElem());
    }

    public static void testMaximoElem() {
        ArbolBB a13 = new ArbolBB();
        System.out.println("Arbol a13: \n" + a13.toString());
        System.out.println("Retorna null: " + (a13.maximoElem() == null));
        a13.insertar(50);
        System.out.println("Arbol a13: \n" + a13.toString());
        System.out.println("Retorna 50: " + a13.maximoElem());
        a13.insertar(13);
        a13.insertar(60);
        a13.insertar(11);
        a13.insertar(15);
        a13.insertar(55);
        a13.insertar(77);
        System.out.println("Arbol a13: \n" + a13.toString());
        System.out.println("Retorna 77: " + a13.maximoElem());
    }

    public static void testVaciar() {
        ArbolBB a14 = new ArbolBB();
        a14.insertar(1);
        System.out.println("Arbol a14: \n" + a14.toString());
        System.out.println("Se vacia arbol a14, arbol esta vacio: " + a14.esVacio());
        System.out.println("Arbol a14: \n" + a14.toString());
    }

    public static void testClone(){
        ArbolBB a15 = new ArbolBB();
        System.out.println("Arbol a15: \n" + a15.toString());
        System.out.println("Se crea clon a16 de arbol a15");
        ArbolBB a16 = a15.clone();
        System.out.println("Arbol a16: \n" + a16.toString());

        a15.insertar(50);
        System.out.println("Arbol a15: \n" + a15.toString());
        System.out.println("Se crea clon a17 de arbol a15");
        ArbolBB a17 = a15.clone();
        System.out.println("Arbol a17: \n" + a17.toString());

        a15.insertar(13);
        a15.insertar(60);
        a15.insertar(11);
        a15.insertar(15);
        a15.insertar(55);
        a15.insertar(77);
        System.out.println("Arbol a15: \n" + a15.toString());
        System.out.println("Se crea clon a18 de arbol a15");
        ArbolBB a18 = a15.clone();
        System.out.println("Arbol a18: \n" + a18.toString());
    }
}


