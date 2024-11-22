package com.example.demo23;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class HelloApplication extends Application {

    // Create an ArrayList to store Person objects
    private final ArrayList<Person> persons = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane for the layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add the Banner (Placeholder for now)
        Label banner = new Label("Banner");
        gridPane.add(banner, 0, 0, 3, 1);

        // Create form labels and input fields
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        // Create the "Choose Image" button and ImageView
        Label fileChooserLabel = new Label("Select Image:");
        Button fileChooserButton = new Button("Choose Image");
        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        // FileChooser functionality
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        fileChooserButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                try {
                    // Create an image from the selected file and set it to the ImageView
                    Image image = new Image(selectedFile.toURI().toString());
                    imageView.setImage(image);

                    // Hide the button after selecting an image
                    fileChooserButton.setVisible(false);
                } catch (Exception ex) {
                    System.out.println("Failed to load image: " + ex.getMessage());
                }
            }
        });

        // Place the name text field and the "Choose Image" button side by side
        HBox nameAndImageHBox = new HBox(10, nameField, fileChooserButton);
        nameAndImageHBox.setAlignment(Pos.CENTER_LEFT);

        // Add the name field and image selector to the grid
        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameAndImageHBox, 1, 1);  // Adding HBox with name and image button in the second column
        gridPane.add(imageView, 2, 1);  // Place image view in column 2 (right side)

        // Create other form fields (e.g., Father Name, CNIC, Date, etc.)
        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherNameField = new TextField();
        gridPane.add(fatherNameLabel, 0, 2);
        gridPane.add(fatherNameField, 1, 2);

        Label cnicLabel = new Label("CNIC:");
        TextField cnicField = new TextField();
        gridPane.add(cnicLabel, 0, 3);
        gridPane.add(cnicField, 1, 3);

        Label dateLabel = new Label("Date (Picker):");
        DatePicker datePicker = new DatePicker();
        gridPane.add(dateLabel, 0, 4);
        gridPane.add(datePicker, 1, 4);

        Label genderLabel = new Label("Gender:");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleButton = new RadioButton("Male");
        RadioButton femaleButton = new RadioButton("Female");
        maleButton.setToggleGroup(genderGroup);
        femaleButton.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, maleButton, femaleButton);
        gridPane.add(genderLabel, 0, 5);
        gridPane.add(genderBox, 1, 5);

        Label cityLabel = new Label("City:");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Karachi", "Islamabad", "Other");
        gridPane.add(cityLabel, 0, 6);
        gridPane.add(cityComboBox, 1, 6);

        // Create Save and Cancel Buttons
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        // Save Button Action
        saveButton.setOnAction(e -> {
            // Retrieve values and create a Person object
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "";
            String city = cityComboBox.getValue();

            if (name.isEmpty() || cnic.isEmpty()) {
                System.out.println("Please fill in all required fields.");
            } else {
                Person person = new Person(name, fatherName, cnic, date, gender, city);
                persons.add(person);
                // Display details in separate lines in the console
                System.out.println("Saved person details:");
                System.out.println("Name: " + person.getName());
                System.out.println("Father Name: " + person.getFatherName());
                System.out.println("CNIC: " + person.getCnic());
                System.out.println("Date: " + person.getDate());
                System.out.println("Gender: " + person.getGender());
                System.out.println("City: " + person.getCity());

                // Reset the form fields
                nameField.clear();
                fatherNameField.clear();
                cnicField.clear();
                datePicker.setValue(null);
                genderGroup.selectToggle(null);
                cityComboBox.setValue(null);
                imageView.setImage(null);  // Clear image after saving
                fileChooserButton.setVisible(true);  // Show the button again
            }
        });

        // Cancel Button Action
        cancelButton.setOnAction(e -> {
            nameField.clear();
            fatherNameField.clear();
            cnicField.clear();
            datePicker.setValue(null);
            genderGroup.selectToggle(null);
            cityComboBox.setValue(null);
            imageView.setImage(null);  // Clear image when canceling
            fileChooserButton.setVisible(true);  // Show the button again
        });

        HBox buttonBox = new HBox(10, saveButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        gridPane.add(buttonBox, 1, 8);

        // Set the scene and stage
        Scene scene = new Scene(gridPane, 700, 400);
        primaryStage.setTitle("Person Form Application with Image Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Person class to store data
    static class Person {
        private final String name;
        private final String fatherName;
        private final String cnic;
        private final String date;
        private final String gender;
        private final String city;

        public Person(String name, String fatherName, String cnic, String date, String gender, String city) {
            this.name = name;
            this.fatherName = fatherName;
            this.cnic = cnic;
            this.date = date;
            this.gender = gender;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getFatherName() {
            return fatherName;
        }

        public String getCnic() {
            return cnic;
        }

        public String getDate() {
            return date;
        }

        public String getGender() {
            return gender;
        }

        public String getCity() {
            return city;
        }
    }
}










