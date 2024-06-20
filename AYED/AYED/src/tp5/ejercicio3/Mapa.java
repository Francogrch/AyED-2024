package tp5.ejercicio3;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
            camino.addFirst(c1.getData());
        }
        return sigue;
    }

    public List<String> devolverCamino(String c1, String c2) {
        List<String> camino = new ArrayList<String>();
        if (mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null) {
            boolean[] visite = new boolean[mapaCiudades.getSize()];
            for (boolean e : visite) {
                e = false;
            }
            devolverCamino_r(mapaCiudades.search(c1), mapaCiudades.search(c2), camino, visite);
        }
        return camino;
    }


    private boolean devolverCaminoExceptuando_r(Vertex<String> c1, Vertex<String> c2, List<String> ciudades, List<String> camino, boolean[] visite) {
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
            camino.addFirst(c1.getData());
        }
        return sigue;

    }

    public List<String> devolverCaminoExceptuando(String c1, String c2, List<String> ciudades) {
        List<String> camino = new ArrayList<>();
        if (mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null) {
            boolean[] visite = new boolean[mapaCiudades.getSize()];
            for (boolean e : visite) {
                e = false;
            }
            ;
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

    public void caminoMasCorto_r(Vertex<String> c1, Vertex<String> c2, boolean[] visite, List<Vertex<String>> camino, List<Vertex<String>> actual) {

    }

    private int min_vertex(int[][] dikjstra) {
        int min = 99;
        int pos = -1;
        for (int i = 0; i < dikjstra.length; i++) {
            if (dikjstra[i][0] < min) {
                min = dikjstra[i][0];
                pos = i;
            }
        }
        return pos;
    }

    public List<String> caminoMasCorto(String c1, String c2) {
    /*Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
existe camino retorna la lista vacía. (Las rutas poseen la distancia).*/
        List<String> camino = new ArrayList<String>();
        // 0 -> distancia
        // 1 -> vertice IN
        // 2 -> conocido
        int[][] dijkstra = new int[mapaCiudades.getSize()][3];

        for (int i = 0; i < dijkstra.length; i++) {
            dijkstra[i][0] = VALOR_GRANDE;
            dijkstra[i][1] = -1;
            dijkstra[i][2] = 0;
        }
        dijkstra[mapaCiudades.search(c1).getPosition()][0] = 0;
        dijkstra[mapaCiudades.search(c1).getPosition()][1] = 0;
        List<Vertex<String>> lista = mapaCiudades.getVertices();

        for (int[] e : dijkstra) {
            int min = min_vertex(dijkstra);
            dijkstra[min][2] = 1;
            for (Edge<String> arista : mapaCiudades.getEdges(lista.get(min))) {
                int pos_actual = arista.getTarget().getPosition();
                if (dijkstra[pos_actual][2] != 0) {
                    if (dijkstra[pos_actual][0] < (dijkstra[min][0] + arista.getWeight())) {
                        dijkstra[pos_actual][0] = dijkstra[min][0] + arista.getWeight();
                        dijkstra[pos_actual][1] = min;
                    }
                }
            }
        }

        int pos_act = mapaCiudades.search(c2).getPosition();
        boolean seguir = true;
        while (seguir) {
            if (dijkstra[pos_act][0] == 0) {
                seguir = false;
                camino.add(lista.get(pos_act).getData());
            } else {
                camino.add(lista.get(pos_act).getData());
                pos_act = dijkstra[pos_act][1];
            }

        }


        return camino;
    }
}
