package jerarquicas;

/**
 * *********** Autores ***********
 * - Daniel Carrasco, FAI-2840
 * - Agustin Caceres FAI-2993
 * - Jonathan maximiliano cabrera, 108665
 */


public class NodoGen {
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    public NodoGen(Object elem, NodoGen hijoIzq, NodoGen hermanoDer) {
        this.elem = elem;
        this.hijoIzquierdo = hijoIzq;
        this.hermanoDerecho = hermanoDer;
    }

    public Object getElem() {
        return elem;
    }

    public NodoGen getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHermanoDerecho(NodoGen hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }
}
