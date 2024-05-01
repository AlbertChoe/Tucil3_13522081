import java.util.*;

public class AStar {
    public static class SearchResult {
        private List<String> path;
        private int nodesVisited;

        public SearchResult(List<String> path, int nodesVisited) {
            this.path = path;
            this.nodesVisited = nodesVisited;
        }

        public List<String> getPath() {
            return path;
        }

        public int getNodesVisited() {
            return nodesVisited;
        }
    }

    public static List<String> findPath(String startWord, String endWord, Set<String> dictionary) {
        Queue<Node> frontier = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.getCost() + heuristic(node, endWord)));
        Set<String> explored = new HashSet<>();
        frontier.add(new Node(startWord, null, 0));
        int nodesVisited = 0;
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            nodesVisited++;
            if (current.getWord().equals(endWord)) {
                return constructPath(current);
            }
            explored.add(current.getWord());
            List<Node> successors = current.generateSuccessors(dictionary);
            for (Node successor : successors) {
                int newCost = current.getCost() + 1;
                if (!explored.contains(successor.getWord()) || newCost < successor.getCost()) {
                    successor.setParent(current);
                    successor.setCost(newCost);
                    frontier.add(successor);
                }
            }
        }
        return null; // No path found
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
        // A* algorithm uses a heuristic function
        // In this case, we use the number of mismatched letters as the heuristic
        int mismatchCount = 0;
        for (int i = 0; i < node.getWord().length(); i++) {
            if (node.getWord().charAt(i) != endWord.charAt(i)) {
                mismatchCount++;
            }
        }
        return mismatchCount;
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
