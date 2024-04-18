package tp3.ejercicio3;

import tp3.ejercicio3.GeneralTree;

public class TestEj3 {
    public static void main(String[] args) {
        GeneralTree<Integer> ag1 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> ag2 = new GeneralTree<Integer>(2);
        GeneralTree<Integer> ag3 = new GeneralTree<Integer>(3);
        GeneralTree<Integer> ag4 = new GeneralTree<Integer>(4);
        GeneralTree<Integer> ag5 = new GeneralTree<Integer>(5);
        GeneralTree<Integer> ag6 = new GeneralTree<Integer>(6);

        ag1.addChild(ag2);
        ag1.addChild(ag3);
        ag3.addChild(ag4);
        ag3.addChild(ag5);
        ag3.addChild(ag6);

        System.out.println("Altura del arbol: " + ag1.altura());
        int browse = 2;
        System.out.println("El dato " + browse + " esta en el nivel " + ag1.nivel(browse));
        System.out.println("El ancho del arbol es de: " + ag1.ancho());

    }
}
