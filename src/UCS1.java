import java.util.*;

public class UCS1 {
    public static List<String> findPath(String startWord, String endWord, Set<String> dictionary) {
        Queue<Node> frontier = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        Set<String> explored = new HashSet<>();
        frontier.add(new Node(startWord, null, 0));

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.getWord().equals(endWord)) {
                return constructPath(current);
            }
            explored.add(current.getWord());
            List<Node> successors = current.generateSuccessors(dictionary);
            for (Node successor : successors) {
                if (!explored.contains(successor.getWord())) {
                    frontier.add(successor);
                }
            }
        }
        return null;
    }

    private static List<String> constructPath(Node node) {
        List<String> path = new ArrayList<>();
        while (node != null) {
            path.add(0, node.getWord());
            node = node.getParent();
        }
        return path;
    }

    public static void main(String[] args) {
        String startWord = "hit";
        String endWord = "cog";
        Set<String> dictionary = Loader.loadDictionary("dict.txt");

        List<String> path = findPath(startWord, endWord, dictionary);
        if (path != null) {
            System.out.println("Path found: " + path);
        } else {
            System.out.println("No path found.");
        }
    }
}
