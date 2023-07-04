package conjuntistas;

public class NodoABB {
    private Object elem;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB(Object elem, NodoABB izq, NodoABB der){
        this.elem = elem;
        this.izquierdo = izq;
        this.derecho = der;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoABB getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoABB izq) {
        this.izquierdo = izq;
    }

    public NodoABB getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoABB der) {
        this.derecho = der;
    }
}
