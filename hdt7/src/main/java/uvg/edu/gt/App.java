package uvg.edu.gt;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        BinaryTree<String> dictionary = new BinaryTree<>();
        loadDictionary("hdt7\\src\\main\\resources\\diccionario.txt", dictionary);
        translateText("hdt7\\src\\main\\resources\\texto.txt", dictionary);
    }

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
