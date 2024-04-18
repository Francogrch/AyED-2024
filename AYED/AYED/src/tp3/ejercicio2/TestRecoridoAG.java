package tp3.ejercicio2;

import tp3.ejercicio1.GeneralTree;

public class TestRecoridoAG {
    public static void main(String[] args) {
        RecorridosAG ag = new RecorridosAG();
        GeneralTree<Integer> ag1 = new GeneralTree<Integer>();
        GeneralTree<Integer> ag2 = new GeneralTree<Integer>();
        GeneralTree<Integer> ag3 = new GeneralTree<Integer>();
        GeneralTree<Integer> ag4 = new GeneralTree<Integer>();
        GeneralTree<Integer> ag5 = new GeneralTree<Integer>();


        ag1.setData(1);
        ag2.setData(2);
        ag3.setData(3);
        ag4.setData(4);
        ag5.setData(5);

        ag1.addChild(ag2);
        ag1.addChild(ag3);
        ag3.addChild(ag4);
        ag3.addChild(ag5);

        System.out.print(ag.numerosImparesMayoresQuePreOrden(ag1, 2).toString());
        System.out.print(ag.numerosImparesMayoresQueInOrden(ag1, 2).toString());
        System.out.print(ag.numerosImparesMayoresQuePostOrden(ag1, 2).toString());
        System.out.print(ag.numerosImparesMayoresQuePorNiveles(ag1, 2).toString());
    }
}
