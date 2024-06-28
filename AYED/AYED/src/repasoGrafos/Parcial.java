package repasoGrafos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Parcial {

	private void cambiarArray(List<Recinto> a, List<Recinto> b) {
		a.clear();
		for (Recinto e : b) {
			a.add(e);
		}

	}

	private void dfs(Graph<Recinto> sitios, Vertex<Recinto> vertice, int suma, int limite, boolean[] visito,
			List<Recinto> caminoActual, List<Recinto> caminoMasLargo) {
		if (suma + vertice.getData().getTiempo() <= limite) {
			caminoActual.add(vertice.getData());
			suma = suma + vertice.getData().getTiempo();
			visito[vertice.getPosition()] = true;
			for (Edge<Recinto> adj : sitios.getEdges(vertice)) {
				if (suma + adj.getWeight() <= limite) {
					if (!visito[adj.getTarget().getPosition()]) {
						dfs(sitios, adj.getTarget(), (suma + adj.getWeight()), limite, visito, caminoActual,
								caminoMasLargo);
					}
				} else {
					if (caminoActual.size() > caminoMasLargo.size()) {
						cambiarArray(caminoMasLargo, caminoActual);
					}
				}
			}
			if (sitios.getEdges(vertice).size() == 0 && caminoActual.size() > caminoMasLargo.size()) {
				cambiarArray(caminoMasLargo, caminoActual);
			}
			caminoActual.remove(vertice.getData());
			visito[vertice.getPosition()] = false;
		}
	}

	public int resolver(Graph<Recinto> sitios, int tiempo) {
		List<Recinto> caminoMasLargo = new ArrayList<Recinto>();

		if (!sitios.isEmpty()) {
			Vertex<Recinto> entrada = null;
			Iterator<Vertex<Recinto>> it = sitios.getVertices().iterator();
			boolean encontre = false;
			while (it.hasNext() && !encontre) {
				Vertex<Recinto> actual = it.next();
				if (actual.getData().getNombre().equals("ENTRADA")) {
					encontre = true;
					entrada = actual;
				}
			}
			if (entrada != null) {
				boolean[] visito = new boolean[sitios.getSize()];
				List<Recinto> caminoActual = new ArrayList<Recinto>();
				dfs(sitios, entrada, 0, tiempo, visito, caminoActual, caminoMasLargo);
			}
		}

		return caminoMasLargo.size();
	}

}
