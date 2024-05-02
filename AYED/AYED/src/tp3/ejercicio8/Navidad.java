package tp3.ejercicio8;

import tp3.ejercicio5.GeneralTree;

import java.util.Iterator;

public class Navidad {
    private GeneralTree<Integer> arbol;


    public Navidad(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    private int recursion(GeneralTree<Integer> a, int valor) {
        if (!a.isLeaf()) {
            int suma = 0;
            for (GeneralTree<Integer> child : a.getChildren()) {
                suma += recursion(child, a.getData());
                System.out.println(a.getData());//Input
            }
            if (suma >= (a.getData() * 3)) {
                valor = 0;
            } else {
                valor = -valor;
            }
        }
        return valor;
    }

    public String esAbetoNavidenio() {
        if (recursion(arbol, arbol.getData()) == 0) {
            return "Yes";
        } else {
            return "No";
        }

    }
}
