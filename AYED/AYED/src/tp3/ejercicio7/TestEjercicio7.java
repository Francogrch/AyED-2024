package tp3.ejercicio7;

import tp3.ejercicio5.GeneralTree;

import java.util.List;

public class TestEjercicio7 {
    public static void main(String[] args) {

        GeneralTree<Integer> a1 = new GeneralTree<>(12);
        GeneralTree<Integer> a2 = new GeneralTree<>(17);
        GeneralTree<Integer> a3 = new GeneralTree<>(9);
        GeneralTree<Integer> a4 = new GeneralTree<>(15);
        GeneralTree<Integer> a5 = new GeneralTree<>(10);
        GeneralTree<Integer> a6 = new GeneralTree<>(6);
        GeneralTree<Integer> a7 = new GeneralTree<>(8);
        GeneralTree<Integer> a8 = new GeneralTree<>(14);
        GeneralTree<Integer> a9 = new GeneralTree<>(18);
        GeneralTree<Integer> a10 = new GeneralTree<>(1);
        GeneralTree<Integer> a11 = new GeneralTree<>(16);
        GeneralTree<Integer> a12 = new GeneralTree<>(7);

        a1.addChild(a2);
        a1.addChild(a3);
        a1.addChild(a4);
        a2.addChild(a5);
        a2.addChild(a6);
        a3.addChild(a7);
        a4.addChild(a8);
        a4.addChild(a9);
        a6.addChild(a10);
        a6.addChild(a10);
        a8.addChild(a11);
        a8.addChild(a12);

        Caminos c = new Caminos(a1);

        List<Integer> l = c.caminoAHojaMasLejana();
        System.out.println(l.toString());
    }
}
