import java.util.*;

public class GBFS1 {
    public static SearchResult findPath(String startWord, String endWord, Set<String> dictionary) {
        if (startWord.equals(endWord)) {
            return new SearchResult(null, 0);
        }
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> heuristic(node, endWord)));
        Set<String> visited = new HashSet<>();
        int visitedCount = 0;
        queue.add(new Node(startWord, null, 0));
        visited.add(startWord);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.getWord().equals(endWord)) {
                return new SearchResult(constructPath(current), visitedCount);
            }

            visitedCount++;
            List<Node> successors = current.generateSuccessors(dictionary);
            for (Node successor : successors) {
                if (!visited.contains(successor.getWord())) {
                    visited.add(successor.getWord());
                    queue.add(successor);

                }
            }
        }
        return new SearchResult(null, visitedCount); // No path found
    }

    private static List<String> constructPath(Node node) {
        List<String> path = new ArrayList<>();
        while (node != null) {
            path.add(0, node.getWord());
            node = node.getParent();
        }
        return path;
    }

    private static int heuristic(Node node, String endWord) {
        int mismatchCount = 0;
        for (int i = 0; i < node.getWord().length(); i++) {
            if (node.getWord().charAt(i) != endWord.charAt(i)) {
                mismatchCount++;
            }
        }
        return mismatchCount;
    }

}
