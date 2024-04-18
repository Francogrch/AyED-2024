package tp3.ejercicio2;

import tp3.ejercicio1.GeneralTree;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import tp1.ejercicio8.Queue;

public class RecorridosAG {

    private void recorridoPreOrden(GeneralTree<Integer> a, int n, List<Integer> arr) {
        if ((a.getData() > n) && !(a.getData() % 2 == 0)) {
            arr.add(a.getData());
        }
        if (a.hasChildren()) {
            for (GeneralTree<Integer> child : a.getChildren()) {
                recorridoPreOrden(child, n, arr);
            }
        }
    }

    ;

    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> list = new ArrayList<Integer>();
        recorridoPreOrden(a, n, list);
        return list;
    }


    private void recorridoInOrden(GeneralTree<Integer> a, int n, List<Integer> arr) {

        if (a.hasChildren()) {
            Iterator<GeneralTree<Integer>> it = a.getChildren().iterator();
            GeneralTree<Integer> hi = it.next();
            recorridoInOrden(hi, n, arr);
            if ((a.getData() > n) && !(a.getData() % 2 == 0)) {
                arr.add(hi.getData());
            }

            while (it.hasNext()) {
                recorridoInOrden(it.next(), n, arr);
            }
        } else {
            if ((a.getData() > n) && !(a.getData() % 2 == 0)) {
                arr.add(a.getData());
            }
        }
    }

    ;

    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> list = new ArrayList<Integer>();
        recorridoInOrden(a, n, list);
        return list;
    }

    private void recorridoPostOrden(GeneralTree<Integer> a, int n, List<Integer> arr) {
        if (a.hasChildren()) {
            for (GeneralTree<Integer> child : a.getChildren()) {
                recorridoPostOrden(child, n, arr);
            }
        }
        if ((a.getData() > n) && !(a.getData() % 2 == 0)) {
            arr.add(a.getData());
        }
    }

    ;

    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> list = new ArrayList<Integer>();
        recorridoPostOrden(a, n, list);
        return list;
    }

    private void recorridoPorNiveles(GeneralTree<Integer> a, List<Integer> arr, int n) {
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(a);
        while (!cola.isEmpty()) {
            GeneralTree<Integer> act = cola.dequeue();
            if ((act.getData() > n) && !(act.getData() % 2 == 0)) {
                arr.add(act.getData());
            }
            if (act.hasChildren()) {
                for (GeneralTree<Integer> child : act.getChildren()) {
                    cola.enqueue(child);
                }
            }

        }
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        List<Integer> l = new ArrayList<Integer>();
        recorridoPorNiveles(a, l, n);
        return l;
    }
}
/*Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>, ¿qué modificaciones haría tanto en la firma como en la implementación de los mismos?

    No pasaria por parametro el arbol general, y utilizaria el this, en ves de esa variable.
*
*/