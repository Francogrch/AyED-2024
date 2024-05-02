package tp3.ejercicio10;

import tp3.ejercicio5.GeneralTree;

public class TestParcialArboles {

    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<>(1);
        GeneralTree<Integer> a2 = new GeneralTree<>(0);
        GeneralTree<Integer> a3 = new GeneralTree<>(1);
        GeneralTree<Integer> a4 = new GeneralTree<>(1);
        GeneralTree<Integer> a5 = new GeneralTree<>(1);
        GeneralTree<Integer> a6 = new GeneralTree<>(1);
        GeneralTree<Integer> a7 = new GeneralTree<>(1);
        GeneralTree<Integer> a8 = new GeneralTree<>(0);
        GeneralTree<Integer> a9 = new GeneralTree<>(0);
        GeneralTree<Integer> a10 = new GeneralTree<>(1);
        GeneralTree<Integer> a11 = new GeneralTree<>(1);
        GeneralTree<Integer> a12 = new GeneralTree<>(1);
        GeneralTree<Integer> a13 = new GeneralTree<>(0);
        GeneralTree<Integer> a14 = new GeneralTree<>(0);
        GeneralTree<Integer> a15 = new GeneralTree<>(1);
        GeneralTree<Integer> a16 = new GeneralTree<>(0);
        GeneralTree<Integer> a17 = new GeneralTree<>(0);

        a1.addChild(a2);
        a1.addChild(a3);
        a1.addChild(a4);

        a2.addChild(a5);
        a2.addChild(a6);

        a3.addChild(a7);
        a3.addChild(a8);

        a4.addChild(a9);

        a5.addChild(a10);
        a5.addChild(a11);
        a5.addChild(a12);

        a8.addChild(a13);

        a9.addChild(a14);

        a13.addChild(a15);

        a14.addChild(a16);
        a14.addChild(a17);

        System.out.println(ParcialArboles.resolver(a1).toString());
    }
}
