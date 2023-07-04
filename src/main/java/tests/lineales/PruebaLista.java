package tests.lineales;

import java.util.Scanner;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

public class PruebaLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        menu();
        opcion = scanner.nextInt();
        while (opcion != 4) {
            menu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    pruebaConcatenar();
                    break;
                case 2:
                    pruebaComprobar();
                    break;
                case 3:
                    pruebaInvertir();
                    break;
                case 4:
                    System.out.println("Se termino la prueba.");
                    break;
                default:
                    System.out.println("Opcion no valida por favor ingrese ");
                    break;
            }
        }
        scanner.close();
    }

    public static void menu() {
        System.out.println("Elegir una opcion: ");
        System.out.println("Seleccione 1 para concatenar");
        System.out.println(
                "concatenar: recibe dos listas L1 y L2 y devuelve una lista nueva con los elementos de L1 y L2 concatenados."
                        +
                        "Ej: si L1=[2,4,6] y L2=[5,1,6,7] debe devolver [2,4,6,5,1,6,7]");
        System.out.println("Seleccione 2 para comprobar");
        System.out.println("comprobar: recibe una lista L1 cargada con dígitos (números enteros de 0 a 9) y verifica si"
                +
                " elementos que contiene tienen la forma cadena0cadena0cadena* (donde cadena* es cadena invertida). " +
                "Ej: si L1=[9,6,5,0,9,6,5,0,5,6,9], cadena=965, luego cadena*=569, entonces la lista L1 cumple con la condición deseada.");
        System.out.println("Seleccione 3 para invertir");
        System.out.println(
                "invertir: recibe una lista L y devuelve una lista nueva con los elementos de L invertidos. Ej: si " +
                        "L1=[2,4,6] debe devolver [6,4,2]");
        System.out.println("Seleccione 4 para terminar con esta prueba.");
    }

    public static void pruebaConcatenar() {
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        int i = 1, j = 1;
        while (i <= 3) {
            l1.insertar(j, i);
            i++;
            j = j + 2;
        }
        i = 1;
        j = 2;
        while (i <= 3) {
            l2.insertar(j, i);
            i++;
            j = j + 2;
        }
        System.out.println("Lista l1: " + l1.toString());
        System.out.println("Lista l2: " + l2.toString());
        Lista l3 = concatenar(l1, l2);
        System.out.println("Lista concatenada: " + l3.toString());
    }

    public static Lista concatenar(Lista l1, Lista l2) {
        /*recibe dos listas L1 y L2 y devuelve una lista nueva con los elementos de L1 y L2 concatenados.*/
        //Ej: L1=[2,4,6] y L2=[5,1,6,7] ---> [2,4,6,5,1,6,7]
        //mejorar el codigo para que sea mas eficiente
        Lista nueva = new Lista();
        int long1, long2, j;
        long1 = l1.longitud();
        long2 = l2.longitud();
        for (int i = 1; i <= long1; i++) {
            nueva.insertar(l1.recuperar(i), i);
        }
        j = long1 + 1;
        for (int i = 1; i <= long2; i++) {
            nueva.insertar(l2.recuperar(i), j);
            j++;
        }
        return nueva;
    }

    public static void pruebaComprobar() {
        Lista l1 = new Lista();
        l1.insertar(7, 1);
        l1.insertar(3, 2);
        l1.insertar(0, 3);
        l1.insertar(7, 4);
        l1.insertar(3, 5);
        l1.insertar(0, 6);
        l1.insertar(3, 7);
        l1.insertar(7, 8);
        System.out.println("Lista l1: " + l1.toString());
        System.out.println("Debe retornar true: " + comprobar(l1));
        Lista l2 = new Lista();
        l2.insertar(7, 1);
        l2.insertar(3, 2);
        l2.insertar(0, 3);
        l2.insertar(7, 4);
        l2.insertar(7, 5);
        l2.insertar(0, 6);
        l2.insertar(3, 7);
        l2.insertar(7, 8);
        System.out.println("Lista l2: " + l2.toString());
        System.out.println("Debe retornar false: " + comprobar(l2));
        Lista l3 = new Lista();
        l3.insertar(7, 1);
        l3.insertar(0, 2);
        l3.insertar(7, 3);
        l3.insertar(0, 4);
        l3.insertar(7, 5);
        System.out.println("Lista l3: " + l3.toString());
        System.out.println("Debe retornar true: " + comprobar(l3));
    }

    public static boolean comprobar(Lista l1) {
        //metodo en prueba
        /*recibe una lista L1 cargada con dígitos (números enteros de 0 a 9) y verifica si los
        elementos que contiene tienen la forma cadena0cadena0cadena* (donde cadena* es cadena invertida).*/
        //Ej: L1=[9,6,5,0,9,6,5,0,5,6,9], cadena=965 y luego cadena*=569 ---> L1 cumple con la funcion
        boolean esValida = false;
        Pila p = new Pila();
        /*Cola c1 = new Cola();
        Pila p1 = new Pila();
        llenarCola(l1, c1, 1);
        llenarPilaCadenaInvertida(l1, p1, 1);
        esValida = comprobarLista(l1, c1, p1);*/
        return esValida;
    }



    /*private static void llenarCola(Lista l1, Cola c1, int num) {
        Object elem = l1.recuperar(num);
        if (!elem.equals(0)) {
            c1.poner(elem);
            llenarCola(l1, c1, num + 1);
        }
    }

    private static void llenarPilaCadenaInvertida(Lista l1, Pila p1, int num) {
        Object elem = l1.recuperar(num);
        if (!elem.equals(0)) {
            p1.apilar(elem);
            llenarPilaCadenaInvertida(l1, p1, num + 1);
        }
    }

    public static boolean comprobarLista(Lista l1, Cola c1, Pila p1) {
        boolean esValida;
        Cola c2 = c1.clone();
        int num = comprobarConCola(l1, c1, 1);
        if (num == -1) {
            esValida = false;
        } else {
            //salta error en esta parte
            int num2 = comprobarConCola(l1, c2, num);
            if (num2 == -1) {
                esValida = false;
            } else {
                esValida = comprobarConPila(l1, p1, num2);
            }
        }
        return esValida;
    }

    private static int comprobarConCola(Lista l1, Cola c, int num) {
        int i = -1;
        Object elem = l1.recuperar(num);
        if (c.esVacia() && elem.equals(0)) {
            i = num + 1;
        } else {
            //cuando comprueba c2, obtenerFrente retorna null: Aun siendo una cola que no es vacia
            if (c.obtenerFrente().equals(elem)) {
                c.sacar();
                i = comprobarConCola(l1, c, num + 1);
            }
        }
        return i;
    }

    private static boolean comprobarConPila(Lista l1, Pila p1, int num) {
        boolean esValido = false;
        Object elem = l1.recuperar(num);
        if (p1.esVacia()) {
            esValido = true;
        } else {
            if (elem.equals(p1.obtenerTope())) {
                p1.desapilar();
                esValido = comprobarConPila(l1, p1, num + 1);
            }
        }
        return esValido;
    }*/

    public static void pruebaInvertir() {
        Lista l1 = new Lista();
        l1.insertar(1, 1);
        l1.insertar(3, 2);
        l1.insertar(5, 3);
        System.out.println("Lista l1: " + l1.toString());
        Lista l2 = invertir(l1);
        System.out.println("Lista invertida: " + l2.toString());
    }

    public static Lista invertir(Lista l1) {
        //recibe una lista L y devuelve una lista nueva con los elementos de L invertidos.
        //Ej: L1 =[2,4,6] ---> devuelve [6,4,2]
        Lista l2 = new Lista();
        Pila p1 = new Pila();
        llenarPila(l1, p1, 1);
        llenarListaInversa(l2, p1, 1);
        return l2;
    }

    private static void llenarListaInversa(Lista l1, Pila p1, int num) {
        Object elem = p1.obtenerTope();
        if (!p1.esVacia()) {
            l1.insertar(elem, num);
            p1.desapilar();
            llenarListaInversa(l1, p1, num + 1);
        }
    }

    private static void llenarPila(Lista l1, Pila p1, int num) {
        Object elem = l1.recuperar(num);
        if (elem != null) {
            p1.apilar(elem);
            llenarPila(l1, p1, num + 1);
        }
    }
    /*puedo hacer otros tres metodos mas de ejercicios adicionales:
     intercalar, contar y esCapicua en el pdf Estructuras lineales pag. 23*/

}
