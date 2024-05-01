import java.util.*;

public class UCS {

    public static Set<String> getNeighbors(String word, Set<String> dictionary) {
        Set<String> neighbors = new HashSet<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != oldChar) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (dictionary.contains(newWord)) {
                        neighbors.add(newWord);
                    }
                }
            }
            chars[i] = oldChar; 
        }
        return neighbors;
    }

    public static List<String> uniformCostSearch(String startWord, String endWord, Set<String> dictionary) {
        if (!dictionary.contains(startWord) || !dictionary.contains(endWord)) {
            return Collections.emptyList(); 
        }

        Queue<List<String>> queue = new PriorityQueue<>(Comparator.comparingInt(List::size));
        Set<String> visited = new HashSet<>();
        List<String> initialPath = new ArrayList<>();
        initialPath.add(startWord);
        queue.add(initialPath);
        visited.add(startWord);

        while (!queue.isEmpty()) {
            List<String> currentPath = queue.poll();
            String currentWord = currentPath.get(currentPath.size() - 1);

            if (currentWord.equals(endWord)) {
                return currentPath;
            }

            Set<String> neighbors = getNeighbors(currentWord, dictionary);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<String> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }

        return Collections.emptyList(); 
    }
}
