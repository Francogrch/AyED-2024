package tp2.ejercicio2;


import tp1.ejercicio8.Queue;

public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;


    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Preguntar antes de invocar si hasLeftChild()
     * return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Preguntar antes de invocar si hasRightChild()
     * return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty() {
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }

    public int contarHojas() {
        if (this.isLeaf()) {
            return 1;
        } else {
            int cont = 0;
            if (this.hasLeftChild()) {
                cont += this.getLeftChild().contarHojas();
            }
            if (this.hasRightChild()) {
                cont += this.getRightChild().contarHojas();
            }
            ;
            return cont;
        }
    }

    public BinaryTree<T> espejo() {

        BinaryTree<T> aux = this.getRightChild();
        this.addRightChild(this.leftChild);
        this.addLeftChild(this.rightChild);
        if (this.hasRightChild()) {
            this.getRightChild().espejo();
        }
        if (this.hasLeftChild()) {
            this.getLeftChild().espejo();
        }
        return this;
    }

    // Esto esta mal
    public void entreNiveles(int n, int m) {
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        int level = 0;
        cola.enqueue(this);
        while (!cola.isEmpty()) {
            System.out.println("Nivel: " + level);
            Queue<BinaryTree<T>> nivel = new Queue<BinaryTree<T>>();
            while (!cola.isEmpty()) {
                nivel.enqueue(cola.dequeue());
            }
            while (!nivel.isEmpty()) {
                BinaryTree<T> actual = nivel.dequeue();
                System.out.println(actual.toString());
                if (actual.hasRightChild()) {
                    cola.enqueue(actual.getRightChild());
                }
                if (actual.hasLeftChild()) {
                    cola.enqueue(actual.getLeftChild());
                }
            }

            level++;
        }

    }
}


