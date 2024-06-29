package tp5.ejercicio5;

import java.util.ArrayList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class quedateEnCasa {

	public quedateEnCasa() {
	}

	public List<Persona> jubiladosCobrar(Graph<Persona> g, Persona empleado, int distancia) {
		List<Persona> list = new ArrayList<Persona>();
		if (!g.isEmpty()) {
			Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
			boolean[] visite = new boolean[g.getSize()];
			cola.enqueue(g.search(empleado));
			cola.enqueue(null);
			int nivel = 0;
			while (!cola.isEmpty() && nivel <= distancia) {
				Vertex<Persona> actual = cola.dequeue();
				if (actual != null) {
					Persona p = actual.getData();
					if (p.esJubilado() && !p.yaCobro()) {
						list.add(p);
					}
					for (Edge<Persona> e : g.getEdges(actual)) {
						if (!visite[e.getTarget().getPosition()]) {
							visite[e.getTarget().getPosition()] = true;
							cola.enqueue(e.getTarget());
						}
					}
				} else if (!cola.isEmpty()) {
					cola.enqueue(null);
					nivel += 1;
				}
			}
		}
		return list;
	}
}
