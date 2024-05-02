package tp3.ejercicio10;

import tp3.ejercicio5.GeneralTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles {


    private static Auxiliar recursivo(GeneralTree<Integer> a, int nivel) {
        Auxiliar aux = new Auxiliar();
        if (!a.isLeaf()) {
            Auxiliar aux2 = new Auxiliar();
            for (GeneralTree<Integer> child : a.getChildren()) {
                aux2 = recursivo(child, nivel + 1);
                if (aux2.getMax() > aux.getMax()) {
                    aux = aux2;
                }
            }
        }
        if (a.getData() != 0) {
            aux.getL().add(a.getData());
            aux.setMax(aux.getMax() + (a.getData() * nivel));
        }
        return aux;
    }

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        Auxiliar a = recursivo(arbol, 0);
        return a.getL();
    }
}
