package tp3.ejercicio11;

import tp3.ejercicio5.GeneralTree;

public class TestParcialArboles {
    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<>(2);
        GeneralTree<Integer> a2 = new GeneralTree<>(1);
        GeneralTree<Integer> a3 = new GeneralTree<>(25);
        GeneralTree<Integer> a4 = new GeneralTree<>(5);
        GeneralTree<Integer> a5 = new GeneralTree<>(4);
        GeneralTree<Integer> a6 = new GeneralTree<>(13);
        GeneralTree<Integer> a7 = new GeneralTree<>(18);
        GeneralTree<Integer> a8 = new GeneralTree<>(7);
        GeneralTree<Integer> a9 = new GeneralTree<>(11);
        GeneralTree<Integer> a10 = new GeneralTree<>(3);
        GeneralTree<Integer> a11 = new GeneralTree<>(83);
        GeneralTree<Integer> a12 = new GeneralTree<>(33);
        GeneralTree<Integer> a13 = new GeneralTree<>(12);
        GeneralTree<Integer> a14 = new GeneralTree<>(17);
        GeneralTree<Integer> a15 = new GeneralTree<>(9);

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

        System.out.println("Primer arbol: " + ParcialArboles.resolver(a1));

        a5.removeChild(a9);

        System.out.println("Segundo arbol: " + ParcialArboles.resolver(a1));
    }
}
