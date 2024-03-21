package uvg.edu.gt;

/**
 * Clase BinaryTree
 * Fernando Rueda - 23748
 * Esta clase implementa una estructura de datos de árbol binario para almacenar asociaciones de elementos.
 * Permite insertar nuevas asociaciones y buscar valores asociados a una clave específica.
 * @param <E> El tipo de elementos que se almacenan en el árbol, debe ser comparable.
 */
public class BinaryTree<E extends Comparable<E>> {
    /**
     * Clase interna Node que representa un nodo del árbol binario. Contiene una asociación
     * y referencias a los nodos hijo izquierdo y derecho.
     */
    private class Node {
        Association<E, E> association;
        Node left, right;

        /**
         * Constructor que inicializa un nodo con una asociación específica.
         * 
         * @param association La asociación a almacenar en el nodo.
         */        
        public Node(Association<E, E> association) {
            this.association = association;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    /**
     * Constructor que crea un árbol binario vacío.
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Inserta una nueva asociación en el árbol binario.
     * 
     * @param association La asociación a insertar.
     */
    public void insert(Association<E, E> association) {
        root = insertRec(root, association);
    }

    /**
     * Método recursivo privado para insertar una nueva asociación en el árbol.
     * 
     * @param root El nodo raíz del subárbol donde se insertará la asociación.
     * @param association La asociación a insertar.
     * @return El nuevo nodo raíz del subárbol después de la inserción.
     */    
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

    /**
     * Busca el valor asociado a una clave específica en el árbol binario.
     * 
     * @param key La clave cuyo valor asociado se desea encontrar.
     * @return El valor asociado a la clave, o null si la clave no existe en el árbol.
     */
    public E find(E key) {
        return findRec(root, key);
    }

    /**
     * Método para buscar el valor asociado a una clave específica.
     * 
     * @param root El nodo raíz del subárbol donde se buscará la clave.
     * @param key La clave cuyo valor asociado se desea encontrar.
     * @return El valor asociado a la clave, o null si la clave no existe en el subárbol.
     */
    private E findRec(Node root, E key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.association.getKey());
        if (cmp < 0) {
            return findRec(root.left, key);
        } else if (cmp > 0) {
            return findRec(root.right, key);
        } else {
            return root.association.getValue();
        }
    }
}
