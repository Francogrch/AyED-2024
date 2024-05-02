package tp3.ejercicio9;

import tp3.ejercicio5.GeneralTree;

public class TestEjercicio9 {
    public static void imprimirArbol(GeneralTree<Integer> a) {
        System.out.print(a.getData() + " - ");
        for (GeneralTree<Integer> child : a.getChildren()) {
            imprimirArbol(child);
        }
    }

    public static void main(String[] args) {

        GeneralTree<Integer> a1 = new GeneralTree<>(12);
        GeneralTree<Integer> a2 = new GeneralTree<>(12);
        GeneralTree<Integer> a3 = new GeneralTree<>(25);
        GeneralTree<Integer> a4 = new GeneralTree<>(35);
        GeneralTree<Integer> a5 = new GeneralTree<>(12);
        GeneralTree<Integer> a6 = new GeneralTree<>(25);
        GeneralTree<Integer> a7 = new GeneralTree<>(35);
        GeneralTree<Integer> a8 = new GeneralTree<>(14);
        GeneralTree<Integer> a9 = new GeneralTree<>(12);
        GeneralTree<Integer> a10 = new GeneralTree<>(33);
        GeneralTree<Integer> a11 = new GeneralTree<>(35);
        GeneralTree<Integer> a12 = new GeneralTree<>(35);
        GeneralTree<Integer> a13 = new GeneralTree<>(83);
        GeneralTree<Integer> a14 = new GeneralTree<>(90);
        GeneralTree<Integer> a15 = new GeneralTree<>(33);
        GeneralTree<Integer> a16 = new GeneralTree<>(18);
        GeneralTree<Integer> a17 = new GeneralTree<>(18);

        System.out.println("Arbol 1");
        a1.addChild(a2);
        a1.addChild(a3);

        a2.addChild(a4);
        a2.addChild(a5);

        a3.addChild(a6);

        a4.addChild(a7);

        a5.addChild(a8);
        a5.addChild(a9);
        a5.addChild(a10);

        a7.addChild(a11);

        a10.addChild(a12);
        a10.addChild(a13);
        a10.addChild(a14);
        a10.addChild(a15);


        imprimirArbol(a1);
        System.out.println();
        System.out.println(ParcialArboles.esDeSeleccion(a1));


        System.out.println("Arbol 2");
        a2.removeChild(a5);
        a2.addChild(a16);
        a16.addChild(a8);
        a16.addChild(a17);
        a16.addChild(a10);


        imprimirArbol(a1);
        System.out.println();
        System.out.println(ParcialArboles.esDeSeleccion(a1));
    }


}
