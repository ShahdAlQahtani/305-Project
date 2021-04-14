package project_305;

/*
 *server class 
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is the server class to apply the chatting
 *
 * @author Group1_CAR
 */
public class Server {

    // Default ip address and port number
    public static String ip = "127.0.0.1";
    public static int portNumber = 8800;
}

class ServerThread extends Thread {

    //To creat the connection , we created serverSoket to created server and soket
    OwnerPage_Chat OwnerChat;
    ServerSocket serverSocket;
    Socket socket;
    // to read messages coming from server
    DataOutputStream dos;
    DataInputStream dis;

    // This Thread class creating multiple threads of the server to allow multiple client connections  at same time
    public ServerThread(OwnerPage_Chat chat) throws IOException {
        this.OwnerChat = chat;
        serverSocket = new ServerSocket(Tenant.portNumber);//creat serverSocket with tenant potr number
        start(); //Start Thread 
    }

    @Override
    public void run() {
        while (true) {
            try {
                socket = serverSocket.accept();//Accept Socket
                dis = new DataInputStream(socket.getInputStream()); //tenant input stream
                dos = new DataOutputStream(socket.getOutputStream());//tenant output stream
                Receiver rt = new Receiver(OwnerChat, dis, dos, socket);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
// when owner clicks on send button
    public void sendMassges(String message) throws IOException {
        dos.writeUTF(message);
    }
}
//Receivering from tenant
class Receiver extends Thread {
    OwnerPage_Chat OwnerChat;
    DataOutputStream dos;
    DataInputStream dis;
    Socket socket;

    Receiver(OwnerPage_Chat OwnerChat, DataInputStream dis, DataOutputStream dos, Socket socket) {
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
                //recived massges from client
                String m = dis.readUTF();
                OwnerChat.txt_area.append("Client: " + m + "\n");
                //TO close the connection
                if (m.trim().equalsIgnoreCase("bye")) {
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
