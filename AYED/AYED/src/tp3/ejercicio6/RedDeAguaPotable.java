package tp3.ejercicio6;

import tp3.ejercicio5.GeneralTree;

public class RedDeAguaPotable {
    private GeneralTree<Character> arbol;
    private static double min;

    public RedDeAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }

    private void recorrerMin(GeneralTree<Character> a, double caudal) {

        if ((a.isLeaf()) && (caudal < min)) {
            min = caudal;
        } else {
            int cant = a.getChildren().size();

            for (GeneralTree<Character> child : a.getChildren()) {
                recorrerMin(child, caudal / cant);
            }
        }
    }

    public double minimoCaudal(double caudal) {
        min = caudal;
        recorrerMin(arbol, min);
        return min;
    }
}
