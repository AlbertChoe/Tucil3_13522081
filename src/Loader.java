

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Loader {
    public static Set<String> loadDictionary(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return new HashSet<>(lines);
        } catch (Exception e) {
            System.err.println("Error reading dictionary file: " + e.getMessage());
            return new HashSet<>();
        }
    }

    public static void main(String[] args) {
        String filePath = "dict.txt";
        Set<String> dictionary = loadDictionary(filePath);
        System.out.println("Loaded " + dictionary.size() + " words.");
    }
}
