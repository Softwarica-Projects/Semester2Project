import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // Create a vertical box as the root layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        // Username Label and TextField
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        // Password Label and PasswordField
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> login(usernameField.getText(), passwordField.getText()));

        // Add all elements to the root layout
        root.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        // Create a scene and set it to the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private void login(String username, String password) {
        // Implement your login logic here
        // You can check the username and password against your database or any authentication method
        // For this example, we'll just show a message based on the input
        if ("admin".equals(username) && "password".equals(password)) {
            showAlert("Login Successful", "Welcome, " + username);
        } else {
            showAlert("Login Failed", "Invalid username or password");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
