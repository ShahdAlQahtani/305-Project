package project_305;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author shood
 *
 */
public class Server {
    public static String ip = "127.0.0.1";
    public static int portNumber = 8800;
}

class ServerThread extends Thread {

    OwnerPage_Chat OwnerChat;
    ServerSocket serverSocket;
    Socket socket;
  
    DataOutputStream dos;
    DataInputStream dis;

    public ServerThread(OwnerPage_Chat chat) throws IOException {
        this.OwnerChat = chat;
        serverSocket = new ServerSocket(Customer.portNumber);   
        start(); //start thread 
    }

    @Override
    public void run() {
        while (true) {

            try {
                socket = serverSocket.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                ReceiverThread rt = new ReceiverThread(OwnerChat, dis, dos, socket);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    //Method called whenever Server write message and clicks on send button on forum
    public void send(String message) throws IOException {

        dos.writeUTF(message);
    }
}

//Thread class responsible for recieving from multiple clients 
class ReceiverThread extends Thread {

    OwnerPage_Chat OwnerChat;
    DataOutputStream dos;
    DataInputStream dis;
    Socket socket;

    ReceiverThread(OwnerPage_Chat OwnerChat, DataInputStream dis, DataOutputStream dos, Socket socket) {

        this.OwnerChat = OwnerChat;
        this.dis = dis;
        this.dos = dos;
        this.socket = socket;
        start();
    }

    @Override
    public void run() {

        while (true) {
            try {

                String str = dis.readUTF();
                OwnerChat.txt_area.append("Client: "+ str + "\n");
                if (str.trim().equalsIgnoreCase("BYE")) {
                    break;
                }

            } catch (IOException ex) {
                ex.getMessage();
            }
        }

        try {
            // close the socket and I/O Streams
            socket.close();
            dis.close();
            dos.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
