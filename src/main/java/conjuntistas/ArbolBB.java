package conjuntistas;

import lineales.dinamicas.Lista;
import java.util.Arrays;

public class ArbolBB {
    private NodoABB raiz;

    public ArbolBB() {
        // Crea un árbol sin elementos.
        this.raiz = null;
    }

    public boolean pertenece(Comparable elemento) {
        // Devuelve verdadero si el elemento recibido por parámetro está en el árbol y falso en caso contrario.
        boolean exito = false;
        if (this.raiz != null) {
            exito = perteneceAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean perteneceAux(NodoABB n, Comparable elem) {
        boolean exito = false;
        if (elem.compareTo(n.getElem()) == 0) {
            exito = true;
        } else {
            if (elem.compareTo(n.getElem()) < 0) {
                if (n.getIzquierdo() != null) {
                    exito = perteneceAux(n.getIzquierdo(), elem);
                }
            } else {
                if (n.getDerecho() != null) {
                    exito = perteneceAux(n.getDerecho(), elem);
                }
            }
        }
        return exito;
    }

    public boolean insertar(Comparable elemento) {
        /*Recibe un elemento y lo agrega en el árbol de manera ordenada. Si el elemento ya se encuentra
        en el árbol no se realiza la inserción. Devuelve verdadero si el elemento se agrega a la estructura y
        falso en caso contrario.*/
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento, null, null);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elemento) {
        // precondicion: n no es nulo
        boolean exito = true;

        if ((elemento.compareTo(n.getElem()) == 0)) {
            //Reporta error: Elemento repetido
            exito = false;
        } else if ((elemento.compareTo(n.getElem()) < 0)) {
            // elemento es menor que n.getElem()
            // si tiene HI baja a la izquierda, sino agrega elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elemento);
            } else {
                n.setIzquierdo(new NodoABB(elemento, null, null));
            }
        } else { // elemento es mayor que n.getElem()
            // si tiene HD baja a la derecha, sino agrega elemento
            if (n.getDerecho() != null) {
                exito = insertarAux(n.getDerecho(), elemento);
            } else {
                n.setDerecho(new NodoABB(elemento, null, null));
            }
        }
        return exito;
    }

    public boolean eliminar(Comparable elem) {
        /*Recibe el elemento que se desea eliminar y se procede a removerlo del árbol. Si no se encuentra
        el elemento no se puede realizar la eliminación. Devuelve verdadero si el elemento se elimina de la
        estructura y falso en caso contrario.*/
        boolean exito = false;
        if (this.raiz != null) {
            exito = eliminarAux(this.raiz, null, elem);
        }
        return exito;
    }

    private boolean eliminarAux(NodoABB n, NodoABB padre, Comparable elem) {
        boolean exito = false;
        if (elem.compareTo(n.getElem()) == 0) {
            if (n.getIzquierdo() == null && n.getDerecho() == null) {
                caso1(elem, padre);
            } else {
                if (n.getIzquierdo() == null || n.getDerecho() == null) {
                    caso2(elem, n, padre);
                } else {
                    caso3(n);
                }
            }
            exito = true;
        } else {
            if (elem.compareTo(n.getElem()) < 0) {
                if (n.getIzquierdo() != null) {
                    exito = eliminarAux(n.getIzquierdo(), n, elem);
                }
            } else {
                if (n.getDerecho() != null) {
                    exito = eliminarAux(n.getDerecho(), n, elem);
                }
            }
        }
        return exito;
    }

    //Caso 1 de eliminar.
    private void caso1(Comparable elemento, NodoABB padre) {
        if (padre == null) {
            //Caso especial al intentar eliminar la raiz
            this.raiz = null;
        } else {
            int temp = elemento.compareTo(padre.getElem());
            if (temp < 0) {
                padre.setIzquierdo(null);
            } else {
                padre.setDerecho(null);
            }
        }
    }

    //Caso 2 de eliminar.
    private void caso2(Comparable elem, NodoABB hijo, NodoABB padre) {
        //Busco al candidato para reemplazar al nodo
        //almenos 1 sera null.
        NodoABB der = hijo.getDerecho();
        NodoABB izq = hijo.getIzquierdo();
        if (padre == null) {
            //Caso especial.
            if (der == null) {
                this.raiz = izq;
            } else {
                this.raiz = der;
            }
        } else {
            //Verifico la rama derecha o izquierda.
            int temp = elem.compareTo(padre.getElem());
            if (temp < 0) {
                if (izq == null) {
                    padre.setIzquierdo(der);
                } else {
                    padre.setIzquierdo(izq);
                }
            } else {
                if (izq == null) {
                    padre.setDerecho(der);
                } else {
                    padre.setDerecho(izq);
                }
            }
        }
    }

    /**
     * Usar el candidato A (El mayor del subarbol izquierdo de N, siendo N el
     * nodo a eliminar).
     *
     * @param actual envia el nodo a eliminar.
     */
    private void caso3(NodoABB actual) {
        NodoABB nodoA = actual.getIzquierdo(), nodoPadreA = actual;
        while (nodoA.getDerecho() != null) {
            nodoPadreA = nodoA;
            nodoA = nodoA.getDerecho();
        }
        actual.setElem(nodoA.getElem());
        NodoABB hijoDer = nodoA.getDerecho();
        if (actual.getIzquierdo() == nodoA) {
            actual.setIzquierdo(hijoDer);
        } else {
            nodoPadreA.setIzquierdo(hijoDer);
        }
    }

    public boolean esVacio() {
        // Devuelve falso si hay al menos un elemento en el árbol y verdadero en caso contrario.
        return this.raiz == null;
    }

    public Lista listar() {
        /*Recorre el árbol completo y devuelve una lista ordenada con los elementos que se encuentran
        almacenados en él.*/
        Lista lis = new Lista();
        if (this.raiz != null) {
            listarAux(this.raiz, lis);
        }
        return lis;
    }

    private void listarAux(NodoABB n, Lista lis) {
        if (n.getIzquierdo() != null) {
            listarAux(n.getIzquierdo(), lis);
        }

        lis.insertar(n.getElem(), lis.longitud() + 1);

        if (n.getDerecho() != null) {
            listarAux(n.getDerecho(), lis);
        }
    }

    public Lista listarRango(Comparable elemMin, Comparable elemMax) {
        /*Recorre parte del árbol (sólo lo necesario) y devuelve una lista ordenada con los elementos que
        se encuentran en el intervalo [elemMinimo, elemMaximo].*/
        Lista lis = new Lista();
        if (this.raiz != null) {
            listarRangoAux(this.raiz, lis, elemMin, elemMax);
        }
        return lis;
    }

    private void listarRangoAux(NodoABB n, Lista lis, Comparable elemMin, Comparable elemMax) {
        if (n.getIzquierdo() != null && (elemMin.compareTo(n.getElem()) < 0)) {
            listarRangoAux(n.getIzquierdo(), lis, elemMin, elemMax);
        }
        if ((elemMin.compareTo(n.getElem()) <= 0) && (elemMax.compareTo(n.getElem()) >= 0)) {
            lis.insertar(n.getElem(), lis.longitud() + 1);
        }

        if (n.getDerecho() != null && (elemMax.compareTo(n.getElem()) > 0)) {
            listarRangoAux(n.getDerecho(), lis, elemMin, elemMax);
        }
    }

    public Object minimoElem() {
        // recorre la rama correspondiente y devuelve el elemento más pequeño almacenado en el árbol.
        Object elem = null;
        if (this.raiz != null) {
            elem = minimoElemAux(this.raiz);
        }
        return elem;
    }

    private Object minimoElemAux(NodoABB n) {
        //Modulo recursivo
        Object elem = n.getElem();
        if (n.getIzquierdo() != null) {
            elem = minimoElemAux(n.getIzquierdo());
        }
        return elem;
    }

    public Object maximoElem() {
        // recorre la rama correspondiente y devuelve el elemento más grande almacenado en el árbol.
        Object elem = null;
        if (this.raiz != null) {
            elem = maximoElemAux(this.raiz);
        }
        return elem;
    }

    private Object maximoElemAux(NodoABB n) {
        //Modulo recursivo
        Object elem = n.getElem();
        if (n.getDerecho() != null) {
            elem = maximoElemAux(n.getDerecho());
        }
        return elem;
    }

    public ArbolBB clone() {
        ArbolBB clon = new ArbolBB();
        clon.raiz = cloneAux(this.raiz);
        return clon;
    }

    private NodoABB cloneAux(NodoABB n) {
        NodoABB nuevo = null;
        if (n != null) {
            nuevo = new NodoABB(n.getElem(), cloneAux(n.getIzquierdo()), cloneAux(n.getDerecho()));
        }
        return nuevo;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        String cadena = "Arbol vacio";
        if (this.raiz != null) {
            cadena = toStringAux(this.raiz);
        }
        return cadena;
    }

    private String toStringAux(NodoABB nodo) {
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
}