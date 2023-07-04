package conjuntistas;

import lineales.dinamicas.Lista;

public class GrafoNoEtiq {
    private NodoVert inicio;

    public GrafoNoEtiq() {
        this.inicio = null;
    }

    private NodoVert ubicarVertice(Object buscado) {
        NodoVert aux = this.inicio;
        while (aux != null && !aux.getElem().equals(buscado)) {
            aux = aux.getSigVertice();
        }
        return aux;
    }

    public boolean insertarVertice(Object nuevoVertice) {
        boolean exito = false;
        NodoVert aux = this.ubicarVertice(nuevoVertice);
        if (aux == null) {
            this.inicio = new NodoVert(nuevoVertice, this.inicio);
            exito = true;
        }
        return exito;
    }

    public boolean eliminarVertice(Object vertice) {
        return eliminarVerticeAux(this.inicio, null, vertice);
    }

    private boolean eliminarVerticeAux(NodoVert nVertice, NodoVert nVerticeAnterior, Object verticeBuscado) {
        //Metodo recursivo para moverme en la lista de vertice hasta encontrar el verticeBuscado para eliminar
        boolean exito = false;
        if (nVertice != null) {
            if (nVertice.getElem().equals(verticeBuscado)) {
                eliminarArcos(nVertice);
                if (nVerticeAnterior == null) {
                    this.inicio = nVertice.getSigVertice();
                } else {
                    nVerticeAnterior.setSigVertice(nVertice.getSigVertice());
                }
                exito = true;
            } else {
                exito = eliminarVerticeAux(nVertice.getSigVertice(), nVertice, verticeBuscado);
            }
        }
        return exito;
    }

    private void eliminarArcos(NodoVert n) {
        //Modulo para eliminar los arcos del nodo "n"
        NodoAdy nAdyacente = n.getPrimerAdy();
        while (nAdyacente != null) {
            eliminarUnArco(nAdyacente.getVertice(), n.getElem());
            n.setPrimerAdy(nAdyacente.getSigAdyacente());
            nAdyacente = nAdyacente.getSigAdyacente();
        }
    }

    private boolean eliminarUnArco(NodoVert n, Object buscado) {
        //Confirma la eliminacion del nodo adyacente "buscado" de la lista de adyacentes del nodo "n"
        boolean exito = false;
        if (n != null) {
            if (n.getPrimerAdy() != null) {
                if (n.getPrimerAdy().getVertice().getElem().equals(buscado)) {
                    n.setPrimerAdy(n.getPrimerAdy().getSigAdyacente());
                    exito = true;
                } else {
                    exito = eliminarUnArcoAux(n.getPrimerAdy().getSigAdyacente(), n.getPrimerAdy(), buscado);
                }
            }
        }
        return exito;
    }

    private boolean eliminarUnArcoAux(NodoAdy n, NodoAdy nAnterior, Object buscado) {
        //Modulo recursivo para moverse en la lista de adyacentes del nodo "n" hasta encontrar
        // y confirmar la eliminacion el nodo "buscado"
        boolean exito = false;
        if (n != null) {
            if (n.getVertice().getElem().equals(buscado)) {
                nAnterior.setSigAdyacente(n.getSigAdyacente());
                exito = true;
            } else {
                exito = eliminarUnArcoAux(n.getSigAdyacente(), n, buscado);
            }
        }
        return exito;
    }

    public boolean insertarArco(Object origen, Object destino) {
        /* Dados dos elementos de TipoVertice (origen y destino) agrega el arco en la estructura, sólo si
        ambos vértices ya existen en el grafo. Si puede realizar la inserción devuelve verdadero, en caso
        contrario devuelve falso.*/
        return insertarArcoAux(this.inicio, origen, destino);
    }

    private boolean insertarArcoAux(NodoVert n, Object origen, Object destino) {
        //Modulo recursivo que busca hasta encontrar el nodo vertice origen en lista de vertices del grafo
        boolean exito = false;
        if (n != null) {
            NodoVert nDestino = null;
            if (n.getElem().equals(origen)) {
                nDestino = buscarVerticeEnLista(this.inicio, destino);
                if (nDestino != null) {
                    //si no es encontrado el nodo vertice destino, termina y retorna false
                    insertarAdyacente(n, nDestino);
                    insertarAdyacente(nDestino, n);
                    exito = true;
                }
            } else {
                exito = insertarArcoAux(n.getSigVertice(), origen, destino);
            }
        }
        return exito;
    }

    private NodoVert buscarVerticeEnLista(NodoVert n, Object buscado) {
        //Modulo recursivo para buscar y retornar el nodo buscado en la lista de vertices de grafo
        //Si no lo encuentra retorna null
        NodoVert nBuscado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                nBuscado = n;
            } else {
                nBuscado = buscarVerticeEnLista(n.getSigVertice(), buscado);
            }
        }
        return nBuscado;
    }

    private void insertarAdyacente(NodoVert n, NodoVert nEnlace) {
        //Inserta el nodo nVertice en la lista de adyacentes del nodo n
        if (n != null) {
            if (n.getPrimerAdy() == null) {
                n.setPrimerAdy(new NodoAdy(nEnlace, null));
            } else {
                insertarAdyacenteAux(n.getPrimerAdy(), nEnlace);
            }
        }
    }

    private void insertarAdyacenteAux(NodoAdy nAdyacente, NodoVert nEnlace) {
        //Modulo recursivo para insertar el nodo nVertice en la lista de adyacentes del nodo n
        if (nAdyacente != null) {
            if (nAdyacente.getSigAdyacente() == null) {
                nAdyacente.setSigAdyacente(new NodoAdy(nEnlace, null));
            } else {
                insertarAdyacenteAux(nAdyacente.getSigAdyacente(), nEnlace);
            }
        }
    }

    public boolean eliminarArco(Object origen, Object destino) {
        /* Dados dos elementos de TipoVertice (origen y destino) se quita de la estructura el arco que une
        ambos vértices. Si el arco existe y se puede realizar la eliminación con éxito devuelve verdadero, en
        caso contrario devuelve falso.*/
        boolean exito = false;
        if (inicio != null) {
            NodoVert nOrigen = buscarVerticeEnLista(this.inicio, origen);
            if (nOrigen != null) {
                exito = eliminarUnArco(nOrigen, destino);
                if (exito) {
                    exito = eliminarUnArco(buscarVerticeEnLista(this.inicio, destino), origen);
                }
            }
        }
        return exito;
    }

    public boolean existeVertice(Object vertice) {
        // Dado un elemento, devuelve verdadero si está en la estructura y falso en caso contrario.
        return buscarVerticeEnLista(this.inicio, vertice) != null;
    }

    public boolean existeArco(Object origen, Object destino) {
        /* Dados dos elementos de TipoVertice (origen y destino), devuelve verdadero si existe un arco en
        la estructura que los une y falso en caso contrario.*/
        return buscarVerticeEnAdyacente(buscarVerticeEnLista(this.inicio, origen), destino) != null;
    }

    private NodoVert buscarVerticeEnAdyacente(NodoVert n, Object buscado) {
        //Busca y retorna el nodo vertice buscado en la lista de adyacentes de n
        NodoVert nBuscado = null;
        if (n != null) {
            NodoAdy aux = n.getPrimerAdy();
            while (nBuscado == null && aux != null) {
                if (aux.getVertice().getElem().equals(buscado)) {
                    nBuscado = aux.getVertice();
                }
                aux = aux.getSigAdyacente();
            }
        }
        return nBuscado;
    }

    public Lista listarEnProfundidad() {
        Lista visitados = new Lista();
        //define un vertice donde comenzar a recorrer
        NodoVert aux = this.inicio;
        while (aux != null) {
            if (visitados.localizar(aux.getElem()) < 0) {
                //si el vertice no fue visitados aun, avanza en profundidad
                listarEnProfundidadAux(aux, visitados);
            }
            aux = aux.getSigVertice();
        }
        return visitados;
    }

    private void listarEnProfundidadAux(NodoVert n, Lista vis) {
        if (n != null) {
            //marca al vertice n como visitados
            vis.insertar(n.getElem(), vis.longitud() + 1);
            NodoAdy ady = n.getPrimerAdy();
            while (ady != null) {
                // visita en profundidad los adyacentes de n aun no visitados
                if (vis.localizar(ady.getVertice().getElem()) < 0) {
                    listarEnProfundidadAux(ady.getVertice(), vis);
                }
                ady = ady.getSigAdyacente();
            }
        }
    }

    public boolean existeCamino(Object origen, Object destino) {
        boolean exito = false;
        //verifica si ambos vertices existen
        NodoVert auxO = null;
        NodoVert auxD = null;
        NodoVert aux = this.inicio;
        while ((auxO == null || auxD == null) && aux != null) {
            if (aux.getElem().equals(origen)) {
                auxO = aux;
            }
            if (aux.getElem().equals(destino)) {
                auxD = aux;
            }
            aux = aux.getSigVertice();
        }
        if (auxO != null && auxD != null) {
            //si ambos vertices existen busca si existe camino entre ambos
            Lista visitados = new Lista();
            exito = existeCaminoAux(auxO, destino, visitados);
        }
        return exito;
    }

    private boolean existeCaminoAux(NodoVert n, Object dest, Lista vis) {
        boolean exito = false;
        if (n != null) {
            exito = true;
        } else {
            //si no es el destino verifica si hay camino entre n y destino
            vis.insertar(n.getElem(), vis.longitud() + 1);
            NodoAdy ady = n.getPrimerAdy();
            while (!exito && ady != null) {
                if (vis.localizar(ady.getVertice().getElem()) < 0) {
                    exito = existeCaminoAux(ady.getVertice(), dest, vis);
                }
                ady = ady.getSigAdyacente();
            }
        }
        return exito;
    }

    public boolean esVacio(){
        // Devuelve falso si hay al menos un vértice cargado en el grafo y verdadero en caso contrario.
        return this.inicio != null;
    }

    public Lista caminoMasCorto(Object origen, Object destino) {
        Lista salida = new Lista();
        boolean exito = false;
        //verifica si ambos vertices existen
        NodoVert auxO = null;
        NodoVert auxD = null;
        NodoVert aux = this.inicio;
        while ((auxO == null || auxD == null) && aux != null) {
            if (aux.getElem().equals(origen)) {
                auxO = aux;
            }
            if (aux.getElem().equals(destino)) {
                auxD = aux;
            }
            aux = aux.getSigVertice();
        }
        if (auxO != null && auxD != null) {
            //si ambos vertices existen busca el camino mas corto entre ambos
            caminoMasCortoAux(auxO, destino, salida);
        }
        return salida;
    }

    private void caminoMasCortoAux(NodoVert n, Object dest, Lista salida){
    //Busca el camino mas corto en la lista de adyacentes del nodo n hacia el vertice dest
        Lista visitados = new Lista();
        NodoAdy nAdyacente = n.getPrimerAdy();
        boolean exito = false;
            while (nAdyacente != null){
                exito = existeCaminoAux(n, dest, visitados);
                if(exito){
                    if(salida.longitud() == 0){
                        salida = visitados;
                    }else {
                        if(visitados.longitud() < salida.longitud()){
                            salida = visitados;
                        }
                    }
                }
                nAdyacente = nAdyacente.getSigAdyacente();
            }
    }

    public Lista caminoMasLargo(Object origen, Object destino) {
        Lista salida = new Lista();
        boolean exito = false;
        //verifica si ambos vertices existen
        NodoVert auxO = null;
        NodoVert auxD = null;
        NodoVert aux = this.inicio;
        while ((auxO == null || auxD == null) && aux != null) {
            if (aux.getElem().equals(origen)) {
                auxO = aux;
            }
            if (aux.getElem().equals(destino)) {
                auxD = aux;
            }
            aux = aux.getSigVertice();
        }
        if (auxO != null && auxD != null) {
            //si ambos vertices existen busca el camino mas corto entre ambos
            caminoMasLargoAux(auxO, destino, salida);
        }
        return salida;
    }

    private void caminoMasLargoAux(NodoVert n, Object dest, Lista salida){
    //Busca el camino mas largo en la lista de adyacentes del nodo n hacia el vertice dest
        Lista visitados = new Lista();
        NodoAdy nAdyacente = n.getPrimerAdy();
        boolean exito = false;
            while (nAdyacente != null){
                exito = existeCaminoAux(n, dest, visitados);
                if(exito){
                    if(salida.longitud() < visitados.longitud()){
                        salida = visitados;
                    }
                }
                nAdyacente = nAdyacente.getSigAdyacente();
            }
    }

}
