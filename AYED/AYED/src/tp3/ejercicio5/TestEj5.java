package tp3.ejercicio5;


public class TestEj5 {
    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3);
        GeneralTree<Integer> a4 = new GeneralTree<Integer>(4);
        GeneralTree<Integer> a5 = new GeneralTree<Integer>(5);
        GeneralTree<Integer> a6 = new GeneralTree<Integer>(6);

        a1.addChild(a2);
        a1.addChild(a3);
        a3.addChild(a4);
        a3.addChild(a5);
        a3.addChild(a6);

        System.out.println(a1.esAncestro(3, 5));

    }


}
