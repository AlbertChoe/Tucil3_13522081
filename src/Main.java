import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> dictionary = Loader.loadDictionary("dict.txt");

        if (dictionary.isEmpty()) {
            System.out.println("Dictionary is empty or couldn't be loaded. Exiting.");
            scanner.close();
            return;
        }

        System.out.println("Enter start word: ");
        String startWord = scanner.nextLine().toLowerCase();
        System.out.println("Enter end word: ");
        String endWord = scanner.nextLine().toLowerCase();

        if (!dictionary.contains(startWord) || !dictionary.contains(endWord)
                || startWord.length() != endWord.length()) {
            System.out.println("Invalid input words or word lengths are not equal.");
            System.exit(0);
        }

        List<String> path = UCS1.findPath(startWord, endWord, dictionary);
        System.out.println("Path: " + path);
        System.out.println("size: " + path.size());

        List<String> pathGBFS = GBFS1.findPath(startWord, endWord, dictionary);
        System.out.println("Path (Greedy Best-First Search): " + pathGBFS);
        System.out.println("size: " + pathGBFS.size());
        List<String> pathAStar = AStar.findPath(startWord, endWord, dictionary);
        System.out.println("Path (Greedy Best-First Search): " + pathGBFS);
        System.out.println("size: " + pathAStar.size());
        scanner.close();
    }
}
