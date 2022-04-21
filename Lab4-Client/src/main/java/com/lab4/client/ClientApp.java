package com.lab4.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Runs main application loop and UI
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
public class ClientApp extends Application {

    /**
     * App Window
     */
    public static Stage stage;

    /**
     * Setup Client communication page
     * @param stage app window
     * @throws IOException fxml file not found
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApp.class.getResource("client-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Client App");
        stage.setScene(scene);
        stage.setOnCloseRequest(e-> ClientController.client.closeAll());
        ClientApp.stage = stage;
        stage.show();
    }

    /**
     * Change scene title
     * @param username username
     */
    public static void changeTitle(String username){
        ClientApp.stage.setTitle("Client App - " + username);
    }

    /**
     * Launch main application
     * @param args unused
     */
    public static void main(String[] args) { launch(); }
}
