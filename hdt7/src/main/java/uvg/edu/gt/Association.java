package uvg.edu.gt;
/**
 * Clase Association
 * Fernando Rueda - 23748
 * Esta clase representa una asociación entre dos objetos, donde uno actúa como clave (key) y el otro como valor (value). 
 * @param <K> El tipo de la clave.
 * @param <V> El tipo del valor.
 */
public class Association<K, V> {
    private K key;
    private V value;

    /**
     * Constructor que inicializa una asociación con una clave y un valor específicos.
     * 
     * @param key La clave de la asociación.
     * @param value El valor asociado a la clave.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Devuelve la clave de la asociación.
     * 
     * @return La clave de la asociación.
     */    
    public K getKey() {
        return key;
    }

    /**
     * Devuelve el valor de la asociación.
     * 
     * @return El valor de la asociación.
     */
    public V getValue() {
        return value;
    }
    
    /**
     * Retorna una representación en forma de cadena de la asociación.
     * 
     * @return Una cadena que representa la asociación.
     */
    @Override
    public String toString() {
        return "(" + key + " " + value + ")";
    }
}
