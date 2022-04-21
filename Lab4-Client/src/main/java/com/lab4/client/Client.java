package com.lab4.client;

import javafx.scene.control.ListView;

import java.io.*;
import java.net.Socket;

/**
 * Handles Client requests and server communication
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
public class Client {
    private Socket socket;
    private BufferedWriter output;
    private BufferedReader input;

    /**
     * Instantiate a Client instance with the specified host and port connections
     * @param host host address
     * @param port post
     */
    Client(String host, Integer port) {
        try {
            socket = new Socket(host, port);
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e) {
            System.out.println("Error creating Socket (Server possibly Down)");
            e.printStackTrace();
        }
    }

    /**
     * Create thread to receive messages and update lively as they come in
     * @param msg_area message box
     */
    public void receiveMessages(ListView<String> msg_area) {
        new Thread(()->{
           while (socket.isConnected()){
               try {
                   String serverMsg = input.readLine();
                   if(serverMsg == null) break;
                   ClientController.addMessage(serverMsg, msg_area);
               }
               catch (IOException e) {
                   System.out.println("Error receiving Messages from Server");
                   e.printStackTrace();
                   closeAll();
                   break;
               }
           }
        }).start();
    }

    /**
     * Send message to server to Broadcast
     * @param msg message to send
     */
    public void sendMessage(String msg) {
        try {
            output.write(msg);
            output.newLine();
            output.flush();
        }
        catch (IOException e) {
            System.out.println("Error sending Message to Server");
            e.printStackTrace();
        }
    }

    /**
     * Close down connection to server and exit
     */
    public void closeAll() {
        try {
            output.write(".quit");
            output.newLine();
            output.flush();

            if(input != null) input.close();
            if(output != null) output.close();
            if(socket != null) socket.close();
            ClientApp.stage.close();
        }
        catch (IOException e) {
            System.out.println("Error Closing down Socket");
            e.printStackTrace();
        }
    }
}
