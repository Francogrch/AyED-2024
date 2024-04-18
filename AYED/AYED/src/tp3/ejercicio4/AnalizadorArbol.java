package tp3.ejercicio4;

import tp1.ejercicio8.Queue;
import tp3.ejercicio3.GeneralTree;

import java.awt.geom.Area;

public class AnalizadorArbol {
    public static double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        double max = arbol.getData().getTardanza();
        int suma = 0;
        int cant = 0;
        while (!cola.isEmpty()) {
            GeneralTree<AreaEmpresa> act = cola.dequeue();
            if (act != null) {
                for (GeneralTree<AreaEmpresa> child : act.getChildren()) {
                    suma += child.getData().getTardanza();
                    cant++;
                    cola.enqueue(child);
                }
            } else {
                if (!cola.isEmpty()) {
                    cola.enqueue(null);
                    double prom = (double) suma / cant;
                    if (prom > max) {
                        max = prom;
                    }
                    suma = 0;
                    cant = 0;
                }
            }
        }
        return max;
    }
}
