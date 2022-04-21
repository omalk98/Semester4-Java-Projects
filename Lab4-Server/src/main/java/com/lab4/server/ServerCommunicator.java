package com.lab4.server;

import javafx.scene.control.ListView;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;

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
public class ServerCommunicator implements Runnable {

    /**
     * List of current connections
     */
    public static LinkedList<ServerCommunicator> clientList = new LinkedList<>();

    private Socket socket;
    private BufferedReader input;
    private BufferedWriter output;
    private String username;
    private ListView<String> message_area;;

    /**
     * Create Client/Server communicator session
     * @param socket listening socket
     * @param message_area message box
     */
    public ServerCommunicator(Socket socket, ListView<String> message_area) {
        try {
            this.socket = socket;
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.username = this.input.readLine();
            clientList.add(this);
            Date date = new Date();
            ServerController.addMessage("SERVER: " +
                    "New Connection Established on Socket: [ADDR=/" + socket.getInetAddress() +
                    "|PORT=" + socket.getPort() +
                    "|LocalPORT=" + socket.getLocalPort() + "]\n" +
                    " at: [" + date + "]\n" +
                    "[" + username + "] has joined the chat!",
                    message_area
            );

            broadcastMessage("SERVER: " +
                    "New Connection Established on Socket: [ADDR=/" + socket.getInetAddress() +
                    "|PORT=" + socket.getPort() +
                    "|LocalPORT=" + socket.getLocalPort() + "]\n" +
                    " at: [" + date + "]\n" +
                    "[" + username + "] has joined the chat!"
            );
            this.message_area = message_area;

        } catch (IOException e) {
            System.out.println("Error: Unable to Create Thread");
            closeAll();
            e.printStackTrace();
        }
    }

    /**
     * Broadcast message to Clients but self
     * @param msgToSend message to send
     */
    private void broadcastMessage(String msgToSend) {
        for (ServerCommunicator sc : clientList) {
            try {
                if (sc.username.equals(this.username)) continue;

                sc.output.write(msgToSend);
                sc.output.newLine();
                sc.output.flush();
            } catch (IOException e) {
                closeAll();
                System.out.println("Error: Unable to Broadcast Message");
                e.printStackTrace();
            }
        }
    }

    /**
     * Send message to Current Client
     * @param msgToSend message to send
     */
    public void sendMessage(String msgToSend) {
        try {
            output.write(msgToSend);
            output.newLine();
            output.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close connection to Client and remove
     */
    public void closeAll() {
        removeClient();
        try {
            if (input != null) input.close();
            if (output != null) output.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.out.println("Error: Closing down Socket");
            e.printStackTrace();
        }
    }

    private void removeClient() {
        if(clientList.remove(this)) {
            Date date = new Date();
            broadcastMessage("SERVER: [" + username + "] has left the chat at [" + date + "]");
            ServerController.addMessage("SERVER: [" + username + "] has left the chat at [" + date + "]", message_area);
        }
    }

    /**
     * Run Server thread for Client
     */
    @Override
    public void run() {
        while (socket.isConnected()) {
            try {
                String clientMessage = input.readLine();
                if(clientMessage.equals(".quit")) {
                    closeAll();
                    break;
                }

                ServerController.addMessage(username + ": " + clientMessage, message_area);
                broadcastMessage(username + ": " + clientMessage);
            } catch (IOException e) {
                closeAll();
                System.out.println("Error: Unable to Connect to Server");
                e.printStackTrace();
                break;
            }
        }
        closeAll();
    }
}
