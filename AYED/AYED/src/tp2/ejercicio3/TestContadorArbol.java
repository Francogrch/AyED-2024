package tp2.ejercicio3;

import tp2.ejercicio2.BinaryTree;

import java.util.ArrayList;

public class TestContadorArbol {



    public static void main(String[] args){
        BinaryTree<Integer> arbol0 = new BinaryTree<Integer>(1);
        BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(2);
        BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> arbol3 = new BinaryTree<Integer>(4);
        BinaryTree<Integer> arbol4 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> arbol5 = new BinaryTree<Integer>(6);
        BinaryTree<Integer> arbol6 = new BinaryTree<Integer>(7);

        arbol0.addLeftChild(arbol1);
        arbol0.addRightChild(arbol2);
        arbol1.addLeftChild(arbol3);
        arbol1.addRightChild(arbol4);
        arbol2.addLeftChild(arbol5);
        arbol2.addRightChild(arbol6);

        ContadorArbol contador = new ContadorArbol(arbol0);

        ArrayList<Integer> pares = contador.numerosPares();

        System.out.println("Pares:");
        for (Integer e: pares){
            System.out.println(e);
        }



    }

}
