package tp3.ejercicio8;

import tp3.ejercicio5.GeneralTree;

public class TestNavidad {
    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<>(1);
        GeneralTree<Integer> a2 = new GeneralTree<>(2);
        GeneralTree<Integer> a3 = new GeneralTree<>(3);
        GeneralTree<Integer> a4 = new GeneralTree<>(4);
        GeneralTree<Integer> a5 = new GeneralTree<>(5);
        GeneralTree<Integer> a6 = new GeneralTree<>(6);
        GeneralTree<Integer> a7 = new GeneralTree<>(7);
        GeneralTree<Integer> a8 = new GeneralTree<>(8);
        Navidad navidad = new Navidad(a1);

        System.out.println("------------------------Ejemplo 1");
        a1.addChild(a2);
        a1.addChild(a3);
        a1.addChild(a4);
        System.out.println(navidad.esAbetoNavidenio());

        System.out.println("------------------------Ejemplo 2");
        a2.addChild(a5);
        a2.addChild(a6);
        a2.addChild(a7);
        System.out.println(navidad.esAbetoNavidenio());


        System.out.println("------------------------Ejemplo 3");
        a2.removeChild(a5);
        a2.removeChild(a6);
        a2.removeChild(a7);
        a1.addChild(a5);
        a3.addChild(a6);
        a3.addChild(a7);
        a3.addChild(a8);
        System.out.println(navidad.esAbetoNavidenio());
    }
}
