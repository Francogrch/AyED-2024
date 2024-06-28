package tp5.ejercicio4;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class VisitaOsloTest {
	public static void main(String[] args) {
		Graph<String> g = new AdjListGraph<String>();

		Vertex<String> v1 = g.createVertex("Holmenkollen");
		Vertex<String> v2 = g.createVertex("Parque Vigeland");
		Vertex<String> v3 = g.createVertex("FolkMuseum");
		Vertex<String> v4 = g.createVertex("Museo Fram");
		Vertex<String> v5 = g.createVertex("Museo del Barco Polar");
		Vertex<String> v6 = g.createVertex("Museo Vikingo");
		Vertex<String> v7 = g.createVertex("Akker Brigge");
		Vertex<String> v8 = g.createVertex("Palacio Real");
		Vertex<String> v9 = g.createVertex("Galeria Nacional");
		Vertex<String> v10 = g.createVertex("Ayuntamiento");
		Vertex<String> v11 = g.createVertex("Parque Botanico");
		Vertex<String> v12 = g.createVertex("Museo Munch");
		Vertex<String> v13 = g.createVertex("El Tigre");
		Vertex<String> v14 = g.createVertex("La Opera");
		Vertex<String> v15 = g.createVertex("Fortaleza Akershus");

		g.connect(v1, v2, 30);
		g.connect(v2, v1, 30);
		g.connect(v2, v3, 20);
		g.connect(v3, v2, 20);
		g.connect(v3, v4, 5);
		g.connect(v4, v3, 5);
		g.connect(v4, v5, 5);
		g.connect(v5, v4, 5);
		g.connect(v5, v6, 5);
		g.connect(v6, v5, 5);
		g.connect(v6, v7, 30);
		g.connect(v7, v6, 30);
		g.connect(v7, v3, 30);
		g.connect(v3, v7, 30);
		g.connect(v8, v3, 5);
		g.connect(v3, v8, 5);
		g.connect(v8, v10, 5);
		g.connect(v10, v8, 5);
		g.connect(v7, v10, 20);
		g.connect(v10, v7, 20);
		g.connect(v2, v9, 10);
		g.connect(v9, v2, 10);
		g.connect(v9, v11, 15);
		g.connect(v11, v9, 15);
		g.connect(v11, v10, 10);
		g.connect(v10, v11, 10);
		g.connect(v11, v12, 1);
		g.connect(v12, v11, 1);
		g.connect(v12, v13, 15);
		g.connect(v13, v12, 15);
		g.connect(v10, v13, 15);
		g.connect(v13, v10, 15);
		g.connect(v13, v14, 5);
		g.connect(v14, v13, 5);
		g.connect(v14, v15, 10);
		g.connect(v15, v14, 10);

		VisitaOslo vo = new VisitaOslo();
		List<String> list = new ArrayList<String>();
		list.add("Akker Brigge");
		list.add("Palacio Real");
		System.out.println(
				"paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) : List<String>");

		System.out.println(vo.paseoEnBici(g, "Museo Vikingo", 120, list));
	}
}
