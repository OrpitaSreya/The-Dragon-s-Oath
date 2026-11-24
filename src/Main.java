import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        showMainMenu();

        stage.show();
    }

    private void showMainMenu() {

        Label title =
                new Label("🐉 DRAGON'S OATH");

        title.setStyle(
        "-fx-font-size: 32px;" +
        "-fx-font-weight: bold;"
        );

        Label nameLabel =
                new Label("Enter Player Name:");

        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter your name"
        );

        nameField.setMaxWidth(250);

        Button startButton =
                new Button("START GAME");

        Button leaderboardButton =
                new Button("LEADERBOARD");

        Button exitButton =
                new Button("EXIT");

        startButton.setPrefWidth(180);
        leaderboardButton.setPrefWidth(180);
        exitButton.setPrefWidth(180);
        
        startButton.setOnAction(event -> {

            String name =
                    nameField.getText().trim();

            if (name.isEmpty()) {

                nameLabel.setText(
                        "Please enter your name!"
                );

            } else {

                Player player =
                        new Player(name);

                new Game(stage, player);
            }
        });

        leaderboardButton.setOnAction(
                event -> showLeaderboard()
        );

        exitButton.setOnAction(
                event -> stage.close()
        );

        VBox root =
                new VBox(15);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,
                nameLabel,
                nameField,
                startButton,
                leaderboardButton,
                exitButton
        );

        Scene scene =
                new Scene(root, 600, 400);

        stage.setTitle(
                "Dragon's Oath"
        );

        stage.setScene(scene);
    }

    private void showLeaderboard() {

        Label title =
                new Label("🏆 LEADERBOARD");

        title.setStyle(
                "-fx-font-size: 25px;"
        );

        VBox list =
                new VBox(10);

        list.setAlignment(Pos.CENTER);

        Leaderboard leaderboard =
                new Leaderboard();

        ArrayList<String> players =
                leaderboard.readPlayers();

        if (players.isEmpty()) {

            list.getChildren().add(
                    new Label(
                            "No players yet!"
                    )
            );

        } else {

            for (String player : players) {

                list.getChildren().add(
                        new Label(player)
                );
            }
        }

        Button backButton =
                new Button("BACK");

        backButton.setOnAction(
                event -> showMainMenu()
        );

        list.getChildren().add(
                backButton
        );

        VBox root =
                new VBox(20);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,
                list
        );

        Scene scene =
                new Scene(root, 600, 400);

        stage.setScene(scene);
    }

    public static void main(String[] args) {

        launch(args);
    }
}