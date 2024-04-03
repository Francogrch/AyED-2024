package tp2.ejercicio5;

import tp2.ejercicio2.BinaryTree;

public class ProfundidadTest {

    public static void main (String[] args){

        BinaryTree<Integer> arbol0 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(12);
        BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(4);
        BinaryTree<Integer> arbol3 = new BinaryTree<Integer>(7);
        BinaryTree<Integer> arbol4 = new BinaryTree<Integer>(8);
        BinaryTree<Integer> arbol5 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> arbol6 = new BinaryTree<Integer>(2);

        arbol0.addLeftChild(arbol1);
        arbol0.addRightChild(arbol2);
        arbol1.addLeftChild(arbol3);
        arbol1.addRightChild(arbol4);
        arbol2.addLeftChild(arbol5);
        arbol2.addRightChild(arbol6);


        ProfundidadDeArbolBinario pAb = new ProfundidadDeArbolBinario(arbol0);
        System.out.println(pAb.sumaElementosProfundidad(0));
    }
}
