package tp5.ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {
	private Graph<String> mapaCiudades;
	private static int VALOR_GRANDE = 9999;

	public Mapa(Graph<String> g) {
		mapaCiudades = g;
	}

	private boolean devolverCamino_r(Vertex<String> c1, Vertex<String> c2, List<String> camino, boolean[] visite) {
		visite[c1.getPosition()] = true;
		boolean sigue = false;
		if (c1.getData().equals(c2.getData())) {
			sigue = true;
		} else {
			for (Edge<String> e : mapaCiudades.getEdges(c1)) {
				if (!visite[e.getTarget().getPosition()] && !sigue) {
					sigue = devolverCamino_r(e.getTarget(), c2, camino, visite);
				}
			}
		}
		if (sigue) {
			camino.add(c1.getData());
		}
		return sigue;
	}

	public List<String> devolverCamino(String c1, String c2) {
		List<String> camino = new ArrayList<String>();
		if (mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null) {
			boolean[] visite = new boolean[mapaCiudades.getSize()];
			devolverCamino_r(mapaCiudades.search(c1), mapaCiudades.search(c2), camino, visite);
		}
		return camino;
	}

	private boolean devolverCaminoExceptuando_r(Vertex<String> c1, Vertex<String> c2, List<String> ciudades,
			List<String> camino, boolean[] visite) {
		boolean sigue = false;
		if (c1.getData().equals(c2.getData())) {
			sigue = true;
		} else {
			Iterator<Edge<String>> it = mapaCiudades.getEdges(c1).iterator();
			while (it.hasNext() && !sigue) {
				Edge<String> actual = it.next();
				if (!visite[actual.getTarget().getPosition()] && !(ciudades.contains(actual.getTarget().getData()))) {
					sigue = devolverCaminoExceptuando_r(actual.getTarget(), c2, ciudades, camino, visite);
				}
			}
		}
		if (sigue) {
			camino.add(c1.getData());
		}
		return sigue;

	}

	public List<String> devolverCaminoExceptuando(String c1, String c2, List<String> ciudades) {
		List<String> camino = new ArrayList<>();
		if (mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null) {
			boolean[] visite = new boolean[mapaCiudades.getSize()];
			devolverCaminoExceptuando_r(mapaCiudades.search(c1), mapaCiudades.search(c2), ciudades, camino, visite);
		}

		return camino;
	}

	public void vaciar_cargar(List<Vertex<String>> a1, List<Vertex<String>> a2) {
		a2.clear();
		for (Vertex<String> e : a1) {
			a2.add(e);
		}
	}

	public void caminoMasCorto_bfs(Vertex<String> c1, Vertex<String> c2) {

	}

	private Vertex<String> min_vertex(int[][] dijkstra) {
		int num_v = 0;
		int min = VALOR_GRANDE - 1;
		for (int y = 0; y < mapaCiudades.getSize(); y++) {
			if (dijkstra[y][2] == 0 && dijkstra[y][0] < min) {
				num_v = y;
				min = dijkstra[y][0];
			}
		}
		return mapaCiudades.getVertices().get(num_v);
	}

	private void print_dijkstra(int[][] d) {
		// for(int i=0;i<3;i++) {
		// System.out.println("Columna " + i );
		for (int y = 0; y < mapaCiudades.getSize(); y++) {
			System.out.println(d[y][0] + " " + d[y][1] + " " + d[y][2]);
		}
		// }
	}

	public List<String> caminoMasCorto(String c1, String c2) {

		/*
		 * Retorna la lista de ciudades que forman el camino más corto para llegar de
		 * ciudad1 a ciudad2, si no existe camino retorna la lista vacía. (Las rutas
		 * poseen la distancia).
		 */
		List<String> camino = new ArrayList<String>();

		if (!mapaCiudades.isEmpty() && (mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null)) {
			int[][] dijkstra = new int[mapaCiudades.getSize()][3];
			/*
			 * Columnas: 0 -> Distancia 1 -> Padre 2 -> Conocido
			 */
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					for (int y = 0; y < mapaCiudades.getSize(); y++)
						dijkstra[y][i] = VALOR_GRANDE;
				} else {
					for (int y = 0; y < mapaCiudades.getSize(); y++)
						dijkstra[y][i] = 0;
				}
			}
			Vertex<String> inicio = mapaCiudades.search(c1);
			dijkstra[0][inicio.getPosition()] = 0;
			boolean encontre = false;
			Iterator<Vertex<String>> vertices = mapaCiudades.getVertices().iterator();
			while (vertices.hasNext() && !encontre) {
				vertices.next();
				Vertex<String> min = min_vertex(dijkstra);
				dijkstra[min.getPosition()][2] = 1;
				encontre = min.getData().equals(c2);
				if (!encontre) {
					for (Edge<String> adj : mapaCiudades.getEdges(min)) {
						Vertex<String> adj_v = adj.getTarget();
						if (dijkstra[adj_v.getPosition()][2] == 0) {
							int peso = adj.getWeight() + dijkstra[min.getPosition()][0];
							if (dijkstra[adj_v.getPosition()][0] > peso) {
								dijkstra[adj_v.getPosition()][0] = peso;
								dijkstra[adj_v.getPosition()][1] = min.getPosition();
							}
						}
					}
				}
			}
			// print_dijkstra(dijkstra);
			int pos = mapaCiudades.search(c2).getPosition();
			List<Vertex<String>> vs = mapaCiudades.getVertices();
			camino.add(c2);
			while (pos != mapaCiudades.search(c1).getPosition()) {
				camino.add(vs.get(dijkstra[pos][1]).getData());
				pos = dijkstra[pos][1];
			}

		}
		return camino;
	}

	private boolean camino_r(Vertex<String> c1, Vertex<String> c2, List<String> caminoA, List<String> camino,
			boolean[] visite, int suma, int tanqueAuto) {
		boolean retu = false;
		caminoA.add(c1.getData());
		if (c1.getData().equals(c2.getData())) {
			camino.clear();
			for (int i = caminoA.size() - 1; i >= 0; i--) {
				camino.add(caminoA.get(i));
			}
			retu = true;
		} else {
			boolean encontre = false;
			Iterator<Edge<String>> it = mapaCiudades.getEdges(c1).iterator();
			while (it.hasNext() && !encontre) {
				Edge<String> actual = it.next();
				int peso = actual.getWeight();
				if (suma + peso < tanqueAuto) {
					encontre = camino_r(actual.getTarget(), c2, caminoA, camino, visite, suma + peso, tanqueAuto);
				}
			}
			if (encontre) {
				retu = true;
			}
		}
		caminoA.remove(c1.getData());
		return retu;
	}

	public List<String> caminoSinCargarCombustible(String c1, String c2, int tanqueAuto) {
		List<String> caminoA = new ArrayList<String>();
		List<String> camino = new ArrayList<String>();
		int suma = 0;
		if (!mapaCiudades.isEmpty() && mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null) {
			boolean[] visite = new boolean[mapaCiudades.getSize()];
			camino_r(mapaCiudades.search(c1), mapaCiudades.search(c2), caminoA, camino, visite, suma, tanqueAuto);
		}
		return camino;
	}

	public int dijkstra_minimo(int[][] t) {
		int valor = VALOR_GRANDE;
		int min = 0;
		for (int i = 0; i < mapaCiudades.getSize(); i++) {
			if (t[i][0] < valor && t[i][2] == 0) {
				valor = t[i][0];
				min = i;
			}
		}
		return min;
	}

	public List<String> caminoConMenorCargaDeCombustible(String c1, String c2, int tanqueAuto) {
		List<String> camino = new ArrayList<String>();

		if (!mapaCiudades.isEmpty() && mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null) {
			/*
			 * 0 -> costo 1 -> padre 2 -> visitado
			 */
			int[][] tabla = new int[mapaCiudades.getSize()][3];
			for (int i = 0; i < mapaCiudades.getSize(); i++) {
				for (int x = 0; x <= 2; x++) {
					if (x == 0) {
						tabla[i][x] = VALOR_GRANDE;
					} else {
						tabla[i][x] = 0;
					}
				}
			}
			tabla[mapaCiudades.search(c1).getPosition()][0] = 0;
			Iterator<Vertex<String>> vectores = mapaCiudades.getVertices().iterator();
			boolean encontre = false;
			while (vectores.hasNext() && !encontre) {
				vectores.next();
				int num = dijkstra_minimo(tabla);
				Vertex<String> min = mapaCiudades.getVertex(num);
				tabla[num][2] = 1;
				Iterator<Edge<String>> it = mapaCiudades.getEdges(min).iterator();
				encontre = min.getData().equals(c2);
				while (it.hasNext() && !encontre) {
					Edge<String> actual = it.next();
					Vertex<String> vertice_a = actual.getTarget();
					int suma = tabla[min.getPosition()][0] + actual.getWeight();
					if (actual.getWeight() <= tanqueAuto && tabla[vertice_a.getPosition()][0] > suma) {
						tabla[vertice_a.getPosition()][0] = suma;
						tabla[vertice_a.getPosition()][1] = min.getPosition();
					}
				}
			}
			if (encontre) {
				camino.add(c2);
				int index = mapaCiudades.search(c2).getPosition();
				while (tabla[index][1] != 0) {
					camino.add(mapaCiudades.getVertex(tabla[index][1]).getData());
					index = tabla[index][1];
				}
				camino.add(c1);
			}

		}

		return camino;
	}
}
