import java.util.*;

public class WordLadderController {
    public static SearchResult findPath(String startWord, String endWord, Set<String> dictionary, String algorithm) {
        switch (algorithm.toLowerCase()) {
            case "ucs":
                return UCS1.findPath(startWord, endWord, dictionary);
            case "gbfs":
                return GBFS1.findPath(startWord, endWord, dictionary);
            case "astar":
                return AStar.findPath(startWord, endWord, dictionary);
            default:
                return new SearchResult(null, 0);
        }
    }
}
