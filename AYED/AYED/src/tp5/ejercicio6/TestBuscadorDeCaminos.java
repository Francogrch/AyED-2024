package tp5.ejercicio6;

import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class TestBuscadorDeCaminos {
	public static void main(String[] args) {
		Graph<String> g = new AdjListGraph<String>();

		Vertex<String> v0 = g.createVertex("Casa Caperucita");
		Vertex<String> v1 = g.createVertex("Claro 1");
		Vertex<String> v2 = g.createVertex("Claro 2");
		Vertex<String> v3 = g.createVertex("Claro 3");
		Vertex<String> v4 = g.createVertex("Claro 4");
		Vertex<String> v5 = g.createVertex("Claro 5");
		Vertex<String> v6 = g.createVertex("Casa Abuelita");

		g.connect(v0, v1, 3);
		g.connect(v1, v0, 3);
		g.connect(v0, v2, 4);
		g.connect(v2, v0, 4);
		g.connect(v0, v3, 4);
		g.connect(v3, v0, 4);

		g.connect(v3, v5, 15);
		g.connect(v5, v3, 15);

		g.connect(v1, v2, 4);
		g.connect(v2, v1, 4);
		g.connect(v1, v5, 3);
		g.connect(v5, v1, 3);

		g.connect(v2, v5, 11);
		g.connect(v5, v2, 11);
		g.connect(v2, v4, 10);
		g.connect(v4, v2, 10);

		g.connect(v5, v6, 4);
		g.connect(v6, v5, 4);

		g.connect(v4, v6, 9);
		g.connect(v6, v4, 9);
		BuscadorDeCaminos bc = new BuscadorDeCaminos(g);
		System.out.println("public List < List <String>> recorridosMasSeguro()");
		List<List<String>> list = bc.recorridosMasSeguros();
		for (List<String> e : list) {
			System.out.println(e);
		}

	}
}
