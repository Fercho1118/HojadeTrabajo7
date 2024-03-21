package uvg.edu.gt;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Clase App
 * Fernando Rueda - 23748
 * Clase principal que carga un diccionario y un texto desde archivos para luego traducir el texto utilizando el diccionario cargado en un árbol binario.
 */
public class App {
    /**
     * Punto de entrada principal de la aplicación. Carga el diccionario y el texto, y realiza la traducción.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main( String[] args ) {
        BinaryTree<String> dictionary = new BinaryTree<>();
        loadDictionary("hdt7\\src\\main\\resources\\diccionario.txt", dictionary);
        translateText("hdt7\\src\\main\\resources\\texto.txt", dictionary);
    }

    /**
     * Carga un diccionario desde un archivo de texto especificado y lo almacena en un árbol binario.
     * 
     * @param fileName El nombre del archivo que contiene el diccionario.
     * @param dictionary El árbol binario en el cual se almacenará el diccionario.
     */
    private static void loadDictionary(String fileName, BinaryTree<String> dictionary) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.replaceAll("[()]", "").split(" ");
                dictionary.insert(new Association<>(parts[0].toLowerCase(), parts[1]));
            }
        } catch (Exception e) {
            System.err.println("Error leyendo el diccionario: " + e.getMessage());
        }
    }

    /**
     * Lee un archivo de texto especificado, traduce cada línea utilizando el diccionario proporcionado e imprime la traducción.
     * 
     * @param fileName El nombre del archivo que contiene el texto a traducir.
     * @param dictionary El diccionario utilizado para la traducción.
     */
    private static void translateText(String fileName, BinaryTree<String> dictionary) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                translateAndPrintLine(line, dictionary);
            }
        } catch (Exception e) {
            System.err.println("Error leyendo el texto: " + e.getMessage());
        }
    }
    
    /**
     * Traduce una línea de texto utilizando el diccionario proporcionado y la imprime.
     * 
     * @param line La línea de texto a traducir.
     * @param dictionary El diccionario utilizado para la traducción.
     */
    private static void translateAndPrintLine(String line, BinaryTree<String> dictionary) {
        String[] words = line.split("\\s+");
        for (String word : words) {
            String wordLowerCase = word.toLowerCase();
            String translation = dictionary.find(wordLowerCase);
            if (translation == null) {
                System.out.print("*" + word + "* ");
            } else {
                System.out.print(translation + " ");
            }
        }
        System.out.println();
    }
}
