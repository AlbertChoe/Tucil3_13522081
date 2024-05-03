import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import java.util.*;

public class Gui extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Word Ladder Solver");

        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setPadding(new Insets(10, 10, 10, 10));

        TextField startWordField = new TextField();
        TextField endWordField = new TextField();
        ComboBox<String> algorithmChoice = new ComboBox<>();
        algorithmChoice.getItems().addAll("UCS", "GBFS", "AStar");
        algorithmChoice.setValue("UCS");

        Button submitButton = new Button("Find Path");
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        VBox resultsBox = new VBox(10);
        scrollPane.setContent(resultsBox);

        Label timeLabel = new Label("Time taken: -");
        Label visitedLabel = new Label("Nodes visited: -");

        grid.add(new Label("Start Word:"), 0, 0);
        grid.add(startWordField, 1, 0);
        grid.add(new Label("End Word:"), 0, 1);
        grid.add(endWordField, 1, 1);
        grid.add(new Label("Algorithm:"), 0, 2);
        grid.add(algorithmChoice, 1, 2);
        grid.add(submitButton, 1, 3);
        grid.add(timeLabel, 0, 4);
        grid.add(visitedLabel, 1, 4);
        grid.add(scrollPane, 0, 5, 2, 1);

        submitButton.setOnAction(e -> {
            String startWord = startWordField.getText().trim().toLowerCase();
            String endWord = endWordField.getText().trim().toLowerCase();
            Set<String> dictionary = Loader.loadDictionary("src/dict.txt");
            if (dictionary.isEmpty() || !dictionary.contains(startWord) || !dictionary.contains(endWord)
                    || startWord.length() != endWord.length()) {
                resultsBox.getChildren().setAll(new Text("Invalid input or dictionary issues."));
                return;
            }

            long startTime = System.currentTimeMillis();
            SearchResult result = WordLadderController.findPath(startWord, endWord, dictionary,
                    algorithmChoice.getValue());
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;

            resultsBox.getChildren().clear();
            timeLabel.setText(String.format("Time taken: %d ms", timeTaken));
            visitedLabel.setText(String.format("Nodes visited: %d", result.getVisitedCount()));

            if (result.getPath() == null || result.getPath().isEmpty()) {
                resultsBox.getChildren().add(new Text("No path found."));
            } else {
                formatPathDisplay(result.getPath(), resultsBox);
            }
        });

        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void formatPathDisplay(List<String> path, VBox resultsBox) {
        if (path == null || path.isEmpty()) {
            return;
        }

        TextFlow initialWordFlow = createStyledTextFlow(path.get(0), "1. ");
        resultsBox.getChildren().add(initialWordFlow);

        // Iterate from the second word to highlight changes from the previous word
        for (int i = 1; i < path.size(); i++) {
            TextFlow textFlow = new TextFlow();
            textFlow.setStyle(
                    "-fx-background-color: #f4f4f4; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 2px;");

            String previousWord = path.get(i - 1);
            String currentWord = path.get(i);
            String indexText = (i + 1) + ". ";

            Text indexNode = new Text(indexText);
            indexNode.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
            textFlow.getChildren().add(indexNode);

            for (int j = 0; j < currentWord.length(); j++) {
                char currentChar = currentWord.charAt(j);
                Text textNode = new Text(String.valueOf(currentChar));
                textNode.setStyle("-fx-font-size: 14px;");

                if (j >= previousWord.length() || currentChar != previousWord.charAt(j)) {
                    textNode.setStyle("-fx-font-weight: bold; -fx-fill: red; -fx-font-size: 14px;");
                }

                textFlow.getChildren().add(textNode);
            }

            resultsBox.getChildren().add(textFlow);
        }
    }

    private TextFlow createStyledTextFlow(String word, String indexText) {
        TextFlow textFlow = new TextFlow();
        textFlow.setStyle(
                "-fx-background-color: #f4f4f4; -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 2px;");

        Text indexNode = new Text(indexText);
        indexNode.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        Text wordNode = new Text(word);
        wordNode.setStyle("-fx-font-size: 14px;");

        textFlow.getChildren().addAll(indexNode, wordNode);
        return textFlow;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
