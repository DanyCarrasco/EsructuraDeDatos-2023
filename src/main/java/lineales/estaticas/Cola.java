/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.estaticas;

/**
 *
 * @author danyc
 */

/**
 * *********** Autores ***********
 * - Daniel Carrasco, FAI-2840
 * - Agustin Caceres FAI-2993
 * - Jonathan maximiliano cabrera, 108665
 */

public class Cola {

    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola() {
        // Crea y devuelve una cola vacía
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object elem) {
        // Pone el elemento al final de la cola. 
        //Devuelve verdadero si el elemento se pudo agregar en la estructura y falso en caso contrario.
        boolean exito = true;
        if ((this.fin + 1) % this.TAMANIO == this.frente) { //cola llena, reporta error
            exito = false;
        } else { // al menos hay 1 lugar: avanza fin (de manera circular)
            this.arreglo[this.fin] = elem;
            this.fin = (this.fin + 1) % this.TAMANIO;
        }
        return exito;
    }

    public boolean sacar() {
        // Saca el elemento que está en el frente de la cola. 
        // Devuelve verdadero si el elemento se pudo sacar y falso en caso contrario.
        boolean exito = true;
        if (this.frente == this.fin) { // la cola esta vacia, reporta error
            exito = false;
        } else { // al menos hay 1 elemento: avanza frente (de manera circular)
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente() {
        // Devuelve el elemento que está en el frente. 
        // Precondición: la cola no está vacía.
        Object elem = null; // Si esta vacia, retorna null
        if (this.frente != this.fin) { 
            elem = this.arreglo[this.frente];
        }
        return elem;
    }

    public boolean esVacia() {
        // Devuelve verdadero si la cola no tiene elementos y falso en caso contrario
        return this.frente == this.fin;
    }

    public void vaciar() {
        // Saca todos los elementos de la estructura.
        while (this.arreglo[this.frente] != null) {
            //asigna null a los elementos que estan en el arreglo
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        this.frente = 0;
        this.fin = 0;
    }

    public Cola clone() {
        // Devuelve una copia exacta de los datos en la estructura original, 
        // y respetando el orden de los mismos, en otra estructura del mismo tipo
        Cola clonCola = new Cola();
        clonCola.arreglo = this.arreglo.clone();
        clonCola.frente = this.frente;
        clonCola.fin = this.fin;
        return clonCola;
    }

    public String toString() {
        // Crea y devuelve una cadena de caracteres formada por todos los elementos de la cola para poder mostrarla por pantalla.
        String cadena;
        if (this.frente == this.fin) {
            cadena = "Cola vacia";
        } else {
            cadena = "[";
            for (int i = 0; i < this.TAMANIO; i++) {
                if (this.arreglo[i] == null) {
                    cadena = cadena + " - ";
                } else {
                    cadena = cadena + this.arreglo[i].toString();
                }
                if (i != (this.TAMANIO - 1)) {
                    cadena = cadena + ", ";
                } else {
                    cadena = cadena + "]";
                }
            }
        }
        return cadena;
    }
}
