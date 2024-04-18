package tp3.ejercicio6;

import tp3.ejercicio5.GeneralTree;

public class TestEjercicio6 {

    public static void main(String[] args) {

        GeneralTree<Character> a1 = new GeneralTree<>('A');
        GeneralTree<Character> a2 = new GeneralTree<>('B');
        GeneralTree<Character> a3 = new GeneralTree<>('C');
        GeneralTree<Character> a4 = new GeneralTree<>('D');
        GeneralTree<Character> a5 = new GeneralTree<>('E');
        GeneralTree<Character> a6 = new GeneralTree<>('F');
        GeneralTree<Character> a7 = new GeneralTree<>('G');
        GeneralTree<Character> a8 = new GeneralTree<>('H');
        GeneralTree<Character> a9 = new GeneralTree<>('I');
        GeneralTree<Character> a10 = new GeneralTree<>('J');
        GeneralTree<Character> a11 = new GeneralTree<>('K');
        GeneralTree<Character> a12 = new GeneralTree<>('P');
        GeneralTree<Character> a13 = new GeneralTree<>('L');
        GeneralTree<Character> a14 = new GeneralTree<>('M');
        GeneralTree<Character> a15 = new GeneralTree<>('N');

        a1.addChild(a2);
        a1.addChild(a3);
        a1.addChild(a4);
        a1.addChild(a5);

        a3.addChild(a6);
        a3.addChild(a7);

        a4.addChild(a8);
        a4.addChild(a9);
        a4.addChild(a10);
        a4.addChild(a11);
        a4.addChild(a12);

        a7.addChild(a13);

        a10.addChild(a14);
        a10.addChild(a15);

        RedDeAguaPotable rap = new RedDeAguaPotable(a1);

        System.out.println(rap.minimoCaudal(1000));

    }

}
