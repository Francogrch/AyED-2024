package tp2.ejercicio2;

public class BinaryTest {

    public static void imprimir(BinaryTree<Integer> bt){
        System.out.print(bt.getData() + " - ");
        if (!bt.isLeaf()){
            if (bt.hasLeftChild()) {
                imprimir(bt.getLeftChild());
            }
            if (bt.hasRightChild()){
                imprimir(bt.getRightChild());
            }
        }
    }
    public static void main(String[] args){
        BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(1);
        BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(2);
        BinaryTree<Integer> arbol3 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> arbol4 = new BinaryTree<Integer>(4);
        BinaryTree<Integer> arbol5 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> arbol6 = new BinaryTree<Integer>(6);

        arbol1.addLeftChild(arbol2);
        arbol1.addRightChild(arbol3);
        arbol2.addLeftChild(arbol4);
        arbol2.addRightChild(arbol5);
        arbol3.addLeftChild(arbol6);



        System.out.println("Test ContarHojas:");
        System.out.println(arbol1.contarHojas());

        System.out.println("Test Espejo: ");
        imprimir(arbol1);
        System.out.println();
        BinaryTreePrinter.print(arbol1);
        System.out.println();

        System.out.println("Espejo:");
        BinaryTree<Integer> arbolEspejo = arbol1.espejo();
        imprimir(arbolEspejo);
        System.out.println();
        BinaryTreePrinter.print(arbolEspejo);

        System.out.println("Test Por niveles");
        arbol1.entreNiveles(1,2);


    }
}
