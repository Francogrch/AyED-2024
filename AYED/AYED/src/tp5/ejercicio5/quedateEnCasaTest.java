package tp5.ejercicio5;

import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class quedateEnCasaTest {
	public static void main(String[] args) {
		Persona e1 = new Persona("e1", "d1", false, true, false);
		Persona e2 = new Persona("e2", "d1", false, true, false);
		Persona e3 = new Persona("e3", "d1", false, true, false);
		Persona e4 = new Persona("e4", "d1", false, true, false);

		Persona j1 = new Persona("j1", "d1", true, false, false);
		Persona j2 = new Persona("j2", "d1", true, false, false);
		Persona j3 = new Persona("j3", "d1", true, false, false);
		Persona j4 = new Persona("j4", "d1", true, false, false);
		Persona j5 = new Persona("j5", "d1", true, false, false);

		Graph<Persona> g = new AdjListGraph<Persona>();

		Vertex<Persona> ve1 = g.createVertex(e1);
		Vertex<Persona> ve2 = g.createVertex(e2);
		Vertex<Persona> ve3 = g.createVertex(e3);
		Vertex<Persona> ve4 = g.createVertex(e4);
		Vertex<Persona> vj1 = g.createVertex(j1);
		Vertex<Persona> vj2 = g.createVertex(j2);
		Vertex<Persona> vj3 = g.createVertex(j3);
		Vertex<Persona> vj4 = g.createVertex(j4);
		Vertex<Persona> vj5 = g.createVertex(j5);

		g.connect(ve1, vj1);
		g.connect(ve1, vj2);
		g.connect(ve1, ve2);

		g.connect(vj2, vj3);
		g.connect(vj1, vj2);
		g.connect(vj2, ve3);
		g.connect(ve2, vj5);

		g.connect(vj5, vj4);
		g.connect(vj2, ve4);

		quedateEnCasa qc = new quedateEnCasa();
		System.out.println("jubilados A cobrar: ");
		List<Persona> list = qc.jubiladosCobrar(g, e1, 2);
		for (Persona p : list) {
			System.out.println(p);
		}

	}
}
