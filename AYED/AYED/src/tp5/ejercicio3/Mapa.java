package tp5.ejercicio3;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> g) {
        mapaCiudades = g;
    }

    private boolean devolverCamino_r(Vertex<String> c1, Vertex<String> c2, List<String> camino, boolean[] visite) {
        if (c1.equals(c2)) {
            camino.add(c1.getData());
            return true;
        } else {
            visite[c1.getPosition()] = true;
            Iterator<Edge<String>> it = mapaCiudades.getEdges(c1).iterator();
            boolean seguir = false;
            while (it.hasNext() && !seguir) {
                Edge<String> actual = it.next();
                if (!visite[actual.getTarget().getPosition()]) {
                    seguir = devolverCamino_r(actual.getTarget(), c2, camino, visite);
                }
            }
            if (seguir) {
                camino.addFirst(c1.getData());
            }
            return seguir;

        }

    }

    public List<String> devolverCamino(String c1, String c2) {
        List<String> camino = new ArrayList<String>();
        if (mapaCiudades.getSize() != 0 && mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null) {
            boolean[] visite = new boolean[mapaCiudades.getSize()];
            for (boolean e : visite) {
                e = false;
            }
            devolverCamino_r(mapaCiudades.search(c1), mapaCiudades.search(c2), camino, visite);
        }
        return camino;
    }

    private boolean devolverCaminoExceptuando_r(Vertex<String> c1, Vertex<String> c2, List<String> ciudades, List<String> camino, boolean[] visite) {
        if (c1.equals(c2)) {
            camino.addFirst(c1.getData());
            return true;
        } else {
            visite[c1.getPosition()] = true;
            boolean seguir = false;
            Iterator<Edge<String>> it = mapaCiudades.getEdges(c1).iterator();
            while (it.hasNext() && !seguir) {
                Edge<String> actual = it.next();
                if (!ciudades.contains(actual.getTarget().getData()) && !visite[actual.getTarget().getPosition()]) {
                    seguir = devolverCaminoExceptuando_r(actual.getTarget(), c2, ciudades, camino, visite);
                }
            }
            if (seguir) {
                camino.addFirst(c1.getData());
            }
            return seguir;
        }


    }

    public List<String> devolverCaminoExceptuando(String c1, String c2, List<String> ciudades) {
        List<String> camino = new ArrayList<String>();
        if (mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null && mapaCiudades.getSize() != 0) {
            boolean[] visite = new boolean[mapaCiudades.getSize()];
            for (boolean e : visite) {
                e = false;
            }
            devolverCaminoExceptuando_r(mapaCiudades.search(c1), mapaCiudades.search(c2), ciudades, camino, visite);

        }
        return camino;
    }

    public void vaciar_cargar(List<Vertex<String>> a1,List<Vertex<String>> a2){
        a2.clear();
        for (Vertex<String> e: a1){
            a2.add(e);
        }
    }
    public void caminoMasCorto_r(Vertex<String> c1, Vertex<String> c2, boolean[] visite, List<Vertex<String>> camino, List<Vertex<String>> actual){
        if(c1.equals(c2)){
            if (actual.size() < camino.size()){
                vaciar_cargar(actual,camino);
            }
        }else{

            actual.add(c1);
            visite[c1.getPosition()] = true;
            for (Edge<String> e: mapaCiudades.getEdges(c1)){
                caminoMasCorto_r(e,c2,);
            }

            actual.remove(c1);
        }


    }
    public List<String> caminoMasCorto(String c1, String c2) {
        List<String> camino = new ArrayList<>();
        if (mapaCiudades.search(c1) != null && mapaCiudades.search(c2) != null) {
            boolean[] visite = new boolean[mapaCiudades.getSize()];
            for (boolean e : visite) {
                e = false;
            }
            List<Vertex<String>> actual = new ArrayList<Vertex<String>>();
            caminoMasCorto_r(mapaCiudades.search(c1),mapaCiudades.search(c2),visite,camino,actual);
            }

        }
        return camino;
    }
}
