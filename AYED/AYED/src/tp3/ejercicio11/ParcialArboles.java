package tp3.ejercicio11;

import tp1.ejercicio8.Queue;
import tp3.ejercicio5.GeneralTree;


public class ParcialArboles {

    public static boolean resolver(GeneralTree<Integer> arbol) {
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        int nivel = 1;
        int cantAct = 0;
        boolean seguir = true;
        while (!cola.isEmpty() && seguir) {
            GeneralTree<Integer> act = cola.dequeue();
            if (act != null) {
                for (GeneralTree<Integer> child : act.getChildren()) {
                    cola.enqueue(child);
                }
                cantAct++;
            } else {
                if (!cola.isEmpty()) {
                    System.out.println("Nivel = " + nivel + ". cantAct = " + cantAct);
                    if (nivel == cantAct) {
                        cantAct = 0;
                        nivel++;
                        cola.enqueue(null);
                    } else {
                        seguir = false;
                    }
                }
            }

        }
        return seguir;
    }
}
