package tests.jerarquicas;

import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;

public class TestArbolBin {
    public static void main(String[] args) {
        //testInsertarYtoString();
        //testEsVacio();
        //testAltura();
        //testNivel();
        //testPadre();
        //testVaciar();
        testListar();
        //testClone();
        //testObtenerAncestros();
        //testObtenerDescendientes();
        //testVerificarPatron();
        //testListaQueJustificaLaAltura();
    }

    public static void testInsertarYtoString() {
        ArbolBin a1 = new ArbolBin();
        System.out.println("Ingresa 1 como raiz: " + a1.insertar(1, 1, 'I'));
        System.out.println("Ingresa 2 como HD de 1: " + a1.insertar(2, 1, 'D'));
        System.out.println("Ingresa 3 como HI de 1: " + a1.insertar(3, 1, 'I'));
        System.out.println("Ingresa 4 como HD de 2: " + a1.insertar(4, 2, 'D'));
        System.out.println("Ingresa 5 como HI de 2: " + a1.insertar(5, 2, 'I'));
        System.out.println(a1.toString());
    }

    public static void testEsVacio() {
        ArbolBin a2 = new ArbolBin();
        System.out.println("Arbol esta vacio, retorna true: " + a2.esVacio());
        a2.insertar(1, 1, 'I');
        a2.insertar(2, 1, 'D');
        a2.insertar(3, 1, 'I');
        a2.insertar(4, 2, 'D');
        a2.insertar(5, 2, 'I');
        System.out.println(a2.toString());
        System.out.println("Arbol no esta vacio, retorna false: " + a2.esVacio());
    }

    public static void testAltura() {
        ArbolBin a3 = new ArbolBin();
        System.out.println("Arbol esta vacio, retorna -1: " + a3.altura());
        a3.insertar(1, 1, 'I');
        System.out.println("Arbol tiene solo raiz, retorna 0: " + a3.altura());
        a3.insertar(2, 1, 'D');
        a3.insertar(3, 1, 'I');
        a3.insertar(4, 2, 'D');
        a3.insertar(5, 2, 'I');
        System.out.println(a3.toString());
        System.out.println("Arbol debe retornar 2: " + a3.altura());
    }

    public static void testNivel() {
        ArbolBin a4 = new ArbolBin();
        System.out.println("Busca en arbol vacio, retorna -1: " + a4.nivel(1));
        a4.insertar(1, 1, 'I');
        System.out.println("Tiene la unica raiz buscada, retorna 0: " + a4.nivel(1));
        a4.insertar(2, 1, 'D');
        a4.insertar(3, 1, 'I');
        a4.insertar(4, 2, 'D');
        a4.insertar(5, 2, 'I');
        a4.insertar(6, 5, 'I');
        a4.insertar(7, 5, 'D');
        a4.insertar(8, 4, 'I');
        System.out.println(a4.toString());
        System.out.println("Busca el nodo 5, retorna 2: " + a4.nivel(5));
        System.out.println("Busca el nodo 3, retorna 1: " + a4.nivel(3));
        System.out.println("Busca el nodo 8, retorna 3: " + a4.nivel(8));
    }

    public static void testPadre() {
        ArbolBin a5 = new ArbolBin();
        System.out.println("Busca nodo padre en arbol vacio, retorna null: " + (a5.padre(1) == null));
        a5.insertar(1, 1, 'I');
        System.out.println("Busca nodo padre de unica raiz, retorna null: " + (a5.padre(1) == null));
        a5.insertar(2, 1, 'D');
        a5.insertar(3, 1, 'I');
        a5.insertar(4, 2, 'D');
        a5.insertar(5, 2, 'I');
        System.out.println(a5.toString());
        System.out.println("Busca nodo padre 5, retorna 2: " + a5.padre(5));
        System.out.println("Busca nodo padre 3, retorna 1: " + a5.padre(3));
    }

    public static void testVaciar() {
        ArbolBin a6 = new ArbolBin();
        a6.insertar(1, 1, 'D');
        a6.insertar(2, 1, 'D');
        a6.insertar(3, 1, 'I');
        a6.insertar(4, 2, 'D');
        a6.insertar(5, 2, 'I');
        System.out.println(a6.toString());
        System.out.println("Se vacia lista");
        a6.vaciar();
        System.out.println(a6.toString());
    }

    public static void testListar() {
        ArbolBin a7 = new ArbolBin();
        a7.insertar(1, 1, 'D');
        a7.insertar(2, 1, 'D');
        a7.insertar(3, 1, 'I');
        a7.insertar(4, 2, 'D');
        a7.insertar(5, 2, 'I');
        System.out.println(a7.toString());
        System.out.println("Se prueba en preorden, debe retornar [1,3,2,5,4]: " + a7.listarPreorden());
        System.out.println("Se prueba en inorden, debe retornar [3,1,5,2,4]: " + a7.listarInorden());
        System.out.println("Se prueba en posorden, debe retornar [3,5,4,2,1]: " + a7.listarPosorden());
        System.out.println("Se prueba en niveles, debe retornar [1,3,2,5,4]: " + a7.listarPorNiveles());
    }

    public static void testClone() {
        ArbolBin a8 = new ArbolBin();
        a8.insertar(1, 1, 'D');
        a8.insertar(2, 1, 'D');
        a8.insertar(3, 1, 'I');
        a8.insertar(4, 2, 'D');
        a8.insertar(5, 2, 'I');
        System.out.println("Arbol original: \n" + a8.toString());
        System.out.println("Se crea clon de arbol binario");
        ArbolBin a9 = a8.clone();
        System.out.println("Arbol clon: \n" + a9.toString());
        System.out.println("Se vacia arbol original");
        a8.vaciar();
        System.out.println("Arbol original: \n" + a8.toString());
        System.out.println("Arbol clon: \n" + a9.toString());
    }

    public static void testObtenerAncestros() {
        ArbolBin a10 = new ArbolBin();
        a10.insertar(1, 1, 'D');
        a10.insertar(2, 1, 'D');
        a10.insertar(3, 1, 'I');
        a10.insertar(4, 2, 'D');
        a10.insertar(5, 2, 'I');
        System.out.println(a10.toString());
        System.out.println("Se enlistan los ancestros de 4, debe retornar [1,2]: " + a10.obtenerAncestros(4));
        System.out.println("Se enlistan los ancestros de 3, debe retornar [1]: " + a10.obtenerAncestros(3));
        System.out.println("Se enlistan los ancestros de 1, debe retornar []: " + a10.obtenerAncestros(1));
    }

    public static void testObtenerDescendientes() {
        ArbolBin a11 = new ArbolBin();
        a11.insertar(1, 1, 'D');
        a11.insertar(2, 1, 'D');
        a11.insertar(3, 1, 'I');
        a11.insertar(4, 2, 'D');
        a11.insertar(5, 2, 'I');
        System.out.println("Enlista los descendientes de 4, debe retornar []: " + a11.obtenerDescendientes(4));
        System.out.println("Enlista los descendientes de 2, debe retornar [5,4]: " + a11.obtenerDescendientes(2));
        System.out.println("Enlista los descencientes de 1, debe retornar [3,2,5,4]: " + a11.obtenerDescendientes(1));
    }

    public static void testVerificarPatron() {
        ArbolBin a12 = new ArbolBin();
        a12.insertar(12, 1, 'I');
        a12.insertar(10, 12, 'I');
        a12.insertar(40, 10, 'I');
        a12.insertar(15, 10, 'D');
        a12.insertar(8, 12, 'D');
        a12.insertar(9, 8, 'I');
        System.out.println(a12.toString());
        Lista l1 = new Lista();
        Lista l2 = l1.clone();
        l2.insertar(12, 1);
        l2.insertar(8, 2);
        Lista l3 = l2.clone();
        l3.insertar(9, 3);
        Lista l4 = l3.clone();
        l4.insertar(7, 4);
        System.out.println("Lista l1: " + l1.toString() + " debe retornar false: " + a12.verificarPatron(l1));
        System.out.println("Lista l2: " + l2.toString() + " debe retornar false: " + a12.verificarPatron(l2));
        System.out.println("Lista l3: " + l3.toString() + " debe retornar true: " + a12.verificarPatron(l3));
        //No se sabe si esta bien que retorne true ya que tiene otro elemento mas en la lista que no esta en el arbol
        System.out.println("Lista l4: " + l4.toString() + " debe retornar false: " + a12.verificarPatron(l4));
    }

    public static void testListaQueJustificaLaAltura(){
        ArbolBin a13 = new ArbolBin();
        a13.insertar(1, 1, 'D');
        a13.insertar(2, 1, 'D');
        a13.insertar(3, 1, 'I');
        a13.insertar(4, 2, 'D');
        a13.insertar(5, 2, 'I');
        System.out.println(a13.toString());
        System.out.println("Lista esperada [1,2,5]: "+ a13.listaQueJustificaLaAltura().toString());
    }
}
