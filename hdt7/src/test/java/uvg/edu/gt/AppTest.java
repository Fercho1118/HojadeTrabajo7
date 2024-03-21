package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private BinaryTree<String> dictionary;

    @Before
    public void setUp() {
        // Inicializar el diccionario antes de cada prueba con las nuevas palabras
        dictionary = new BinaryTree<>();
        dictionary.insert(new Association<>("my", "mi"));
        dictionary.insert(new Association<>("favorite", "favorita"));
        dictionary.insert(new Association<>("food", "comida"));
        dictionary.insert(new Association<>("is", "es"));
        dictionary.insert(new Association<>("the", "la"));
        dictionary.insert(new Association<>("hamburger", "hamburguesa"));
    }

    @Test
    public void testInsertAndFind() {
        // Verificar que se puedan encontrar los elementos insertados
        assertEquals("mi", dictionary.find("my"));
        assertEquals("favorita", dictionary.find("favorite"));
        assertEquals("comida", dictionary.find("food"));
        assertEquals("es", dictionary.find("is"));
        assertEquals("la", dictionary.find("the"));
        assertEquals("hamburguesa", dictionary.find("hamburger"));
    }

    @Test
    public void testFindNonExistingElement() {
        // Buscar un elemento no existente
        assertNull(dictionary.find("cat")); // "cat" no está en el diccionario
    }
}
