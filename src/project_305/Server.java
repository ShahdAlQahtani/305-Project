package project_305;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


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
        serverSocket = new ServerSocket(Tenant.portNumber);   
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

    
    public void send(String message) throws IOException {

        dos.writeUTF(message);
    }
}


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
            socket.close();
            dis.close();
            dos.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}