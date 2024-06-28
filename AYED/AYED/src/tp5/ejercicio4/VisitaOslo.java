package tp5.ejercicio4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {

	private boolean dfs_r(Graph<String> lugares, Vertex<String> actual, Vertex<String> destino, int maxTiempo,
			List<String> lugaresRestringidos, boolean[] visite, List<String> camino) {
		camino.add(actual.getData());
		visite[actual.getPosition()] = true;
		boolean termine = false;
		if (actual.getData().equals(destino.getData())) {
			termine = true;
		} else {
			Iterator<Edge<String>> it = lugares.getEdges(actual).iterator();
			while (it.hasNext() && !termine) {
				Edge<String> adj = it.next();
				if (adj.getWeight() < maxTiempo && !lugaresRestringidos.contains(adj.getTarget().getData())
						&& !visite[adj.getTarget().getPosition()]) {
					termine = dfs_r(lugares, adj.getTarget(), destino, (maxTiempo - adj.getWeight()),
							lugaresRestringidos, visite, camino);
				}

			}
		}

		if (!termine) {
			camino.remove(actual.getData());
		}
		return termine;
	}

	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo,
			List<String> lugaresRestringidos) {
		List<String> camino = new ArrayList<String>();

		if (!lugares.isEmpty()) {
			Vertex<String> inicio = lugares.search("Ayuntamiento");
			boolean[] visite = new boolean[lugares.getSize()];
			Vertex<String> fin = lugares.search(destino);
			if (fin != null) {
				dfs_r(lugares, inicio, fin, maxTiempo, lugaresRestringidos, visite, camino);
			}
		}

		return camino;
	}
}
