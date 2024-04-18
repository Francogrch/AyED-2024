package tp3.ejercicio7;

import tp3.ejercicio5.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class Caminos {
    private GeneralTree<Integer> arbol;
    private static List<Integer> lista = new ArrayList<Integer>();

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public void caminoMasLargo(GeneralTree<Integer> a, List<Integer> l) {
        System.out.println("Nodo" + a.getData());
        System.out.println("l " + l.size() + " lista " + lista.size());
        l.add(a.getData());
        if ((a.isLeaf()) && (l.size() > lista.size())) {
            for (Integer e : lista) {
                lista.remove(e);
            }
            for (Integer e : l) {
                boolean add = lista.add(e);
            }
            System.out.println(l.toString());
        }
        for (GeneralTree<Integer> child : a.getChildren()) {
            caminoMasLargo(child, l);
        }
        l.remove(a.getData());

    }

    public List<Integer> caminoAHojaMasLejana() {
        List<Integer> l = new ArrayList<Integer>();
        caminoMasLargo(arbol, l);
        return lista;
    }
}
