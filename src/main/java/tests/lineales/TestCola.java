/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Cola;

/**
 *
 * @author danyc
 */
public class TestCola {
    //testing propio de Cola

    public static void main(String[] args) {
        Cola c1 = new Cola();
        System.out.println("Prueba de poner y sacar");
        System.out.println("pone con cola vacia, retorna true: " + c1.poner(1));
        c1.vaciar();
        System.out.println("vacio la cola: " + c1.esVacia());
        System.out.println("pone mayor de 10");
        boolean resultado;
        int i = 1;
        while (i < 12) {
            resultado = c1.poner(i);
            System.out.println("poner un elemento: " + resultado);
            System.out.println(c1.toString());
            if (resultado == false) {
                System.out.println("Cola llena");
            }
            i++;
        }
        System.out.println("saca mayor de 10");
        i = 1;
        while (i < 12) {
            resultado = c1.sacar();
            System.out.println("sacar un elemento: " + resultado);
            System.out.println(c1.toString());
            i++;
        }
        System.out.println("pone menos de 10");
        i = 1;
        while (i < 10) {
            resultado = c1.poner(i);
            System.out.println("poner un elemento: " + resultado);
            System.out.println(c1.toString());
            if (resultado == false) {
                System.out.println("Cola llena");
            }
            i++;
        }
        System.out.println("saca menos de 10");
        i = 1;
        while (i < 10) {
            resultado = c1.sacar();
            System.out.println("sacar un elemento: " + resultado);
            System.out.println(c1.toString());
            i++;
        }
        System.out.println("saca con cola vacia, se espera false: " + c1.sacar());
        System.out.println("---------------------------------------------");
        System.out.println();

        System.out.println("Prueba de obtenerFrente");
        System.out.println("Cola: " + c1.toString());
        System.out.println("cuando es cola vacia: " + (c1.obtenerFrente() == null));
        i = 1;
        while (i < 10) {
            resultado = c1.poner(i);
            i++;
        }
        System.out.println("Cola: " + c1.toString());
        System.out.println("cuando es menor a 10: " + c1.obtenerFrente());
        c1.poner(10);
        System.out.println("Cola: " + c1.toString());
        System.out.println("cuando son 10 elementos: " + c1.obtenerFrente());
        c1.poner(11);
        System.out.println("Cola: " + c1.toString());
        System.out.println("cuando es mayor a 10: " + c1.obtenerFrente());
        System.out.println("---------------------------------------------");
        System.out.println();

        System.out.println("Prueba de esVacia");
        System.out.println("Cola: " + c1.toString());
        System.out.println("cuando es cola llena, espera false: " + c1.esVacia());
        c1.vaciar();
        System.out.println("Cola: " + c1.toString());
        System.out.println("cuando es cola vacia, espera true: " + c1.esVacia());
        c1.poner(1);
        System.out.println("Cola: " + c1.toString());
        System.out.println("cuando cola no esta vacia, se espera false: " + c1.esVacia());
        System.out.println("---------------------------------------------");
        System.out.println();

        System.out.println("Prueba de vaciar");
        System.out.println(c1.toString());
        c1.vaciar();
        System.out.println("cola no esta vacia: " + c1.toString());
        System.out.println(c1.toString());
        c1.vaciar();
        System.out.println("cola vacia: " + c1.toString());
        i = 1;
        while (i < 10) {
            resultado = c1.poner(i);
            i++;
        }
        System.out.println(c1.toString());
        c1.vaciar();
        System.out.println("cola llena: " + c1.toString());
        System.out.println("---------------------------------------------");
        System.out.println();

        System.out.println("Prueba de clone");
        System.out.println("es menor a 10");
        i = 1; 
        while (i < 10) {
            resultado = c1.poner(i);
            i++;
        }
        System.out.println("Cola: " + c1.toString());
        Cola c2 = c1.clone();
        System.out.println("Cola clon: " + c2.toString());
        System.out.println("son 10 elementos");
        c1.poner(10);
        System.out.println("Cola: " + c1.toString());
        c2 = c1.clone();
        System.out.println("Cola clon: " + c2.toString());
        System.out.println("es mayor a 10");
        c1.poner(11);
        System.out.println("Cola: " + c1.toString());
        c2 = c1.clone();
        System.out.println("Cola clon: " + c2.toString());
        System.out.println("cola vacia");
        c1.vaciar();
        System.out.println("Cola: " + c1.toString());
        c2 = c1.clone();
        System.out.println("Cola clon: " + c2.toString());
        System.out.println("---------------------------------------------");
        System.out.println();
    }
}
