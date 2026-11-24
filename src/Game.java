import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

public class Game {

    private Stage stage;
    private Player player;

    private Dragon dragon;

    private Label dragonLabel;
    private Label obstacleLabel;
    private Label scoreLabel;
    private Label messageLabel;

    private Pane gamePane;

    private double dragonY = 370;

    private double velocity = 0;

    private boolean jumping = false;

    private double obstacleX = 800;

    private Obstacle obstacle;

    private Random random = new Random();

    private AnimationTimer gameLoop;

    public Game(Stage stage, Player player) {

        this.stage = stage;
        this.player = player;

        dragon = new Dragon(player.getName());

        createGame();
    }

    private void createGame() {

        gamePane = new Pane();

        scoreLabel = new Label("Score: 0");

        scoreLabel.setStyle(
        "-fx-font-size: 18px;" +
        "-fx-font-weight: bold;"
        );

        scoreLabel.setLayoutX(700);
        scoreLabel.setLayoutY(20);

        Label playerLabel =
                new Label("Player: " + player.getName());

        playerLabel.setStyle(
        "-fx-font-size: 18px;" +
        "-fx-font-weight: bold;"
        );

        playerLabel.setLayoutX(20);
        playerLabel.setLayoutY(20);

        dragonLabel = new Label("🐉");
        dragonLabel.setStyle("-fx-font-size: 40px;");

        dragonLabel.setLayoutX(150);
        dragonLabel.setLayoutY(370);

        obstacleLabel = new Label();
        obstacleLabel.setStyle("-fx-font-size: 35px;");

        obstacleLabel.setLayoutX(800);
        obstacleLabel.setLayoutY(375);

        messageLabel = new Label();
        messageLabel.setLayoutX(350);
        messageLabel.setLayoutY(200);

        Line ground =
                new Line(0, 420, 900, 420);

        gamePane.getChildren().addAll(
                playerLabel,
                scoreLabel,
                dragonLabel,
                obstacleLabel,
                messageLabel,
                ground
        );

        createObstacle();

        Scene scene =
                new Scene(gamePane, 900, 500);

        stage.setScene(scene);

        scene.setOnKeyPressed(event -> {

            if (event.getCode() == KeyCode.SPACE) {

                jump();
            }
        });

        dragonLabel.setFocusTraversable(true);

        gameLoop = new AnimationTimer() {

            @Override
            public void handle(long now) {

                updateGame();
            }
        };

        gameLoop.start();

        stage.show();

        dragonLabel.requestFocus();
    }

    private void jump() {

        if (!jumping) {

            jumping = true;

            dragon.jump();

            velocity = -500;
        }
    }

    private void updateGame() {

        // =====================
        // Dragon movement
        // =====================

        if (jumping) {

            velocity += 1000 * 0.016;

            dragonY += velocity * 0.016;

            dragonLabel.setLayoutY(dragonY);

            if (dragonY >= 370) {

                dragonY = 370;

                velocity = 0;

                jumping = false;

                dragon.setJumping(false);

                dragonLabel.setLayoutY(370);
            }
        }

        // =====================
        // Obstacle movement
        // =====================

        obstacle.move();

        obstacleX = obstacle.getX();

        obstacleLabel.setLayoutX(obstacleX);

        // =====================
        // Score
        // =====================

        if (obstacleX < 150 && obstacleX > 100) {

            player.addScore();

            scoreLabel.setText(
                    "Score: " + player.getScore()
            );
        }

        // =====================
        // Collision
        // =====================

        if (checkCollision()) {

            gameOver(false);

            return;
        }

        // =====================
        // Egg / Winner
        // =====================

        if (player.getScore() >= 50) {

            player.findEgg();

            gameOver(true);

            return;
        }

        // =====================
        // New obstacle
        // =====================

        if (obstacleX < -50) {

            createObstacle();
        }
    }

    private boolean checkCollision() {

        double dragonBottom =
                dragonY + 40;

        double dragonLeft = 150;

        double dragonRight = 190;

        double obstacleLeft = obstacleX;

        double obstacleRight =
                obstacleX + 35;

        boolean horizontal =
                dragonRight > obstacleLeft
                && dragonLeft < obstacleRight;

        boolean vertical =
                dragonBottom > obstacle.getY();

        return horizontal && vertical;
    }

    private void createObstacle() {

        obstacleX = 800;

        int type = random.nextInt(4);

        if (type == 0) {

            obstacle =
                    new Rock(800, 375);

        } else if (type == 1) {

            obstacle =
                    new Tree(800, 365);

        } else {

            obstacle =
                    new Fire(800, 375);

        } 

        obstacleLabel.setText(
                obstacle.getSymbol()
        );

        obstacleLabel.setLayoutX(800);

        obstacleLabel.setLayoutY(
                obstacle.getY()
        );
    }

    private void gameOver(boolean winner) {

        gameLoop.stop();

        if (winner) {

            messageLabel.setText(
                    "🥚 EGG FOUND!\n\n"
                    + "🏆 YOU WIN!\n\n"
                    + "Score: "
                    + player.getScore()
            );

        } else {

            messageLabel.setText(
                    "💥 GAME OVER!\n\n"
                    + "Score: "
                    + player.getScore()
            );
        }

        Leaderboard leaderboard =
                new Leaderboard();

        leaderboard.savePlayer(player);
    }
}