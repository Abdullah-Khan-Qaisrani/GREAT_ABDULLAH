package com.example.demo1;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Layout for the login screen
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        // Image for the login screen (Make sure the image is in the correct path)
        Image image = new Image("C:\\Users\\Dell\\IdeaProjects\\demo1\\src\\main\\resources\\com\\example\\demo1\\test1.jpg");  // Relative path to the image
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(200);

        // Labels and input fields for username and password
        Label userLabel = new Label("User Name:");
        TextField userNameField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Label notificationLabel = new Label();

        // Buttons for login and exit
        Button loginButton = new Button("Login");
        Button exitButton = new Button("Exit");

        // Add components to the layout grid
        grid.add(imageView, 0, 0, 2, 1);
        grid.add(userLabel, 0, 1);
        grid.add(userNameField, 1, 1);
        grid.add(passLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(loginButton, 0, 3);
        grid.add(exitButton, 1, 3);
        grid.add(notificationLabel, 0, 4, 2, 1);

        // Login button action handler
        loginButton.setOnAction(e -> {
            String username = userNameField.getText();
            String password = passwordField.getText();
            if (username.equals("abdullah") && password.equals("123")) {
                notificationLabel.setText("Welcome Abdullah!");
                showWelcomeWindow("Abdullah");
            } else if (username.equals("ahmad") && password.equals("234")) {
                notificationLabel.setText("Welcome Ahmad!");
                showWelcomeWindow("Ahmad");
            } else if (username.equals("COMSAT") && password.equals("cui")) {
                notificationLabel.setText("Welcome COMSAT!");
                showWelcomeWindow("COMSAT");
            } else {
                notificationLabel.setText("Invalid username or password.");
            }
        });

        // Exit button action handler
        exitButton.setOnAction(e -> primaryStage.close());

        // Set the scene and show the login window
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }

    // Method to show the welcome window after successful login
    private void showWelcomeWindow(String username) {
        Stage welcomeStage = new Stage();
        Label welcomeLabel = new Label("Hello, " + username + "!");
        Scene scene = new Scene(welcomeLabel, 200, 100);
        welcomeStage.setScene(scene);
        welcomeStage.setTitle("Welcome");
        welcomeStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
