import java.util.*;

public class AStar {
    public static SearchResult findPath(String startWord, String endWord, Set<String> dictionary) {
        Queue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.getCost() + heuristic(node, endWord)));
        Set<String> visited = new HashSet<>();
        int visitedCount = 0;
        queue.add(new Node(startWord, null, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited.add(current.getWord())) {
                visitedCount++;
                if (current.getWord().equals(endWord)) {
                    return new SearchResult(constructPath(current), visitedCount);
                }
                for (Node successor : current.generateSuccessors(dictionary)) {
                    int newCost = current.getCost() + 1;
                    if (!visited.contains(successor.getWord()) || newCost < successor.getCost()) {
                        successor.setParent(current);
                        successor.setCost(newCost);
                        queue.add(successor);
                    }
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
        // Heuristic function using mismatched letters
        int mismatchCount = 0;
        for (int i = 0; i < node.getWord().length(); i++) {
            if (node.getWord().charAt(i) != endWord.charAt(i)) {
                mismatchCount++;
            }
        }
        return mismatchCount;
    }
}
