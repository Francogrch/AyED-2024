package tp5.ejercicio2;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.adjList.AdjListVertex;
import tp1.ejercicio8.Queue;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Recorridos<T> {

    private void dfs_recursive(Vertex<T> v, boolean[] visite, Graph<T> grafo, List<T> recorrido) {
        if (!visite[v.getPosition()]) {
            visite[v.getPosition()] = true;
            recorrido.add(v.getData());
            for (Edge<T> arista : grafo.getEdges(v)) {
                dfs_recursive(arista.getTarget(), visite, grafo, recorrido);
            }
        }


    }

    public List<T> dfs(Graph<T> grafo) {
        List<T> recorrido = new ArrayList<T>();
        if (grafo.getSize() != 0) {
            boolean[] visite = new boolean[grafo.getSize()];
            for (boolean e : visite) {
                e = false;
            }
            for (Vertex<T> vertice : grafo.getVertices()) {
                dfs_recursive(vertice, visite, grafo, recorrido);
            }
            ;
        }
        return recorrido;
    }

    public List<T> bfs(Graph<T> grafo) {
        List<T> recorrido = new ArrayList<T>();
        if (grafo.getSize() != 0) {
            Queue<AdjListVertex<T>> cola = new Queue<AdjListVertex<T>>();
            boolean[] visite = new boolean[grafo.getSize()];
            for (boolean e : visite) {
                e = false;
            }
            List<Vertex<T>> vertices = grafo.getVertices();
            Iterator<Vertex<T>> it = vertices.iterator();
            Vertex<T> vertice = it.next();
            cola.enqueue((AdjListVertex<T>) vertice);
            while (it.hasNext()) {
                while (!cola.isEmpty()) {
                    vertice = cola.dequeue();
                    visite[vertice.getPosition()] = true;
                    recorrido.add(vertice.getData());
                    for (Edge<T> e : grafo.getEdges(vertice)) {
                        if (!visite[e.getTarget().getPosition()]) {
                            cola.enqueue((AdjListVertex<T>) e.getTarget());
                        }
                    }
                }
                vertice = it.next();
                while (it.hasNext() && visite[vertice.getPosition()]) {
                    vertice = it.next();
                }
                cola.enqueue((AdjListVertex<T>) vertice);

            }
        }
        return recorrido;

    }
}
