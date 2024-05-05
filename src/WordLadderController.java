import java.util.*;

public class WordLadderController {
    public static SearchResult findPath(String startWord, String endWord, Set<String> dictionary, String algorithm) {
        Runtime runtime = Runtime.getRuntime();

        // Memanggil garbage collector untuk membersihkan sebelum pengukuran
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        SearchResult result;
        switch (algorithm.toLowerCase()) {
            case "ucs":
                result = UCS1.findPath(startWord, endWord, dictionary);
                break;
            case "gbfs":
                result = GBFS1.findPath(startWord, endWord, dictionary);
                break;
            case "astar":
                result = AStar.findPath(startWord, endWord, dictionary);
                break;
            default:
                result = new SearchResult(null, 0);
        }

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;

        System.out.println("Memory used by " + algorithm.toUpperCase() + " algorithm: " + memoryUsed + " bytes");

        return result;
    }
}
