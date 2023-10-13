package com.front.page;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize any necessary resources
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            // Replace with your authentication endpoint URL
            String authEndpoint = "http://localhost:8080/apps/web/UserAuth/login";

            URL url = new URL(authEndpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Create a JSON payload for the request
            String jsonInputString = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                // Successful login
                messageLabel.setText("Login successful!");
            } else {
                // Failed login
                messageLabel.setText("Invalid username or password. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("An error occurred during login.");
        }
    }
}
