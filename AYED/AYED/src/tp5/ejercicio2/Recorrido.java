package tp5.ejercicio2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.*;

public class Recorrido<T> {
	
	public Graph<T> grafo;
	
	public Recorrido (){}
	public Recorrido (Graph<T> g){
		grafo = g;
	}
	
	private void dfs_recu(Vertex<T> vertice, List<T> camino, boolean[] visita) {
		visita[vertice.getPosition()] = true;
		camino.add(vertice.getData());
		Iterator<Edge<T>> it = grafo.getEdges(vertice).iterator();
		it.hasNext();
		it.next();
		for (Edge<T> e: grafo.getEdges(vertice)) {
			if (!visita[e.getTarget().getPosition()]) {
				dfs_recu(e.getTarget(),camino,visita);
			}
		}
		
		
	}
	public List<T> dfs(Graph<T> grafo){
		this.grafo = grafo;
		List<T> camino = new ArrayList<T>();
		if (!grafo.isEmpty()) {
			// Creo variables tabla visitados
			boolean[] visita = new boolean[grafo.getSize()];
			for (boolean e: visita) {
				e = false;
			}
			// Para todos los vertices del grafo
			for (Vertex<T> v: grafo.getVertices()) {
				if (!visita[v.getPosition()] ) {
					// Llamadas recursivas
					dfs_recu(v,camino,visita);
				}
			}
		}
		
		return camino;
	}
	
	public List<T> bfs(Graph<T> grafo){
		this.grafo = grafo;
		List<T> camino = new ArrayList<T>();
		if (!grafo.isEmpty()) {
			boolean[] visite = new boolean[grafo.getSize()];
			Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
			
			for (Vertex<T> v: grafo.getVertices()) {
				if (!visite[v.getPosition()]) {
					cola.enqueue(v);
					visite[v.getPosition()] = true;
					camino.add(v.getData());
					while (!cola.isEmpty()) {
						Vertex<T> actual = cola.dequeue();
						for (Edge<T> e: grafo.getEdges(actual)) {
							if (!visite[e.getTarget().getPosition()]){
								visite[e.getTarget().getPosition()] = true;
								camino.add(e.getTarget().getData());
								cola.enqueue(e.getTarget());
							}
						}
					}
					
				}
				
			}
			
		}
		
		return camino;
	}

}
