package tp2.ejercicio3;

import tp2.ejercicio2.BinaryTree;

import java.util.ArrayList;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;
    public ContadorArbol(BinaryTree<Integer> a){
        arbol = a;
    }

    public void inOrden(ArrayList<Integer> list,BinaryTree<Integer> a){
        if (a.hasLeftChild()){
            inOrden(list,a.getLeftChild());
        }
        if (a.getData() % 2 == 0){
            list.add(a.getData());
        }
        if(a.hasRightChild()){
            inOrden(list,a.getRightChild());
        }
    }
    public void postOrden(ArrayList<Integer> list,BinaryTree<Integer> a){
        if (a.hasLeftChild()){
            inOrden(list,a.getLeftChild());
        }

        if(a.hasRightChild()){
            inOrden(list,a.getRightChild());
        }
        if (a.getData() % 2 == 0){
            list.add(a.getData());
        }
    }
    public ArrayList<Integer> numerosPares(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        postOrden(list,arbol);
        //inOrden(list,arbol);
        return list;

    }


}
