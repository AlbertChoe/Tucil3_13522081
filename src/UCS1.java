import java.util.*;

public class UCS1 {
    public static SearchResult findPath(String startWord, String endWord, Set<String> dictionary) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
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
                    if (!visited.contains(successor.getWord())) {
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

}
