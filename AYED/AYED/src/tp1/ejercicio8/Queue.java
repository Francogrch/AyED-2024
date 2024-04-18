package tp1.ejercicio8;

import java.util.List;
import java.util.ArrayList;

public class Queue<T> {
    protected List<T> data;

    public Queue() {
        // TODO Auto-generated constructor stub
        data = new ArrayList<T>();
    }

    public void enqueue(T dato) {
        data.add(dato);
    }

    public T dequeue() {
        T pri = data.get(0);
        data.remove(0);
        return pri;

    }

    public T head() {
        return data.get(0);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    @Override
    public String toString() {
        String out = "";
        for (T d : data) {
            out += d.toString() + " ";
        }
        return out;
    }
}
