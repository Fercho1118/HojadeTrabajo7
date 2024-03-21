package uvg.edu.gt;

public class BinaryTree<E extends Comparable<E>> {
    private class Node {
        Association<E, E> association;
        Node left, right;

        public Node(Association<E, E> association) {
            this.association = association;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(Association<E, E> association) {
        root = insertRec(root, association);
    }

    private Node insertRec(Node root, Association<E, E> association) {
        if (root == null) {
            root = new Node(association);
            return root;
        }
        if (association.getKey().compareTo(root.association.getKey()) < 0) {
            root.left = insertRec(root.left, association);
        } else if (association.getKey().compareTo(root.association.getKey()) > 0) {
            root.right = insertRec(root.right, association);
        }
        return root;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.association);
            inOrderRec(root.right);
        }
    }
}
