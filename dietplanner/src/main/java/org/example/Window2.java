package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window2 extends Application {

    private String userName;
    private double userHeight;
    private double userWeight;

    // Constructor to accept the user data from Window 1
    public Window2(String name, double height, double weight) {
        this.userName = name;
        this.userHeight = height;
        this.userWeight = weight;
    }

    @Override
    public void start(Stage primaryStage) {
        // Calculate BMI
        double bmi = userWeight / (userHeight * userHeight);
        String bmiText = String.format("%.2f", bmi); // Format BMI to 2 decimal places

        // Main layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setStyle(
                "-fx-background-image: url('file:///C:/Users/Digvi/IdeaProjects/dietplanner/pexels1.jpg'); " +
                        "-fx-background-size: cover; " +
                        "-fx-background-position: center center;"
        );

        // Top section: Updated BMI text
        Text welcomeLabel = new Text("Hello, " + userName + "! Your BMI is: " + bmiText);
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        welcomeLabel.setFill(Color.WHITE);

        // Apply a black stroke around the text (using DropShadow for stroke effect)
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.BLACK);
        shadow.setRadius(5);
        shadow.setOffsetX(1);
        shadow.setOffsetY(1);
        welcomeLabel.setEffect(shadow);

        // Center the text at the top
        BorderPane.setAlignment(welcomeLabel, Pos.TOP_CENTER);
        root.setTop(welcomeLabel);

        // Image selection based on BMI category
        Image image = null;

        // Check BMI and select the corresponding image
        if (bmi < 18.5) {
            image = new Image("file:///C:/Users/Digvi/IdeaProjects/dietplanner/underweight_needle.png"); // Replace with underweight image path
        } else if (bmi >= 18.5 && bmi < 24.9) {
            image = new Image("file:///C:/Users/Digvi/IdeaProjects/dietplanner/normal_needle.png"); // Replace with normal weight image path
        } else if (bmi >= 25) {
            image = new Image("file:///C:/Users/Digvi/IdeaProjects/dietplanner/obese_needle.png"); // Replace with obese image path
        }

        // Create ImageView and set the image based on BMI category
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); // Resize the image if necessary
        imageView.setPreserveRatio(true);
        BorderPane.setAlignment(imageView, Pos.CENTER);
        root.setCenter(imageView); // Position the image slightly below the center (on top of the center)

        // Bottom section: Button (for Window 3)
        Button nextButton = new Button("Show diet plan");
        nextButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;");
        nextButton.setOnMouseEntered(e -> nextButton.setStyle("-fx-background-color: #2e2e2e; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;"));
        nextButton.setOnMouseExited(e -> nextButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 20;"));
        nextButton.setOnAction(e -> {
            // Open Window 3
            Window3 window3 = new Window3(); // Assuming Window3 is implemented
            window3.start(new Stage());
            primaryStage.close(); // Close Window 2
        });

        HBox buttonBox = new HBox(nextButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        root.setBottom(buttonBox);

        // Scene setup
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Diet Planner - Window 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
