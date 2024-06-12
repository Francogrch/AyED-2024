package tp5.ejercicio3;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapaTest {

    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("La Plata");
        Vertex<String> v2 = grafo.createVertex("Villa Elisa");
        Vertex<String> v3 = grafo.createVertex("City Bell");
        Vertex<String> v4 = grafo.createVertex("Tolosa");
        Vertex<String> v5 = grafo.createVertex("Quilmes");
        Vertex<String> v6 = grafo.createVertex("Ringuelet");
        Vertex<String> v7 = grafo.createVertex("Berazategui");
        Vertex<String> v8 = grafo.createVertex("Lomas de Zamora");
        Vertex<String> v9 = grafo.createVertex("La Matanza");
        Vertex<String> v10 = grafo.createVertex("Lanus");

        grafo.connect(v1, v2, 50);
        grafo.connect(v1, v3, 100);
        grafo.connect(v2, v4, 70);
        grafo.connect(v2, v5, 80);
        grafo.connect(v3, v6, 200);
        grafo.connect(v6, v7, 300);
        grafo.connect(v5, v6, 400);
        grafo.connect(v8, v9, 700);
        grafo.connect(v9, v10, 100);


        Mapa m = new Mapa(grafo);
        System.out.println("-----------------------------------");
        System.out.println("devolverCamino()");
        System.out.println(m.devolverCamino("La Plata", "Ringuelet"));
        System.out.println("-----------------------------------");
        System.out.println("devolverCaminoExceptuando()");
        List<String> ciudades = new ArrayList<String>();
        ciudades.add("Quilmes");
        System.out.println(m.devolverCaminoExceptuando("La Plata", "Berazategui", ciudades));

        System.out.println("-----------------------------------");

        System.out.println("caminoMasCorto()");
        System.out.println("-----------------------------------");
        System.out.println("camninoSinCargarCombustible()");
        System.out.println("-----------------------------------");
        System.out.println("caminoConMenorCargaDeCombustible()");
        System.out.println("-----------------------------------");
    }
}
