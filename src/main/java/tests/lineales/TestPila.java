/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Pila;
import repaso.Alumno;
import repaso.Domicilio;

/**
 *
 * @author danyc
 */
public class TestPila {
    //testing propio de Pila

    public static void main(String[] args) {
        //Test para probar la clase Pila con numeros enteros
        System.out.println("prueba");
        Pila n1 = new Pila();
        System.out.println("Prueba de apilar y desapilar");
        System.out.println("Apilo el numero 1 en Pila n1");
        System.out.println("Resultado: " + n1.apilar(1));
        System.out.println();
        System.out.println("Apilo el numero 2 en Pila n1");
        System.out.println("Resultado: " + n1.apilar(2));
        System.out.println();
        System.out.println("Desapilo el numero 2 en Pila n1");
        System.out.println("Resultado: " + n1.desapilar());
        System.out.println();

        System.out.println("Prueba de obtenerTope");
        System.out.println("Debe devolver 1, porque es el tope de n1");
        System.out.println("Resultado: " + (int) n1.obtenerTope());
        System.out.println();

        System.out.println("Prueba de esVacia y vaciar");
        System.out.println("Verifico si mi pila esta vacia, debe devolver false");
        System.out.println("Resultado: " + n1.esVacia());
        System.out.println("Vacio la pila n1");
        n1.vaciar();
        System.out.println("Ahora esVacia debe retornar true");
        System.out.println("Resultado: " + n1.esVacia());
        System.out.println();

        System.out.println("Prueba de clone y toString");
        System.out.println("Lleno la pila n1 desde 1 hasta 5");
        n1.apilar(1);
        n1.apilar(2);
        n1.apilar(3);
        n1.apilar(4);
        n1.apilar(5);
        System.out.println("Hago un clon de n1");
        Pila n2 = n1.clone();
        System.out.println("Resultados:");
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        System.out.println("Vacio n1");
        n1.vaciar();
        System.out.println("Hago otro clon de n1");
        Pila n3 = n1.clone();
        System.out.println("Resultados:");
        System.out.println(n1.toString());
        System.out.println(n3.toString());

        n2.vaciar();
        System.out.println("Ejercicio 2.1 inciso 3");
        System.out.println("En la pila n1 lleno con digitos capicuos, debe ser true");
        n1.apilar(1);
        n1.apilar(2);
        n1.apilar(2);
        n1.apilar(1);
        System.out.println("Resultado: " + esCapicua(n1));
        System.out.println("En la pila n2 lleno con digitos no capicuos, debe ser false");
        n2.apilar(1);
        n2.apilar(2);
        n2.apilar(3);
        n2.apilar(4);
        System.out.println("Resultado: " + esCapicua(n2));
        System.out.println("En la pila n3 esta vacia, debe ser false");
        System.out.println("Resultados: " + esCapicua(n3));
        System.out.println("En la pila n3 pongo un numero, deber ser true");
        n3.apilar(1);
        System.out.println("Resultados: " + esCapicua(n3));
        System.out.println();

        n1.vaciar();

        System.out.println("Ejercicio 2.1 inciso 4");
        System.out.println("Las pila n1 esta vacia");
        System.out.println("Prueba de apilar y desapilar");
        System.out.println("Apilo la palabra 'uno' en Pila n1");
        System.out.println("Resultado: " + n1.apilar("uno"));
        System.out.println("Apilo el palabra 'dos' en Pila n1");
        System.out.println("Resultado: " + n1.apilar("dos"));
        System.out.println("Desapilo el palabra 'dos' en Pila n1");
        System.out.println("Resultado: " + n1.desapilar());
        System.out.println();

        System.out.println("Prueba de obtenerTope");
        System.out.println("Debe devolver 'uno', porque es el tope de n1");
        System.out.println("Resultado: " + (String) n1.obtenerTope());
        System.out.println();

        System.out.println("Prueba de esVacia y vaciar");
        System.out.println("Verifico si mi pila esta vacia, debe devolver false");
        System.out.println("Resultado: " + n1.esVacia());
        System.out.println("Vacio la pila n1");
        n1.vaciar();
        System.out.println("Ahora esVacia debe retornar true");
        System.out.println("Resultado: " + n1.esVacia());
        System.out.println();

        System.out.println("Prueba de clone y toString");
        System.out.println("Lleno la pila n1 desde la palabra 'uno' hasta 'cinco'");
        n1.apilar("uno");
        n1.apilar("dos");
        n1.apilar("tres");
        n1.apilar("cuatro");
        n1.apilar("cinco");
        System.out.println("Hago un clon de n1; n4");
        Pila n4 = n1.clone();
        System.out.println("Resultados:");
        System.out.println(n1.toString());
        System.out.println(n4.toString());
        System.out.println("Vacio n1");
        n1.vaciar();
        System.out.println("Hago otro clon de n1; n5");
        Pila n5 = n1.clone();
        System.out.println("Resultados:");
        System.out.println(n1.toString());
        System.out.println(n5.toString());
        System.out.println();
        
        System.out.println("Pruebas con la clase Alumno:");
        System.out.println("Prueba de apilar y desapilar");
        System.out.println("Resultado de apilar: "+ 
                n1.apilar(new Alumno ("Fai-2840", "Daniel",
                        "Carrasco",43552859, "DNI", 
                        (new Domicilio("calle1", 11, "ciudad1")),
                        "danyUsuario", "claveUsuaeio")));
        System.out.println("Resultado de desapilar: "+ n1.desapilar());

        System.out.println("Prueba de esVacia y vaciar");
        System.out.println("Verifico si mi pila esta vacia, debe devolver true");
        System.out.println("Resultado: " + n1.esVacia());
        System.out.println("Aplilo en n1");
        n1.apilar(new Alumno ("Fai-2840", "Daniel",
                        "Carrasco",43552859, "DNI", 
                        (new Domicilio("calle1", 11, "ciudad1")),
                        "danyUsuario", "claveUsuaeio"));
        System.out.println("Ahora esVacia debe retornar false");
        System.out.println("Resultado: " + n1.esVacia());
        System.out.println();
        
        System.out.println("Prueba de obtenerTope");
        System.out.println("Debe devolver un Alumno");
        System.out.println("Resultado: " + n1.obtenerTope().toString());
        System.out.println();

        System.out.println("Prueba de clone y toString");
        System.out.println("Hago un clon de n1; n6");
        Pila n6 = n1.clone();
        System.out.println("Resultados:");
        System.out.println(n1.toString());
        System.out.println(n6.toString());
        System.out.println("Vacio n1");
        n1.vaciar();
        System.out.println("Hago otro clon de n1; n7");
        Pila n7 = n1.clone();
        System.out.println("Resultados:");
        System.out.println(n1.toString());
        System.out.println(n7.toString());
    }

    public static boolean esCapicua(Pila p) {
        //En este metodo, si p es una pila vacia se considera como false
        boolean resultado = true;
        if (p.esVacia()) {
            resultado = false;
        } else {
            Pila aux = new Pila();
            Pila clon = p.clone();
            while (!p.esVacia()) {
                aux.apilar(p.obtenerTope());
                p.desapilar();
            }
            while (resultado & !clon.esVacia()) {
                if (aux.obtenerTope() != clon.obtenerTope()) {
                    resultado = false;
                } else {
                    aux.desapilar();
                    clon.desapilar();
                }
            }
        }
        return resultado;
    }

}
