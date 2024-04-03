package tp2.ejercicio5;

import tp2.ejercicio2.BinaryTree;

import tp1.ejercicio8.Queue;

public class ProfundidadDeArbolBinario {

    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> a){
        arbol = a;
    }

    public int sumaElementosProfundidad(int p){
        int suma = 0;
        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
        BinaryTree<Integer> actual = arbol;
        cola.enqueue(actual);
        int prof = -1;
        while (!cola.isEmpty() && prof < p){
            Queue<BinaryTree<Integer>> nivel = new Queue<>();
            while (!cola.isEmpty()){
                actual = cola.dequeue();
                suma += actual.getData();
                nivel.enqueue(actual);
            }
            prof++;
            while (!nivel.isEmpty()){
                actual = nivel.dequeue();
                if (actual.hasLeftChild()){
                    cola.enqueue(actual.getLeftChild());
                }
                if (actual.hasRightChild()){
                    cola.enqueue(actual.getRightChild());
                }
            }
        };
        return suma;
    }
}
