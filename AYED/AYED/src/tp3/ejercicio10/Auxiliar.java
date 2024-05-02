package tp3.ejercicio10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Auxiliar {
    private List<Integer> l;
    private int max;

    public Auxiliar() {
        l = new ArrayList<Integer>();
        max = 0;
    }

    public List<Integer> getL() {
        return l;
    }

    public void setL(List<Integer> l) {
        this.l = l;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
