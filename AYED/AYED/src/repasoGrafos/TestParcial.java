package repasoGrafos;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class TestParcial {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Recinto> grafo = new AdjListGraph<Recinto>();
		
		Recinto r1 = new Recinto("ENTRADA",15);
		Recinto r2 = new Recinto("Flamencos",10);
		Recinto r3 = new Recinto("Tigres",10);
		Recinto r4 = new Recinto("Cebras",10);
		Recinto r5 = new Recinto("Murcielagos",20);
		Recinto r6 = new Recinto("Wallabies",30);
		Recinto r7 = new Recinto("Tortugas",10);
		Recinto r8 = new Recinto("Pumas",10);
		
		Vertex<Recinto> v1 = grafo.createVertex(r1);
		Vertex<Recinto> v2 = grafo.createVertex(r2);
		Vertex<Recinto> v3 = grafo.createVertex(r3);
		Vertex<Recinto> v4 = grafo.createVertex(r4);
		Vertex<Recinto> v5 = grafo.createVertex(r5);
		Vertex<Recinto> v6 = grafo.createVertex(r6);
		Vertex<Recinto> v7 = grafo.createVertex(r7);
		Vertex<Recinto> v8 = grafo.createVertex(r8);
		
		grafo.connect(v1, v2, 25);
		grafo.connect(v1, v3, 15);
		grafo.connect(v1, v4, 10);
		grafo.connect(v1, v5, 20);
		grafo.connect(v2, v5, 25);
		grafo.connect(v3, v4, 8);
		grafo.connect(v4, v7, 5);
		grafo.connect(v5, v6, 10);
		grafo.connect(v6, v7, 10);
		grafo.connect(v7, v8, 15);
		
		Parcial p = new Parcial();
		int tiempo = 100;
		System.out.println("Test 1: ");
		System.out.println("Tiempo = " + tiempo);
		System.out.println(p.resolver(grafo,tiempo) + " = 5");
		System.out.println("------");
		tiempo = 30;
		System.out.println("Test 2: ");
		System.out.println("Tiempo = " + tiempo);
		System.out.println(p.resolver(grafo,tiempo) + " = 1");
	}

}
