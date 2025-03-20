package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window1 extends Application {

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

        // Top section: Welcome message at top-center
        Text welcomeLabel = new Text("Hello, user! Welcome to DietPlanner!");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        welcomeLabel.setFill(Color.WHITE);
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.BLACK);
        shadow.setRadius(5);
        shadow.setOffsetX(1);
        shadow.setOffsetY(1);
        welcomeLabel.setEffect(shadow);
        root.setTop(welcomeLabel);
        BorderPane.setAlignment(welcomeLabel, Pos.CENTER);  // Align the text to the center of the window

        // Center section: Input form
        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(20));

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        TextField ageField = new TextField();
        ageField.setPromptText("Enter your age");
        TextField heightField = new TextField();
        heightField.setPromptText("Enter your height (in cm)");
        TextField weightField = new TextField();
        weightField.setPromptText("Enter your weight (in kg)");
        TextField bloodGroupField = new TextField();
        bloodGroupField.setPromptText("Enter your blood type");

        // Add labels to the formGrid
        Text nameLabel = new Text("Name:");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        nameLabel.setFill(Color.WHITE);
        nameLabel.setEffect(shadow);

        Text ageLabel = new Text("Age:");
        ageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        ageLabel.setFill(Color.WHITE);
        ageLabel.setEffect(shadow);

        Text heightLabel = new Text("Height:");
        heightLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        heightLabel.setFill(Color.WHITE);
        heightLabel.setEffect(shadow);

        Text weightLabel = new Text("Weight:");
        weightLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        weightLabel.setFill(Color.WHITE);
        weightLabel.setEffect(shadow);

        Text bloodGroupLabel = new Text("Blood Type:");
        bloodGroupLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        bloodGroupLabel.setFill(Color.WHITE);
        bloodGroupLabel.setEffect(shadow);

        formGrid.add(nameLabel, 0, 0);
        formGrid.add(nameField, 1, 0);
        formGrid.add(ageLabel, 0, 1);
        formGrid.add(ageField, 1, 1);
        formGrid.add(heightLabel, 0, 2);
        formGrid.add(heightField, 1, 2);
        formGrid.add(weightLabel, 0, 3);
        formGrid.add(weightField, 1, 3);
        formGrid.add(bloodGroupLabel, 0, 4);
        formGrid.add(bloodGroupField, 1, 4);

        root.setCenter(formGrid);

        // Bottom section: Next button
        Button nextButton = new Button("Next");
        nextButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;");
        nextButton.setOnMouseEntered(e -> nextButton.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;"));
        nextButton.setOnMouseExited(e -> nextButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;"));
        nextButton.setOnAction(e -> {
            // Retrieve values entered by the user
            String name = nameField.getText();
            String heightStr = heightField.getText();
            String weightStr = weightField.getText();
            double height = Double.parseDouble(heightStr) / 100;  // Convert height to meters
            double weight = Double.parseDouble(weightStr);

            // Open Window 2 and pass the data
            Window2 window2 = new Window2(name, height, weight);
            window2.start(new Stage());
            primaryStage.close(); // Close Window 1
        });

        HBox buttonBox = new HBox(nextButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        root.setBottom(buttonBox);

        // Scene setup
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Diet Planner - Window 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
