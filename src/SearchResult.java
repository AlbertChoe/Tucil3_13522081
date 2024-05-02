import java.util.*;

public class SearchResult {
    private List<String> path;
    private int visitedCount;

    public SearchResult(List<String> path, int visitedCount) {
        this.path = path;
        this.visitedCount = visitedCount;
    }

    public List<String> getPath() {
        return path;
    }

    public int getVisitedCount() {
        return visitedCount;
    }
}
