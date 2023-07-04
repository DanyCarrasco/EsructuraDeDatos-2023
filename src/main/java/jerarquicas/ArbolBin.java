package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin() {
        // Crea un árbol binario vacío
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        /*Dado un elemento elemNuevo y un elemento elemPadre, inserta elemNuevo como hijo izquierdo o derecho
        de la primer aparición de elemPadre, según lo indique el parámetro lugar. Para que la operación
        termine con éxito debe existir un nodo en el árbol con elemento = elemPadre y ese nodo debe tener libre
        su hijo posicion. Si puede realizar la inserción devuelve verdadero, en caso contrario devuelve falso.*/
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else {
                    if (lugar == 'D' && nPadre.getDerecho() == null) {
                        nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    } else {
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        //Busca el nodo con el elemento "buscado", si lo encuentra lo retorna. En caso contrario, retorna null
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                resultado = n;
            } else {
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        // Devuelve falso si hay al menos un elemento cargado en el árbol y verdadero en caso contrario.
        return this.raiz == null;
    }

    public int altura() {
        // Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja
        int alturaArbol = -1;
        if (this.raiz != null) {
            alturaArbol = alturaNodoAux(this.raiz);
        }
        return alturaArbol;
    }

    private int alturaNodoAux(NodoArbol nodo) {
        //Modulo recursivo que busca y retorna la longitud el camino mas largo del arbol
        int alturaNodo = 0, alturaIzq = 0, alturaDer = 0;
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                alturaIzq = 1 + alturaNodoAux(nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                alturaDer = 1 + alturaNodoAux(nodo.getDerecho());
            }
            if (alturaDer < alturaIzq) {
                alturaNodo = alturaIzq;
            } else {
                alturaNodo = alturaDer;
            }
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

    private int nivelAux(NodoArbol nodo, Object elem) {
        //Modulo recursivo que retorna el nivel del nodo buscado con el elemento "elem"
        int nivelNodo = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                nivelNodo = 0;
            } else {
                nivelNodo = nivelAux(nodo.getIzquierdo(), elem);
                if (nivelNodo == -1) {
                    nivelNodo = nivelAux(nodo.getDerecho(), elem);
                }
            }
            if (nivelNodo != -1) {
                nivelNodo++;
            }
        }
        return nivelNodo;
    }

    public Object padre(Object elem) {
        // Dado un elemento devuelve el valor almacenado en su nodo padre (busca la primera aparición de elemento).
        Object elemPadre = null;
        if (this.raiz != null) {
            if (!this.raiz.getElem().equals(elem)) {
                elemPadre = padreAux(this.raiz, elem);
            }
        }
        return elemPadre;
    }

    private Object padreAux(NodoArbol nodo, Object elem) {
        //Modulo recursivo que retorna el elemento del nodo padre encontrado con el nodo que tiene al elemento "elem"
        Object elemPadre = null;
        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().equals(elem)) {
                elemPadre = nodo.getElem();
            } else {
                if (nodo.getDerecho() != null && nodo.getDerecho().getElem().equals(elem)) {
                    elemPadre = nodo.getElem();
                } else {
                    elemPadre = padreAux(nodo.getIzquierdo(), elem);
                    if (elemPadre == null) {
                        elemPadre = padreAux(nodo.getDerecho(), elem);
                    }
                }
            }
        }
        return elemPadre;
    }

    public void vaciar() {
        // Quita todos los elementos de la estructura.
        this.raiz = null;
    }

    public Lista listarPreorden() {
        // Devuelve una lista con los elementos del árbol binario en el recorrido en preorden
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        //Modulo recursivo que enlista los elementos del arbol binario en el recorrido en preorden
        if (nodo != null) {
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarInorden() {
        // Devuelve una lista con los elementos del árbol binario en el recorrido en inorden
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        //Modulo recursivo que enlista los elementos del arbol binario en el recorrido en inorden
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarInordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPosorden() {
        // Devuelve una lista con los elementos del árbol binario en el recorrido en posorden
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lis) {
        //Modulo recursivo que enlista los elementos del arbol binario en el recorrido en posorden
        if (nodo != null) {
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }

    public Lista listarPorNiveles() {
        // Devuelve una lista con los elementos del árbol binario en el recorrido por niveles
        Lista lis = new Lista();
        if (this.raiz != null) {
            listarNivelesAux(this.raiz, lis);
        }
        return lis;
    }

    private void listarNivelesAux(NodoArbol aux, Lista lis) {
        //Modulo auxiliar que enlista los elementos del arbol binario el recorrido por niveles con la ayuda de una Cola
        Cola q1 = new Cola();
        q1.poner(aux);
        while (!q1.esVacia()) {
            NodoArbol nodoActual = (NodoArbol) q1.obtenerFrente();
            q1.sacar();
            lis.insertar(nodoActual.getElem(), lis.longitud() + 1);
            if (nodoActual.getIzquierdo() != null) {
                q1.poner(nodoActual.getIzquierdo());
            }
            if (nodoActual.getDerecho() != null) {
                q1.poner(nodoActual.getDerecho());
            }
        }
    }

    public ArbolBin clone() {
        /*Genera y devuelve un árbol binario que es equivalente (igual estructura y contenido de los nodos)
         que el árbol original.*/
        ArbolBin clon = new ArbolBin();
        clon.raiz = cloneAux(this.raiz);
        return clon;
    }

    private NodoArbol cloneAux(NodoArbol nodo) {
        //Modulo recursivo que retorna un nodo raiz binario equivalente al nodo raiz binario original
        NodoArbol nuevo = null;
        if (nodo != null) {
            nuevo = new NodoArbol(nodo.getElem(), cloneAux(nodo.getIzquierdo()), cloneAux(nodo.getDerecho()));
        }
        return nuevo;
    }

    public String toString() {
        /* Genera y devuelve una cadena de caracteres que indica cuál es la raíz del árbol y quienes son los hijos
        de cada nodo.*/
        String cadena = "Arbol vacio";
        if (this.raiz != null) {
            cadena = toStringAux(this.raiz);
        }
        return cadena;
    }

    private String toStringAux(NodoArbol nodo) {
        /*Modulo recursivo que retorna una cadena de caracteres que indican la estructura del arbol original
        con sus elementos e indicando los hijos de cada nodo*/
        String cadenaNodo = "";
        if (nodo != null) {
            cadenaNodo = nodo.getElem().toString();
            if (nodo.getIzquierdo() != null) {
                cadenaNodo = cadenaNodo + ": HI: " + nodo.getIzquierdo().getElem().toString();
            } else {
                cadenaNodo = cadenaNodo + ": HI:--";
            }
            if (nodo.getDerecho() != null) {
                cadenaNodo = cadenaNodo + ", HD: " + nodo.getDerecho().getElem().toString() + "\n";
            } else {
                cadenaNodo = cadenaNodo + ", HD:--\n";
            }
            cadenaNodo = cadenaNodo + toStringAux(nodo.getIzquierdo());
            cadenaNodo = cadenaNodo + toStringAux(nodo.getDerecho());
        }
        return cadenaNodo;
    }

    public Lista frontera() {
        /*Devuelve una lista con todos los elementos almacenados en las hojas del árbol listadas de izquierda a derecha.*/
        Lista lis = new Lista();
        fronteraAux(this.raiz, lis, 1);
        return lis;
    }

    private int fronteraAux(NodoArbol n, Lista lis, int i) {
        //Metodo recursivo que enlista las hojas del arbol original de izquierda a derecha
        if (n != null) {
            if (n.getIzquierdo() == null && n.getDerecho() == null) {
                lis.insertar(n.getElem(), i);
                i++;
            } else {
                i = fronteraAux(n.getIzquierdo(), lis, i);
                i = fronteraAux(n.getDerecho(), lis, i);
            }
        }
        return i;
    }

    public Lista obtenerAncestros(Object elem) {
        /*devuelve en una lista todos los ancestros del elemento pasado por parámetro
        (si el elemento no está, devuelve la lista vacía)*/
        Lista lis = new Lista();
        obtenerAncestrosAux(this.raiz, lis, elem, 1);
        return lis;
    }

    private boolean obtenerAncestrosAux(NodoArbol n, Lista lis, Object elem, int i) {
        //Metodo recursivo en recorrido preorden que enlista los elementos de cada nodo hasta encontrar el elemento
        boolean encontrado = false;
        if (n != null) {
            lis.insertar(n.getElem(), i);
            if (elem.equals(n.getElem())) {
                lis.eliminar(i);
                encontrado = true;
            } else {
                if (n.getIzquierdo() != null) {
                    encontrado = obtenerAncestrosAux(n.getIzquierdo(), lis, elem, i++);
                }
                if (!encontrado && n.getDerecho() != null) {
                    encontrado = obtenerAncestrosAux(n.getDerecho(), lis, elem, i++);
                }
            }
            if (!encontrado) {
                //En caso de no encontrarse el elemento, se elimina de la lista el nodo enlistado
                lis.eliminar(i);
            }
        }
        return encontrado;
    }

    public Lista obtenerDescendientes(Object elem) {
        /*devuelve en una lista todos los descendientes del elemento pasado por parámetro
        (si el elemento no está, devuelve la lista vacía)*/
        Lista lis = new Lista();
        obtenerDescendientesAux(this.raiz, lis, elem);
        return lis;
    }

    private void obtenerDescendientesAux(NodoArbol n, Lista lis, Object elem) {
        //Metodo recursivo para encontrar el nodo buscado con el elemento "elem"
        if (n != null) {
            if (elem.equals(n.getElem())) {
                //Cuando lo encuentra, se enlistan sus hijos y se elimina el nodo mismo de la lista
                insertarHijos(n, lis);
                lis.eliminar(1);
            } else {
                //Se fija en su hijo izquierdo
                obtenerDescendientesAux(n.getIzquierdo(), lis, elem);
                if (lis.esVacia()) {
                    //En caso de no encontrarse en su hijo izquierdo, se fija en su hijo derecho
                    obtenerDescendientesAux(n.getDerecho(), lis, elem);
                }
            }
        }
    }

    private void insertarHijos(NodoArbol n, Lista lis) {
        //Metodo recursivo en recorrido preorden que enlista el elemento del nodo n y los hijos del nodo n
        if (n != null) {
            lis.insertar(n.getElem(), lis.longitud() + 1);
            insertarHijos(n.getIzquierdo(), lis);
            insertarHijos(n.getDerecho(), lis);
        }
    }

    /*Operaciones de ejercicios adicionales*/
    public boolean verificarPatron(Lista lisPatron) {
        /*Recibe por parámetro una lista de Object lisPatron y determine si dicha lista coincide exactamente
        con al menos un camino del árbol que comience en la raíz y termine en una hoja.
        El método retorna un valor boolean.*/
        return verificarPatronAux(this.raiz, lisPatron, 1);
    }

    private boolean verificarPatronAux(NodoArbol n, Lista lis, int i) {
        /*Metodo recursivo que verifica si en lista "lis" coincide con un camino del arbol
         desde raiz hasta terminar en una hoja*/
        boolean valido = false;
        if (n != null) {
            if (n.getElem().equals(lis.recuperar(i))) {
                if (n.getIzquierdo() == null && n.getDerecho() == null) {
                    valido = true;
                } else {
                    i++;
                    if (n.getIzquierdo() != null) {
                        valido = verificarPatronAux(n.getIzquierdo(), lis, i);
                    }
                    if (!valido && n.getDerecho() != null) {
                        valido = verificarPatronAux(n.getDerecho(), lis, i);
                    }
                }
            }
        }
        return valido;
    }

    public Lista listaQueJustificaLaAltura() {
        /*Devuelve una lista de elementos que es el camino que comienza en la raíz y termina en la hoja más lejana.*/
        Lista lisAltura = new Lista();
        return listarAltura(this.raiz, (new Lista()), lisAltura);
    }

    private Lista listarAltura(NodoArbol n, Lista lis, Lista lisMasLarga) {
        //Modulo recursivo que retorna una lista con el camino mas largo desde la raiz hasta la hoja del arbol
        if (n != null) {
            lis.insertar(n.getElem(), 1);
            if (n.getIzquierdo() == null && n.getDerecho() == null) {
                if (lisMasLarga.longitud() < lis.longitud()) {
                    lisMasLarga = lis;
                    lisMasLarga.invertir();
                }
            } else {
                if (n.getIzquierdo() != null) {
                    lisMasLarga = listarAltura(n.getIzquierdo(), lis, lisMasLarga);
                }
                if (n.getDerecho() != null) {
                    lisMasLarga = listarAltura(n.getDerecho(), lis, lisMasLarga);
                }
            }
            lis.eliminar(1);
        }
        return lisMasLarga;
    }
}
