package tests.jerarquicas;

import jerarquicas.ArbolBin;
import jerarquicas.ArbolGen;

public class TestArbolGen {
    public static void main(String[] args) {
        //testInsertarYtoString();
        //testEsVacioYVaciar();
        //testAltura();
        //testNivel();
        //testPadre();
        //testListar();
        //testClone();
        testObtenerAncestros();
    }

    public static void testInsertarYtoString() {
        ArbolGen a1 = new ArbolGen();
        System.out.println("Ingreso A como raiz: " + a1.insertar('A', 1));
        System.out.println("Ingreso B como hijo de A: " + a1.insertar('B', 'A'));
        System.out.println("Ingreso E como hijo de B: " + a1.insertar('E', 'B'));
        System.out.println("Ingreso D como hijo de B: " + a1.insertar('D', 'B'));
        System.out.println("Ingreso E como hijo de B: " + a1.insertar('E', 'B'));
        System.out.println("Ingreso F como hijo de A: " + a1.insertar('F', 'A'));
        System.out.println("Ingreso G como hijo de F: " + a1.insertar('G', 'F'));
        System.out.println("Ingreso I como hijo de G: " + a1.insertar('I', 'G'));
        System.out.println("Ingreso H como hijo de F: " + a1.insertar('H', 'F'));
        System.out.println("Ingreso M como hijo de J (de retornar false): " + a1.insertar('M', 'J'));
        System.out.println("Arbol generico: \n" + a1.toString());
    }

    public static void testEsVacioYVaciar() {
        ArbolGen a2 = new ArbolGen();
        System.out.println("Arbol esta vacio debe retornar true: " + a2.esVacio());
        a2.insertar('A', 1);
        System.out.println(a2.toString());
        System.out.println("Arbol no esta vacio debe retornar false: " + a2.esVacio());
        System.out.println("Se vacia el arbol");
        a2.vaciar();
        System.out.println("Ahora debe retornar true: " + a2.esVacio());
    }

    public static void testAltura() {
        ArbolGen a3 = new ArbolGen();
        System.out.println("Arbol esta vacio, retorna -1: " + a3.altura());
        a3.insertar('A', 1);
        System.out.println("Arbol tiene solo raiz, retorna 0: " + a3.altura());
        a3.insertar('B', 'A');
        a3.insertar('E', 'B');
        a3.insertar('D', 'B');
        a3.insertar('E', 'B');
        a3.insertar('F', 'A');
        a3.insertar('G', 'F');
        a3.insertar('I', 'G');
        System.out.println(a3.toString());
        System.out.println("Arbol debe retornar 3: " + a3.altura());
    }

    public static void testNivel() {
        ArbolGen a4 = new ArbolGen();
        System.out.println("BUsca en arbol vacio, retorna -1: " + a4.nivel('A'));
        a4.insertar('A', 1);
        System.out.println("Tiene la unica raiz buscada, retorna 0: " + a4.nivel('A'));
        a4.insertar('B', 'A');
        a4.insertar('E', 'B');
        a4.insertar('D', 'B');
        a4.insertar('E', 'B');
        a4.insertar('F', 'A');
        a4.insertar('G', 'F');
        a4.insertar('I', 'G');
        System.out.println(a4.toString());
        System.out.println("Busca el nodo E, retorna 2: " + a4.nivel('E'));
        System.out.println("Busca el nodo F, retorna 1: " + a4.nivel('F'));
        System.out.println("Busca el nodo I, retorna 3: " + a4.nivel('I'));
    }

    public static void testPadre() {
        ArbolGen a5 = new ArbolGen();
        System.out.println("Busca nodo padre en arbol vacio, retorna null: " + (a5.padre('A') == null));
        a5.insertar('A', 1);
        System.out.println("Busca nodo padre de unica raiz, retorna null: " + (a5.padre('A') == null));
        a5.insertar('B', 'A');
        a5.insertar('E', 'B');
        a5.insertar('D', 'B');
        a5.insertar('E', 'B');
        a5.insertar('F', 'A');
        a5.insertar('G', 'F');
        System.out.println(a5.toString());
        System.out.println("Busca nodo padre E, retorna B: " + a5.padre('E'));
        System.out.println("Busca nodo padre F, retorna A: " + a5.padre('F'));
    }

    public static void testListar() {
        ArbolGen a7 = new ArbolGen();
        a7.insertar('A', 1);
        a7.insertar('B', 'A');
        a7.insertar('E', 'B');
        a7.insertar('D', 'B');
        a7.insertar('E', 'B');
        a7.insertar('F', 'A');
        a7.insertar('G', 'F');
        System.out.println(a7.toString());
        System.out.println("Se prueba en preorden, debe retornar [A,B,E,D,E,F,G]: " + a7.listarPreorden());
        System.out.println("Se prueba en inorden, debe retornar [E,B,D,E,A,G,F]: " + a7.listarInorden());
        System.out.println("Se prueba en posorden, debe retornar [E,D,E,B,G,F,A]: " + a7.listarPosorden());
        System.out.println("Se prueba en niveles, debe retornar [A,B,F,E,D,E,G]: " + a7.listarPorNiveles().toString());
    }

    public static void testClone() {
        ArbolGen a8 = new ArbolGen();
        a8.insertar('A', 1);
        a8.insertar('B', 'A');
        a8.insertar('E', 'B');
        a8.insertar('D', 'B');
        a8.insertar('E', 'B');
        a8.insertar('F', 'A');
        a8.insertar('G', 'F');
        System.out.println("Arbol original: \n" + a8.toString());
        System.out.println("Se crea clon de arbol original");
        ArbolGen a9 = a8.clone();
        System.out.println("Arbol clon: \n"+ a9.toString());
        System.out.println("se vacia arbol original");
        a8.vaciar();
        System.out.println("Arbol original: \n"+ a8.toString());
        System.out.println("Arbol clon: \n"+ a9.toString());
    }

    public static void testObtenerAncestros(){
        ArbolGen a10 = new ArbolGen();
        a10.insertar('A', 1);
        a10.insertar('B', 'A');
        a10.insertar('E', 'B');
        a10.insertar('D', 'B');
        a10.insertar('E', 'B');
        a10.insertar('F', 'A');
        a10.insertar('G', 'F');
        System.out.println(a10.toString());
        System.out.println("Se enlistan los ancestros de E, debe retornar [A,B]: "+ a10.ancestros('E'));
        System.out.println("Se enlistan los ancestros de F, debe retornar [A]: "+ a10.ancestros('F'));
        System.out.println("Se enlistan los ancestros de A, debe retornar []: "+ a10.ancestros('A'));
    }

    public static void testVerificarPatron(){
        ArbolGen a11 = new ArbolGen();
        a11.insertar('A', 1);
        a11.insertar('B', 'A');
        a11.insertar('E', 'B');
        a11.insertar('D', 'B');
        a11.insertar('E', 'B');
        a11.insertar('F', 'A');
        a11.insertar('G', 'F');
        System.out.println(a11.toString());
    }


}
