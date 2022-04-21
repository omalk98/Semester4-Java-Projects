package com.lab4.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * Handles window events and displays output
 * <ul>
 * <li>Workshop 4</li>
 * <li>Course: BTN415</li>
 * <li>Last Name: Hussein</li>
 * <li>First Name: Omar</li>
 * <li>ID: 118073204</li>
 * <li>Section: NBB</li>
 * <li>This assignment represents my own work in accordance with Seneca Academic Policy.</li>
 * <li>Signature OmarHussein</li>
 * <li>Date: 5/Apr/2022</li>
 * </ul>
 */
public class ClientController {

    private static String username = "";

    /**
     * Current Client
     */
    public static Client client;

    @FXML
    private TextArea input_field;

    @FXML
    private ListView<String> message_area;

    @FXML
    private Label username_field;

    /**
     * Initialize scene
     */
    @FXML
    void initialize() {
        try {
            client = new Client("localhost", 6000);
            client.receiveMessages(message_area);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message_area.getItems().add("Enter Your Name and Click \"Send\": ");
    }

    /**
     * Handler function for message sending
     * @param event unused
     */
    @FXML
    void sendMessage(ActionEvent event) {
        String input = input_field.getText();
        if (input.isBlank()) return;
        if(input.equals(".quit")) {
            client.closeAll();
            return;
        }

        message_area.getItems().add("You: " + input);
        client.sendMessage(input);

        if (username.isBlank()) {
            username = input;
            ClientApp.changeTitle(username);
            username_field.setText(username.toUpperCase());
            message_area.getItems().add("Your Username is Set to: " + username);
        }

        input_field.clear();
    }

    /**
     * Add message to view box
     * @param message message
     * @param msg_area message box
     */
    public static void addMessage(String message, ListView<String> msg_area) {
        Platform.runLater(() -> {
            msg_area.getItems().add(message);
        });
    }

}
