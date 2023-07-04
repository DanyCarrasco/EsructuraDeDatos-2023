package tests.conjuntistas;

import conjuntistas.ArbolAVL;

public class testArbolAVL {
    public static void main(String[] args) {
        testInsertarYToString();
    }

    public static void testInsertarYToString(){
        System.out.println("Rotaciones simples:");
        ArbolAVL a1 = new ArbolAVL();
        System.out.println("Se inserta el elemento 8 en arbol a1");
        a1.insertar(8);
        System.out.println("Arbol a1: \n" + a1.toString());
        System.out.println("Se inserta el elemento 6 en arbol a1");
        a1.insertar(6);
        System.out.println("Arbol a1: \n" + a1.toString());
        System.out.println("Se inserta el elemento 4 en arbol a1");
        a1.insertar(4);
        System.out.println("Se hace rotacion simple a la derecha");
        System.out.println("Arbol a1: \n" + a1.toString());

        ArbolAVL a2 = new ArbolAVL();
        System.out.println("Se inserta el elemento 9 en arbol a2");
        a2.insertar(9);
        System.out.println("Arbol a2: \n" + a2.toString());
        System.out.println("Se inserta el elemento 10 en arbol a2");
        a2.insertar(10);
        System.out.println("Arbol a2: \n" + a2.toString());
        System.out.println("Se inserta el elemento 12 en arbol a2");
        a2.insertar(12);
        System.out.println("Se hace rotacion simple a la izquierda");
        System.out.println("Arbol a2: \n" + a2.toString());

        ArbolAVL a3 = new ArbolAVL();
        System.out.println("Se inserta el elemento 8 en arbol a3");
        a3.insertar(8);
        System.out.println("Arbol a3: \n" + a3.toString());
        System.out.println("Se inserta el elemento 6 en arbol a3");
        a3.insertar(6);
        System.out.println("Arbol a3: \n" + a3.toString());
        System.out.println("Se inserta el elemento 10 en arbol a3");
        a3.insertar(10);
        System.out.println("Arbol a3: \n" + a3.toString());
        System.out.println("Se inserta el elemento 4 en arbol a3");
        a3.insertar(4);
        System.out.println("Arbol a3: \n" + a3.toString());
        System.out.println("Se inserta el elemento 1 en arbol a3");
        a3.insertar(1);
        System.out.println("Se hace rotacion simple a la derecha");
        System.out.println("Arbol a3: \n" + a3.toString());

        ArbolAVL a4 = new ArbolAVL();
        System.out.println("Se inserta el elemento 9 en arbol a4");
        a4.insertar(9);
        System.out.println("Arbol a4: \n" + a4.toString());
        System.out.println("Se inserta el elemento 8 en arbol a4");
        a4.insertar(8);
        System.out.println("Arbol a4: \n" + a4.toString());
        System.out.println("Se inserta el elemento 10 en arbol a4");
        a4.insertar(10);
        System.out.println("Arbol a4: \n" + a4.toString());
        System.out.println("Se inserta el elemento 12 en arbol a4");
        a4.insertar(12);
        System.out.println("Arbol a4: \n" + a4.toString());
        System.out.println("Se inserta el elemento 13 en arbol a4");
        a4.insertar(13);
        System.out.println("Se hace rotacion simple a la izquierda");
        System.out.println("Arbol a4: \n" + a4.toString());

        System.out.println("-------------------------------------------------");

        System.out.println("Rotaciones dobles:");
        ArbolAVL a5 = new ArbolAVL();
        System.out.println("Se inserta el elemento 8 en arbol a5");
        a5.insertar(8);
        System.out.println("Arbol a5: \n" + a5.toString());
        System.out.println("Se inserta el elemento 6 en arbol a5");
        a5.insertar(6);
        System.out.println("Arbol a5: \n" + a5.toString());
        System.out.println("Se inserta el elemento 5 en arbol a5");
        a5.insertar(5);
        System.out.println("Se hace rotacion doble izquierda-derecha");
        System.out.println("Arbol a5: \n" + a5.toString());

        ArbolAVL a6 = new ArbolAVL();
        System.out.println("Se inserta el elemento 9 en arbol a6");
        a6.insertar(9);
        System.out.println("Arbol a6: \n" + a6.toString());
        System.out.println("Se inserta el elemento 10 en arbol a6");
        a6.insertar(10);
        System.out.println("Arbol a6: \n" + a6.toString());
        System.out.println("Se inserta el elemento 11 en arbol a6");
        a6.insertar(11);
        System.out.println("Se hace rotacion doble derecha-izquierda");
        System.out.println("Arbol a6: \n" + a6.toString());

        ArbolAVL a7 = new ArbolAVL();
        System.out.println("Se inserta el elemento 8 en arbol a7");
        a7.insertar(8);
        System.out.println("Arbol a7: \n" + a7.toString());
        System.out.println("Se inserta el elemento 6 en arbol a7");
        a7.insertar(6);
        System.out.println("Arbol a7: \n" + a7.toString());
        System.out.println("Se inserta el elemento 10 en arbol a7");
        a7.insertar(10);
        System.out.println("Arbol a7: \n" + a7.toString());
        System.out.println("Se inserta el elemento 4 en arbol a7");
        a7.insertar(4);
        System.out.println("Arbol a7: \n" + a7.toString());
        System.out.println("Se inserta el elemento 5 en arbol a7");
        a7.insertar(5);
        System.out.println("Se hace rotacion doble izquierda-derecha");
        System.out.println("Arbol a7: \n" + a7.toString());

        ArbolAVL a8 = new ArbolAVL();
        System.out.println("Se inserta el elemento 9 en arbol a8");
        a8.insertar(9);
        System.out.println("Arbol a8: \n" + a8.toString());
        System.out.println("Se inserta el elemento 8 en arbol a8");
        a8.insertar(8);
        System.out.println("Arbol a8: \n" + a8.toString());
        System.out.println("Se inserta el elemento 10 en arbol a8");
        a8.insertar(10);
        System.out.println("Arbol a8: \n" + a8.toString());
        System.out.println("Se inserta el elemento 12 en arbol a8");
        a8.insertar(12);
        System.out.println("Arbol a8: \n" + a8.toString());
        System.out.println("Se inserta el elemento 11 en arbol a8");
        a8.insertar(11);
        System.out.println("Se hace rotacion doble derecha-izquierda");
        System.out.println("Arbol a8: \n" + a8.toString());
    }
}
