package com.lab4.server;

import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Handles Server requests and sets up main communication channel for Clients
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
public class Server{

    private ServerSocket serverSocket;

    /**
     * Create Server socket
     * @param port port
     */
    public Server(Integer port){
        try {
            serverSocket = new ServerSocket(port);
        }
        catch (IOException e) {
            System.out.println("Error cannot Create Socket");
            e.printStackTrace();
        }
    }

    /**
     * Start Client handler thread for Server
     * @param message_area message box
     */
    public void startServer(ListView<String> message_area) {
        new Thread(()-> {
            try {
                while (!serverSocket.isClosed()) {
                    Socket socket = serverSocket.accept();
                    Thread tHandler = new Thread(new ServerCommunicator(socket, message_area));
                    tHandler.start();
                }
            } catch (IOException e) {
                System.out.println("Error: Server unable to Create Thread");
                closeServer();
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Close Server Connections
     */
    public void closeServer() {
        try {
            if (serverSocket != null) serverSocket.close();
        }
        catch (IOException e) {
            System.out.println("Error: Server Failed to close");
            e.printStackTrace();
        }
    }

    /**
     * Broadcast message from Server to all online Clients
     * @param msg message to send
     */
    public void broadcastMessage(String msg) {
        for (ServerCommunicator sc : ServerCommunicator.clientList)
            sc.sendMessage(msg);
    }
}
