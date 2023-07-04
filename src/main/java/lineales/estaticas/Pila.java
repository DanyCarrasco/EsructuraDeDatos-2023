/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
 * - Jonathan Maximiliano Cabrera, 108665
 */

public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 10;

    public Pila() {
        // Crea y devuelve la pila vacía.
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        // Pone el elemento nuevoElem en el tope de la pila. 
        // Devuelve verdadero si el elemento se pudo apilar y falso en caso contrario.
        boolean exito;
        if (this.tope + 1 >= this.TAMANIO) {
            //Error: pila llena
            exito = false;
        } else {
            //pone el elemento en el tope de la pila e incrementa tope
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }

        return exito;
    }

    public boolean desapilar() {
        // Saca el elemento del tope de la pila. 
        // Devuelve verdadero si la pila no estaba vacía al momento de desapilar
        // (es decir que se pudo desapilar) y falso en caso contrario.
        boolean exito = false;
        if (this.tope != -1) { // Error: pila vacia
            //asigna null a tope y disminuye a tope
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        // Devuelve el elemento en el tope de la pila. 
        // Precondición: la pila no está vacía.
        Object elemTope = null; //retorna null si esta vacia
        if (this.tope != -1) {
            elemTope = this.arreglo[tope];
        }
        return elemTope;
    }

    public boolean esVacia() {
        // Devuelve verdadero si la pila no tiene elementos y falso en caso contrario.
        return this.tope == -1;
    }

    public void vaciar() {
        // Saca todos los elementos de la pila.
        if (this.tope != -1) {
            for (int i = 0; i < this.tope; i++) {
                //Recorre toda la pila
                this.arreglo[i] = null;
            }
            this.tope = -1;
        }
    }

    @Override
    public Pila clone() {
        // Devuelve una copia exacta de los datos en la estructura original, 
        // y respetando el orden de los mismos, en otra estructura del mismo tipo
        Pila pilaClon = new Pila();
        if (this.tope != -1) {
            for (int i = 0; i <= this.tope; i++) { //Recorre toda la pila para clonar
                pilaClon.arreglo[i] = this.arreglo[i];
            }
            pilaClon.tope = this.tope;
        }
        return pilaClon;
    }

    @Override
    public String toString() {
        // Devuelve una cadena de caracteres formada por todos los elementos de 
        // la pila para poder mostrarla por pantalla.
        String cadena = "Pila vacia";
        if (this.tope != -1) {
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
