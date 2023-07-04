/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Lista;

/**
 *
 * @author danyc
 */
public class TestLista {
    //testing propio de Lista
    public static void main(String[] args) {
        //testDeInsertar();
        //testInsertarRecuperar();
        testLocalizar();
        // testEliminar();
        // testEsVacia();
        // testVaciar();
        // testClone();
        // testToString();
        //testEliminarApariciones();
    }

    public static void testDeInsertar() {
        Lista l1 = new Lista();
        System.out.println("==================================================================================== ");
        System.out.println(l1.toString());
        System.out.println("Prueba de insertar y eliminar");
        System.out.println("Inserta 5 elementos en lista l1");
        int i = 1;
        int u = i + 5;
        while (i < 6) {
            System.out.println("Prueba " + i);
            System.out.println("Inserta en la lista " + u + " en la posicion " + i + ": " + l1.insertar(u, i));
            System.out.println(l1.toString());
            i++;
            u++;
        }
        System.out.println("==================================================================================== ");
    }

    public static void testInsertarRecuperar() {
        Lista l2 = new Lista();
        System.out
                .println("Inserta un elemento en la lista vacia en posicion 0, retorna false: " + (l2.insertar(1, 0)));
        System.out.println("Inserta un elemento en la lista vacia en posicion 1, retorna true: " + l2.insertar(1, 1));
        l2.insertar(7, 1);
        System.out.println("Inserta un elemento '7' en la lista en posicion 1: " + l2.toString());
        l2.insertar(2, 2);
        l2.insertar(3, 3);
        System.out.println("Longitud debe ser 3: " + (3 == l2.longitud()));
        System.out.println(l2.toString());
        System.out.println("recupera en posicion 0, retorna null: " + (l2.recuperar(0) == null));
        System.out.println("Elemento 1: " + (l2.recuperar(1).equals(1)));
        System.out.println("Elemento 2: " + (l2.recuperar(2).equals(2)));
        System.out.println("Elemento 3: " + (l2.recuperar(3).equals(3)));
        l2.vaciar();
        System.out.println("recupera en lista vacia, retorna null: " + (l2.recuperar(1) == null));
        System.out.println("==================================================================================== ");
    }

    public static void testLocalizar() {
        Lista l3 = new Lista();
        l3.insertar(5, 1);
        l3.insertar(6, 2);
        l3.insertar(7, 3);
        System.out.println("Localiza elemento '4', retorna -1: " + (l3.localizar(4) == -1));
        System.out.println("Localiza elemento '5', retorna 1: " + (l3.localizar(5) == 1));
        System.out.println("Localiza elemento '6', retorna 2: " + (l3.localizar(6) == 2));
        System.out.println("Localiza elemento '7', retorna 3: " + (l3.localizar(7) == 3));
        l3.vaciar();
        System.out.println("Localiza en una lista vacia, retorna 0: " + (l3.localizar(1) == 0));
        System.out.println("==================================================================================== ");
    }

    private static void testEliminar() {
        Lista l4 = new Lista();
        l4.insertar(5, 1);
        l4.insertar(6, 2);
        l4.insertar(7, 3);
        System.out.println("Se insertaron 3 elementos: " + l4.toString());
        System.out.println("Elimina en pos 0, retorna false: " + l4.eliminar(0));
        System.out.println(l4.toString());
        System.out.println("Elimina en pos 3, retorna true: " + l4.eliminar(3));
        System.out.println(l4.toString());
        System.out.println("Elimina en pos 2, retorna true: " + l4.eliminar(2));
        System.out.println(l4.toString());
        System.out.println("Elimina en pos 1, retorna true: " + l4.eliminar(1));
        System.out.println(l4.toString());
        System.out.println("Elimina en lista vacia, retorna false: " + l4.eliminar(1));
        System.out.println("==================================================================================== ");
    }

    public static void testEsVacia() {
        Lista l5 = new Lista();
        System.out.println("Lista esta vacia, retorna true: " + l5.esVacia());
        System.out.println(l5.toString());
        System.out.println("Se inserta un elemento a la lista");
        l5.insertar(1, 1);
        System.out.println("Lista no esta vacia, retorna false: " + l5.esVacia());
        System.out.println(l5.toString());
        System.out.println("==================================================================================== ");
    }

    public static void testVaciar() {
        Lista l6 = new Lista();
        l6.insertar(5, 1);
        l6.insertar(6, 2);
        l6.insertar(7, 3);
        System.out.println("Se insertaron 3 elementos en la lista");
        System.out.println(l6.toString());
        System.out.println("Se vacia la lista");
        l6.vaciar();
        System.out.println(l6.toString());
        System.out.println("La lista esta vacia: " + l6.esVacia());
        System.out.println("==================================================================================== ");
    }

    public static void testClone() {
        Lista l6 = new Lista();
        l6.insertar(5, 1);
        l6.insertar(6, 2);
        l6.insertar(7, 3);
        Lista clon = l6.clone();
        System.out.println("Lista: " + l6.toString());
        System.out.println("Lista clon: " + clon.toString());
        System.out.println("La longitud de clon es 3: " + (3 == clon.longitud()));
        System.out.println("Retorna 5: " + (clon.recuperar(1).equals(5)));
        System.out.println("Retorna 6: " + (clon.recuperar(2).equals(6)));
        System.out.println("Retorna 7: " + (clon.recuperar(3).equals(7)));
        System.out.println("==================================================================================== ");
    }

    public static void testToString() {
        Lista l7 = new Lista();
        l7.insertar(5, 1);
        l7.insertar(6, 2);
        l7.insertar(7, 3);
        String resultado = "5 -> 6 -> 7 -> null";
        System.out.println(resultado + "\t\t" + l7.toString());
        System.out.println("==================================================================================== ");
    }

    public static void testEliminarApariciones() {
        Lista l8 = new Lista();
        l8.insertar(1, 1);
        l8.insertar(2, 2);
        l8.insertar(1, 3);
        l8.insertar(3, 4);
        l8.insertar(4, 5);
        System.out.println("Lista: "+ l8.toString());
        System.out.println("Se usa el eliminarApariciones, elimina a 1: debera retornar [2,3,4]");
        l8.eliminarApariciones(1);
        System.out.println("Lista modificada: " + l8.toString());
        System.out.println("==================================================================================== ");
    }
}
