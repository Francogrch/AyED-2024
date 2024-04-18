package tp3.ejercicio5;

import tp1.ejercicio8.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree() {

    }

    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }


    ;

    public int altura() {
        Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);
        int a = 0;
        if (this.isEmpty()) {
            return 0;
        }
        while (!cola.isEmpty()) {
            GeneralTree<T> act = cola.dequeue();
            if (act != null) {
                for (GeneralTree<T> child : act.getChildren()) {
                    cola.enqueue(child);
                }
            } else {
                if (!cola.isEmpty()) {
                    cola.enqueue(null);
                    a++;
                }
            }
        }
        return a;
    }

    public int nivel(T dato) {
        Queue<GeneralTree<T>> cola = new Queue<>();
        int cont = 0;
        cola.enqueue(this);
        cola.enqueue(null);
        boolean encontro = false;
        while ((!cola.isEmpty()) && (!encontro)) {
            GeneralTree<T> actual = cola.dequeue();
            if (actual != null) {
                if (actual.getData() == dato) {
                    encontro = true;
                } else {
                    for (GeneralTree<T> child : actual.getChildren()) {
                        cola.enqueue(child);
                    }
                }
            } else {
                if (!cola.isEmpty()) {
                    cola.enqueue(null);
                    cont++;
                }
            }
        }
        if (encontro) {
            return cont;
        } else {
            return -1;
        }
    }

    public int ancho() {
        Queue<GeneralTree<T>> cola = new Queue<>();
        int max = 0;
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            GeneralTree<T> act;
            act = cola.dequeue();
            if (act != null) {
                if (act.getChildren().size() > max) {
                    max = act.getChildren().size();
                }
                for (GeneralTree<T> child : act.getChildren()) {
                    cola.enqueue(child);
                }
            } else {
                if (!cola.isEmpty()) {
                    cola.enqueue(null);
                }
            }
        }
        return max;
    }

    public boolean esAncestro(T a, T b) {
        if (this.getData().equals(a)) {
            if (this.getData().equals(b)) {
                return true;
            }
            boolean r = false;
            for (GeneralTree<T> child : this.getChildren()) {
                if (!r) {
                    r = child.esAncestro(child.getData(), b);
                }
            }
            return r;
        } else {
            boolean r = false;
            for (GeneralTree<T> child : this.getChildren()) {
                if (!r) {
                    r = child.esAncestro(a, b);
                }
            }
            return r;
        }

    }


}