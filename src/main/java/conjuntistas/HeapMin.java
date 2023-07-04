package conjuntistas;


public class HeapMin {
    private Comparable[] heap;
    private int ultimo;
    private int TAMANIO = 20;

    public HeapMin() {
        // crea un árbol sin elementos.
        this.heap = new Comparable[TAMANIO];
        this.ultimo = 0; //la posicion 0 nunca es utilizada
    }

    public boolean insertar(Object elem) {
        /*Recibe un elemento y lo inserta en el árbol según el algoritmo que se explicará en la siguiente
        sección. Si la operación termina con éxito devuelve verdadero y falso en caso contrario.*/
        //Nota: Los árboles heap aceptan elementos repetidos.
        boolean exito = false;
        if (this.ultimo + 1 < this.TAMANIO) {
            this.ultimo++;
            this.heap[ultimo] = (Comparable) elem;
            hacerSubir(ultimo);
            exito = true;
        }
        return exito;
    }

    private void hacerSubir(int posH) {
        //Sube el elemento hasta llegar a una posicion donde sea mayor que su padre o llegue a la raiz
        int posPadre;
        Comparable temp = this.heap[posH];
        boolean salir = false;
        while (!salir) {
            posPadre = posH / 2;
            if (posPadre >= 1) {
                if (this.heap[posPadre].compareTo(temp) > 0) {
                    this.heap[posH] = this.heap[posPadre];
                    this.heap[posPadre] = temp;
                    posH = posPadre;
                } else {
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }

    public boolean eliminarCima() {
        /*Elimina el elemento de la raíz (o cima del montículo) según el algoritmo que se explicará en la
        siguiente sección. Si la operación termina con éxito devuelve verdadero y falso si el árbol estaba
        vacío.*/
        boolean exito;
        if (this.ultimo == 0) {
            // estructura vacia
            exito = false;
        } else {
            // saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            // reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posPadre) {
        //Baja el elemento hasta que quede en una hoja o
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                //temp tiene al menos un hijo (izq) y lo considera menor

                if (posH < this.ultimo) {
                    //hijoMenor tiene hermano derecho

                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        //el hijo derecho es el menor de los dos
                        posH++;
                    }
                }

                //compara al hijo menor con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    //el hijo es menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                } else {
                    //el padre es menor que sus hijos, esta bien ubicado
                    salir = true;
                }
            } else {
                // el temp es hoja, esta bien ubicado
                salir = true;
            }
        }
    }

    public Object recuperarCima() {
        /*Devuelve el elemento que está en la raíz (cima del montículo).
        Precondición: el árbol no está vacío (si está vacío no se puede asegurar el funcionamiento de la operación).*/
        Object elem = null;
        if (this.ultimo != 0) {
            elem = this.heap[1];
        }
        return elem;
    }

    public boolean esVacio() {
        //Devuelve falso si hay al menos un elemento cargado en la tabla y verdadero en caso contrario.
        return this.ultimo == 0;
    }

    public String toString() {
        /* Genera y devuelve una cadena de caracteres que indica
        cuál es la raíz del árbol y quienes son los hijos de cada nodo.*/
        String cadena = "Arbol vacio";
        if (this.ultimo != 0) {
            cadena = "[";
            for (int i = 1; i <= this.ultimo; i++) {
                if (this.heap[i] == null) {
                    cadena = cadena + " - ";
                } else {
                    cadena = cadena + this.heap[i].toString();
                }
                if (i != this.ultimo) {
                    cadena = cadena + ", ";
                } else {
                    cadena = cadena + "]";
                }
            }
        }
        return cadena;
    }
}
