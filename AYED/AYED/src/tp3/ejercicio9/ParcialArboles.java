package tp3.ejercicio9;

import tp3.ejercicio5.GeneralTree;

import java.util.Iterator;

public class ParcialArboles {
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (recursiva(arbol, arbol.getData())) {
            return true;
        }
        return false;
    }

    private static boolean recursiva(GeneralTree<Integer> arbol, int valor) {
        boolean retu = false;
        if (arbol.getData() >= valor) {
            retu = true;
            if (!arbol.isLeaf()) {
                if (retu) {
                    Iterator<GeneralTree<Integer>> i = arbol.getChildren().iterator();
                    while ((i.hasNext()) && (retu)) {
                        retu = recursiva(i.next(), arbol.getData());
                    }
                }
            }
        }
        return retu;
    }
}

