import java.util.*;

public class Main {
    public static void main(String[] args) {
        Gui.main(args);
    }

    // For running CLI

    // public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    // Set<String> dictionary = Loader.loadDictionary("dict.txt");

    // if (dictionary.isEmpty()) {
    // System.out.println("Dictionary is empty or couldn't be loaded. Exiting.");
    // scanner.close();
    // return;
    // }

    // System.out.print("Enter start word: ");
    // String startWord = scanner.nextLine().toLowerCase();
    // System.out.print("Enter end word: ");
    // String endWord = scanner.nextLine().toLowerCase();

    // if (!dictionary.contains(startWord) || !dictionary.contains(endWord)
    // || startWord.length() != endWord.length()) {
    // System.out.println("Invalid input words or word lengths are not equal.");
    // System.exit(0);
    // }
    // System.out.println(
    // "algorithm:\n 1.UCS (Uniform Cost Search)\n 2.GBFS (Greedy Best First
    // Search)\n 3.A* (Astar) ");
    // System.out.print("Select algorithm : ");
    // String algorithm = scanner.nextLine().trim().toLowerCase();

    // long algStartTime = System.currentTimeMillis();
    // SearchResult path = new SearchResult(null, 0);
    // switch (algorithm) {
    // case "1":
    // path = UCS1.findPath(startWord, endWord, dictionary);
    // break;
    // case "2":
    // path = GBFS1.findPath(startWord, endWord, dictionary);
    // break;
    // case "3":
    // path = AStar.findPath(startWord, endWord, dictionary);
    // break;
    // default:
    // System.out.println("Invalid algorithm choice");
    // System.exit(0);
    // }
    // long algExecutionTime = System.currentTimeMillis() - algStartTime;

    // if (path.getPath().isEmpty()) {
    // System.out.println("No path found between " + startWord + " and " + endWord);
    // } else {
    // List<String> pathResult =
    // path.getPath().stream().map(String::toUpperCase).toList();
    // System.out.println("Path found: " + String.join(" -> ", path.getPath()));
    // System.out.println("Node visited: " + path.getVisitedCount());
    // System.out.println("Size: " + pathResult.size());
    // }

    // System.out.println("Execution time: " + algExecutionTime + " milliseconds");
    // scanner.close();

    // }
}
