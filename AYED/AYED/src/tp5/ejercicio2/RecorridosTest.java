package tp5.ejercicio2;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class RecorridosTest {

    public static void main(String[] args) {
        Graph<Integer> grafo = new AdjListGraph<Integer>();

        Vertex<Integer> v1 = grafo.createVertex(1);
        Vertex<Integer> v2 = grafo.createVertex(2);
        Vertex<Integer> v3 = grafo.createVertex(3);
        Vertex<Integer> v4 = grafo.createVertex(4);
        Vertex<Integer> v5 = grafo.createVertex(5);
        Vertex<Integer> v6 = grafo.createVertex(6);

        grafo.connect(v1, v2);
        grafo.connect(v1, v3);
        grafo.connect(v4, v5);
        grafo.connect(v6, v1);
        grafo.connect(v2, v1);
        grafo.connect(v2, v6);

        Recorrido<Integer> reco = new Recorrido();
        System.out.println("DFS");
        System.out.println(reco.dfs(grafo));
        System.out.println("---------------------------------------");
        System.out.println("BFS");
        System.out.println(reco.bfs(grafo));

    }
}
