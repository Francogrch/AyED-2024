package tp5.ejercicio6;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class BuscadorDeCaminos {
	private Graph<String> bosque;

	public BuscadorDeCaminos(Graph<String> b) {
		bosque = b;
	}

	private void agregarLista(List<List<String>> lista, List<String> camino) {
		List<String> nuevo = new ArrayList<String>();
		for (String e : camino) {
			nuevo.add(e);
		}
		lista.add(nuevo);

	}

	private void dfs(Vertex<String> actual, List<String> camino, List<List<String>> lista, boolean[] visite) {
		camino.add(actual.getData());

		if (actual.getData().equals("Casa Abuelita")) {
			agregarLista(lista, camino);
		} else {

			visite[actual.getPosition()] = true;
			for (Edge<String> e : bosque.getEdges(actual)) {
				if (e.getWeight() <= 5 && !visite[e.getTarget().getPosition()]) {
					dfs(e.getTarget(), camino, lista, visite);
				}
			}
		}
		camino.remove(actual.getData());
		visite[actual.getPosition()] = false;
	}

	public List<List<String>> recorridosMasSeguros() {

		List<List<String>> lista = new ArrayList<List<String>>();
		if (!bosque.isEmpty()) {
			boolean[] visite = new boolean[bosque.getSize()];
			List<String> camino = new ArrayList<String>();
			dfs(bosque.search("Casa Caperucita"), camino, lista, visite);
		}

		return lista;
	}
}
