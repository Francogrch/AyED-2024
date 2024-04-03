package tp2.ejercicio2;
public class BinaryTreePrinter {

    public static void print(BinaryTree<Integer> root) {
        printTree(root, 0);
    }

    private static void printTree(BinaryTree<Integer> node, int depth) {
        if (node == null) {
            return;
        }

        printTree(node.getRightChild(), depth + 1);

        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }

        System.out.println(node.getData());

        printTree(node.getLeftChild(), depth + 1);
    }

}



