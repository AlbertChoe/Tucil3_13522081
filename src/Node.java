import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Node {
    private String word;
    private Node parent;
    private int cost;

    public Node(String word, Node parent, int cost) {
        this.word = word;
        this.parent = parent;
        this.cost = cost;
    }

    public String getWord() {
        return word;
    }

    public Node getParent() {
        return parent;
    }

    public int getCost() {
        return cost;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Node> generateSuccessors(Set<String> dictionary) {
        List<Node> successors = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originalChar = wordChars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != originalChar) {
                    wordChars[i] = c;
                    String newWord = new String(wordChars);
                    if (dictionary.contains(newWord)) {
                        successors.add(new Node(newWord, this, cost + 1));
                    }
                }
            }
            wordChars[i] = originalChar;
        }
        return successors;
    }
}
