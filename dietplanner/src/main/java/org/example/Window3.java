package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setStyle(
                "-fx-background-image: url('file:///C:/Users/Digvi/IdeaProjects/dietplanner/pexels1.jpg'); " +
                        "-fx-background-size: cover; " +
                        "-fx-background-position: center center;"
        );

        // Center section: New message or content
        Text messageLabel = new Text("Welcome to Window 3!");
        messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        messageLabel.setFill(Color.WHITE);

        // Apply a black stroke around the text (using DropShadow for stroke effect)
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.BLACK);
        shadow.setRadius(5);
        shadow.setOffsetX(1);
        shadow.setOffsetY(1);
        messageLabel.setEffect(shadow);

        // Center the text
        root.setCenter(messageLabel);
        BorderPane.setAlignment(messageLabel, Pos.CENTER);  // Align the text to the center of the window

        // Bottom section: Button (if needed)
        Button anotherButton = new Button("Another Action");
        anotherButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;");
        anotherButton.setOnMouseEntered(e -> anotherButton.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;"));
        anotherButton.setOnMouseExited(e -> anotherButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;"));

        HBox buttonBox = new HBox(anotherButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        root.setBottom(buttonBox);

        // Scene setup
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Diet Planner - Window 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
