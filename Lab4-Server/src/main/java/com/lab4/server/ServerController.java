package com.lab4.server;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class ServerController {

    private Server server;

    @FXML
    private TextArea input_field;

    @FXML
    private ListView<String> message_area;

    /**
     * Initialize scene
     */
    @FXML
    void initialize() {
        try {
            server = new Server(6000);
            server.startServer(message_area);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler function for message broadcasting
     * @param event unused
     */
    @FXML
    void sendMessage(ActionEvent event) {
        String input = input_field.getText();
        if (input.isBlank()) return;

        message_area.getItems().add("SERVER: " + input);
        server.broadcastMessage("SERVER: " + input);
        input_field.clear();
    }

    /**
     * Add message to Server log
     * @param message message
     * @param msg_area message box
     */
    public static void addMessage(String message, ListView<String> msg_area) {
        Platform.runLater(() -> {
            msg_area.getItems().add(message);
        });
    }
}
