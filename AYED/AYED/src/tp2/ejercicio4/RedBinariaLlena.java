package tp2.ejercicio4;

import tp2.ejercicio2.BinaryTree;

public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;
    private static Integer max;

    RedBinariaLlena(BinaryTree<Integer> a){
        arbol = a;
    }

    private void retardo( BinaryTree<Integer> a, int actual){
        actual += a.getData();
        if (a.hasLeftChild()){
            retardo(a.getLeftChild(),actual);
        }
        if(a.hasRightChild()){
            retardo(a.getRightChild(),actual);
        }
        if ( a.isLeaf() && (actual > max)){
            max = actual;
        }

    }
    public int retardoEnvio(){
        int r = 0;
        max = 0;
        retardo(arbol,r);
        return max;
    }
}
