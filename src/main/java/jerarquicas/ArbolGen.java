package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 * *********** Autores ***********
 * - Daniel Carrasco, FAI-2840
 * - Agustin Caceres FAI-2993
 * - Jonathan maximiliano cabrera, 108665
 */


public class ArbolGen {
    private NodoGen raiz;

    public ArbolGen() {
        // Crea un árbol genérico vacío
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object elemPadre) {
        /*Dado un elemento elemNuevo y un elemento elemPadre, agrega elemNuevo como hijo de la primer
        aparición de elemPadre. Para que la operación termine con éxito debe existir un nodo en el árbol con
        elemento = elemPadre. No se establece ninguna preferencia respecto a la posición del hijo respecto a sus
        posibles hermanos. Esta operación devuelve verdadero cuando se pudo agregar elemNuevo a la estructura
        y falso en caso contrario.*/
        boolean exito = false;
        if (this.raiz != null) {
            NodoGen nPadre = buscarNodo(this.raiz, elemPadre);
            if (nPadre != null) {
                NodoGen nuevo = new NodoGen(elem, null, null);
                if (nPadre.getHijoIzquierdo() == null) {
                    nPadre.setHijoIzquierdo(nuevo);
                } else {
                    NodoGen hijo = nPadre.getHijoIzquierdo();
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(nuevo);
                }
                exito = true;
            }
        } else {
            this.raiz = new NodoGen(elem, null, null);
            exito = true;
        }
        return exito;
    }

    private NodoGen buscarNodo(NodoGen n, Object elem) {
        /*Metodo recursivo que busca el nodo con el elemento "buscado", si lo encuentra lo retorna.
         En caso contrario, retorna null*/
        NodoGen encontrado = null;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                encontrado = n;
            } else {
                if (n.getHijoIzquierdo() != null) {
                    encontrado = buscarNodo(n.getHijoIzquierdo(), elem);
                }
                if (encontrado == null) {
                    if (n.getHijoIzquierdo() != null) {
                        NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                        while (hijo != null && encontrado == null) {
                            encontrado = buscarNodo(hijo, elem);
                            hijo = hijo.getHermanoDerecho();
                        }
                    }
                }
            }
        }
        return encontrado;
    }

    public boolean pertenece(Object elem) {
        // Devuelve verdadero si el elemento pasado por parámetro está en el árbol, y falso en caso contrario.
        return buscarNodo(this.raiz, elem) != null;
    }

    public Lista ancestros(Object elem) {
        /*Si el elemento se encuentra en el árbol, devuelve una lista con el camino desde la raíz hasta dicho elemento
        (es decir, con los ancestros del elemento). Si el elemento no está en el árbol devuelve la lista vacía.*/
        Lista salida = new Lista();
        listarAncestros(this.raiz, elem, salida, 1);
        return salida;
    }

    private boolean listarAncestros(NodoGen n, Object elem, Lista ls, int i) {
        //Metodo recursivo en recorrido preorden que enlista los elementos de cada nodo hasta encontrar el elemento
        boolean encontrado = false;
        if (n != null) {
            ls.insertar(n.getElem(), i);
            if (n.getElem().equals(elem)) {
                ls.eliminar(i);
                encontrado = true;
            } else {
                if (n.getHijoIzquierdo() != null) {
                    encontrado = listarAncestros(n.getHijoIzquierdo(), elem, ls, i + 1);
                }
                if (!encontrado) {
                    if (n.getHijoIzquierdo() != null) {
                        NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                        while (hijo != null && !encontrado) {
                            encontrado = listarAncestros(hijo, elem, ls, i + 1);
                            hijo = hijo.getHermanoDerecho();
                        }
                    }
                }
                if (!encontrado) {
                    //En caso de no encontrarse el elemento, se elimina de la lista el nodo enlistado
                    ls.eliminar(i);
                }
            }
        }
        return encontrado;
    }

    public boolean esVacio() {
        // Devuelve falso si hay al menos un elemento cargado en el árbol y verdadero en caso contrario.
        return this.raiz == null;
    }

    public int altura() {
        // Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja
        /*(Nota: un árbol vacío tiene altura -1 y una hoja tiene altura 0).*/
        int altura = -1;
        if (this.raiz != null) {
            altura = alturaAux(this.raiz);
        }
        return altura;
    }

    private int alturaAux(NodoGen n) {
        //Modulo recursivo que busca y retorna la longitud el camino mas largo del arbol
        int alturaNodo = 0, alturaHIzq = 0, alturaHDer;
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                alturaHIzq = 1 + alturaAux(n.getHijoIzquierdo());
            }
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    alturaHDer = 1 + alturaAux(hijo);
                    if (alturaHIzq < alturaHDer) {
                        alturaHIzq = alturaHDer;
                    }
                    hijo = hijo.getHermanoDerecho();
                }
            }
            alturaNodo = alturaHIzq;
        }
        return alturaNodo;
    }

    public int nivel(Object elem) {
        // Devuelve el nivel de un elemento en el árbol. Si el elemento no existe en el árbol devuelve -1.
        int nivel = -1;
        if (this.raiz != null) {
            nivel = nivelAux(this.raiz, elem);
            if (nivel != -1) {
                nivel--;
            }
        }
        return nivel;
    }

    private int nivelAux(NodoGen n, Object elem) {
        //Modulo recursivo que retorna el nivel del nodo buscado con el elemento "elem"
        int nivelNodo = -1;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                nivelNodo = 0;
            } else {
                if (n.getHijoIzquierdo() != null) {
                    nivelNodo = nivelAux(n.getHijoIzquierdo(), elem);
                    if (nivelNodo == -1) {
                        NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                        while (hijo != null && nivelNodo == -1) {
                            nivelNodo = nivelAux(hijo, elem);
                            hijo = hijo.getHermanoDerecho();
                        }
                    }
                }
            }
            if (nivelNodo != -1) {
                nivelNodo++;
            }
        }
        return nivelNodo;
    }

    public Object padre(Object elem) {
        /* Dado un elemento devuelve el valor almacenado en su nodo padre
        (busca la primera aparición de elemento).*/
        Object elemPadre = null;
        if (this.raiz != null) {
            if (!this.raiz.getElem().equals(elem)) {
                elemPadre = padreAux(this.raiz, elem);
            }
        }
        return elemPadre;
    }

    private Object padreAux(NodoGen n, Object elem) {
        //Modulo recursivo que retorna el elemento del nodo padre encontrado con el nodo que tiene al elemento "elem"
        Object elemPadre = null;
        if (n != null) {
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null && elemPadre == null) {
                if (hijo.getElem().equals(elem)) {
                    elemPadre = n.getElem();
                }
                hijo = hijo.getHermanoDerecho();
            }
            if (elemPadre == null) {
                hijo = n.getHijoIzquierdo();
                while (hijo != null && elemPadre == null) {
                    elemPadre = padreAux(hijo, elem);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return elemPadre;
    }

    public Lista listarPreorden() {
        // Devuelve una lista con los elementos del árbol en el recorrido en preorden
        Lista salida = new Lista();
        listarPreordenAux(this.raiz, salida);
        return salida;
    }

    private void listarPreordenAux(NodoGen n, Lista ls) {
        //Modulo recursivo que enlista los elementos del arbol generico en el recorrido en preorden
        ls.insertar(n.getElem(), ls.longitud() + 1);
        if (n.getHijoIzquierdo() != null) {
            listarPreordenAux(n.getHijoIzquierdo(), ls);
        }

        if (n.getHijoIzquierdo() != null) {
            NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
            while (hijo != null) {
                listarPreordenAux(hijo, ls);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInorden() {
        // Devuelve una lista con los elementos del árbol en el recorrido en inorden
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        //Modulo recursivo que enlista los elementos del arbol generico en el recorrido en inorden
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
            ls.insertar(n.getElem(), ls.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        // Devuelve una lista con los elementos del árbol en el recorrido en posorden
        Lista salida = new Lista();
        listarPosordenAux(this.raiz, salida);
        return salida;
    }

    private void listarPosordenAux(NodoGen n, Lista ls) {
        //Modulo recursivo que enlista los elementos del arbol generico en el recorrido en posorden
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                listarPosordenAux(n.getHijoIzquierdo(), ls);
            }
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPosordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            ls.insertar(n.getElem(), ls.longitud() + 1);
        }
    }

    public Lista listarPorNiveles() {
        // Devuelve una lista con los elementos del árbol en el recorrido por niveles
        Lista salida = new Lista();
        listarPorNivelAux(this.raiz, salida);
        return salida;
    }

    private void listarPorNivelAux(NodoGen n, Lista ls) {
        //Modulo auxiliar que enlista los elementos del arbol generico el recorrido por niveles con la ayuda de una Cola
        Cola q1 = new Cola();
        q1.poner(n);
        while (!q1.esVacia()) {
            NodoGen nActual = (NodoGen) q1.obtenerFrente();
            q1.sacar();
            ls.insertar(nActual.getElem(), ls.longitud() + 1);
            NodoGen hijo = nActual.getHijoIzquierdo();
            while (hijo != null) {
                q1.poner(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public ArbolGen clone() {
        /* Genera y devuelve un árbol genérico que es equivalente
        (igual estructura y contenido de los nodos) que el árbol original.*/
        ArbolGen clon = new ArbolGen();
        clon.raiz = cloneAux(this.raiz);
        return clon;
    }

    private NodoGen cloneAux(NodoGen n) {
        //Modulo recursivo en recorrido preorden que retorna un nodo raiz generico equivalente al nodo raiz generico original
        NodoGen nuevo = null;
        if (n != null) {
            nuevo = new NodoGen(n.getElem(), null, null);
            if (n.getHijoIzquierdo() != null) {
                nuevo.setHijoIzquierdo(cloneAux(n.getHijoIzquierdo()));
            }
            if (n.getHermanoDerecho() != null) {
                nuevo.setHermanoDerecho(cloneAux(n.getHermanoDerecho()));
            }
        }
        return nuevo;
    }

    public void vaciar() {
        // Quita todos los elementos de la estructura.
        this.raiz = null;
    }

    public String toString() {
        /* Genera y devuelve una cadena de caracteres que indica
        cuál es la raíz del árbol y quienes son los hijos de cada nodo.*/
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        /*Modulo recursivo que retorna una cadena de caracteres que indican la estructura del arbol original
        con sus elementos e indicando los hijos de cada nodo*/
        String s = "";
        if (n != null) {
            // visita del nodo n
            s += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            //comienza recorrido de los hijos de n llamando recursivamente
            //para que cada hijo agregue su subcadena a la general
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }


    public int grado() {
        //Devuelve el grado mas grande de un nodo que se busca desde la raiz del arbol
        return gradoAux(this.raiz);
    }

    private int gradoAux(NodoGen n) {
        //Modulo recursivo que busca el nodo mas grande en el arbol desde nodo "n"
        int grado = -1;
        if (n != null) {
            if (n.getHijoIzquierdo() != null) {
                int gAux = gradoAux(n.getHijoIzquierdo());
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                int aux = 1;
                while (hijo != null) {
                    aux++;
                    grado = gradoAux(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
                if (grado < aux) {
                    grado = aux;
                }
                if (grado < gAux) {
                    grado = gAux;
                }
            } else {
                grado = 0;
            }
        }
        return grado;
    }

    public int gradoSubarbol(Object elem) {
        //Devuelve el grado mas grande de un nodo que se busca desde el nodo "elem" del arbol
        return gradoAux(buscarNodo(this.raiz, elem));
    }

    /*Operaciones de ejercicios adicionales*/
    public Lista frontera() {
        /*Devuelve una lista con todos los elementos almacenados en las hojas del árbol listadas de izquierda a derecha.*/
        Lista salida = new Lista();
        fronteraAux(this.raiz, salida, 1);
        return salida;
    }

    private void fronteraAux(NodoGen n, Lista lis, int i) {
        //Metodo recursivo que enlista las hojas del arbol original de izquierda a derecha
        if (n != null) {
            if (n.getHijoIzquierdo() == null) {
                lis.insertar(n.getElem(), i);
                i++;
            } else {
                fronteraAux(n.getHijoIzquierdo(), lis, i);
            }

            if (n.getHermanoDerecho() != null) {
                fronteraAux(n.getHermanoDerecho(), lis, i);
            }
        }
    }

    public boolean verificarPatron(Lista lisPatron) {
        /*Recibe por parámetro una lista de Object lisPatron y determine si dicha lista coincide exactamente
        con al menos un camino del árbol que comience en la raíz y termine en una hoja.
        El método retorna un valor boolean.*/
        return verificarPatronAux(this.raiz, lisPatron, 1);
    }

    private boolean verificarPatronAux(NodoGen n, Lista lis, int i) {
        /*Metodo recursivo que verifica si en lista "lis" coincide con un camino del arbol
         desde raiz hasta terminar en una hoja*/
        boolean valido = false;
        if (n != null) {
            if (n.getElem().equals(lis.recuperar(i))) {
                if (n.getHijoIzquierdo() == null) {
                    valido = true;
                } else {
                    i++;
                    valido = verificarPatronAux(n.getHijoIzquierdo(), lis, i);
                }
            } else {
                if (n.getHermanoDerecho() != null) {
                    valido = verificarPatronAux(n.getHermanoDerecho(), lis, i);
                }
            }
        }
        return valido;
    }

    public Lista listaQueJustificaLaAltura() {
        /*Devuelve una lista de elementos que es el camino que comienza en la raíz y termina en la hoja más lejana.*/
        Lista lisAltura;
        lisAltura = listarAltura(this.raiz, (new Lista()), (new Lista()), 1);
        return lisAltura;
    }

    private Lista listarAltura(NodoGen n, Lista lis, Lista lisMasLarga, int i) {
        //Modulo recursivo que retorna una lista con el camino mas largo desde la raiz hasta la hoja del arbol
        if (n != null) {
            lis.insertar(n.getElem(), i);
            if (n.getHijoIzquierdo() == null) {
                if (lisMasLarga.longitud() < lis.longitud()) {
                    lisMasLarga = lis;
                }
            } else {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null) {
                    lisMasLarga = listarAltura(hijo, lis, lisMasLarga, i++);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            lis.eliminar(i);
        }
        return lisMasLarga;
    }
/*Operaciones de ejercicios de simulacros del 2° parcial*/
    public boolean equals(ArbolGen unArbol) {
        return equalsAux(this.raiz, unArbol.raiz);
    }

    private boolean equalsAux(NodoGen n, NodoGen n2) {
        boolean igual = true;
        if (n != null && n2 != null) {
            if (n.getElem().equals(n2.getElem())) {
                igual = equalsAux(n.getHijoIzquierdo(), n2.getHijoIzquierdo());
            } else {
                igual = false;
            }

            if (igual) {
                igual = equalsAux(n.getHermanoDerecho(), n2.getHermanoDerecho());
            }
        } else {
            if (n != null || n2 != null) {
                igual = false;
            }
        }
        return igual;
    }

    public boolean sonFrontera(Lista lista) {
        return sonFronteraAux(this.raiz, lista);
    }

    private boolean sonFronteraAux(NodoGen n, Lista lis) {
        boolean igual = true;
        if (n != null) {
            if (n.getHijoIzquierdo() == null) {
                if (lis.localizar(n.getElem()) <= 0) {
                    igual = false;
                }
            } else {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null && igual) {
                    igual = sonFronteraAux(hijo, lis);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return igual;
    }
}
