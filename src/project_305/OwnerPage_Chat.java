/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author shahad
 */
public class OwnerPage_Chat extends javax.swing.JFrame {

    int port = 0;
    static ServerSocket server = null;
    static Socket client = null;
    ExecutorService pool = null;
    static int clientcount = 0;

    static DataOutputStream dos;
    static DataInputStream dis;

    public OwnerPage_Chat() {
        initComponents();
        setLocationRelativeTo(null);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        txt = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 610, 35, 35);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 610, 36, 40);

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 610, 37, 38);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(240, 610, 40, 30);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 50, 30);

        txt_area.setColumns(20);
        txt_area.setRows(5);
        jScrollPane2.setViewportView(txt_area);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 220, 240, 210);
        jPanel1.add(txt);
        txt.setBounds(50, 450, 200, 30);

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        jPanel1.add(send);
        send.setBounds(100, 500, 67, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_305/‏‏chat_O.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 300, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        OwnerPage_Home ob = new OwnerPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        OwnerPage_ViewReq ob = new OwnerPage_ViewReq();
        ob.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        OwnerPage_Comment ob = new OwnerPage_Comment();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        OwnerPage_Profile ob = null;
        try {
            ob = new OwnerPage_Profile();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // BBAACCCCKKKKKK
        OwnerPage_ViewReq ob = new OwnerPage_ViewReq();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:

//        try {
//            String msg = "";
//            dos = new DataOutputStream(client.getOutputStream());
//            msg = txt.getText();
//            dos.writeUTF(msg);
//        }   catch (IOException e) {
//                Logger.getLogger(OwnerPage_Chat.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
        
//        try {
//
//            String msg = txt.getText();
//            dos.writeUTF(msg);
//            txt_area.setText(txt_area.getText() + "\r\nMe: " + msg);
//
//            txt.setText("");
//
//        } catch (IOException ex) {
//            Logger.getLogger(OwnerPage_Chat.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_sendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OwnerPage_Chat().setVisible(true);

            }
        });

        OwnerPage_Chat serverobj = new OwnerPage_Chat(5000);
        serverobj.startServer();

    }

//    OwnerPage_Chat(int port) {
//        this.port = port;
//        pool = Executors.newFixedThreadPool(5);
//    }
//
//    public void startServer() throws IOException {
//
//        server = new ServerSocket(5000);
//        //     msgArea.setText("Server Booted");
////        msgArea.setText("Any client can stop the server by sending -1");
//        while (true) {
//            client = server.accept();
//            clientcount++;
//            ServerThread runnable = new ServerThread(client, clientcount, this);
//            pool.execute(runnable);
//        }
//
//    }
//    private static class ServerThread implements Runnable {
//
//        OwnerPage_Chat server;
//        Socket client;
//
//        int id;
//        String s;
//
//        ServerThread(Socket client, int count, OwnerPage_Chat server) throws IOException {
//
//            this.client = client;
//            this.server = server;
//            this.id = count;
//
//            msgArea.setText("Connection " + id + "established with client " + client);
//            
//            dis = new DataInputStream(client.getInputStream());
//            dos = new DataOutputStream(client.getOutputStream());
//        }
//
//        @Override
//        public void run() {
//            int x = 1;
//            try {
//                while (true) {
//                    s = dis.readUTF();
//
//                    msgArea.setText(msgArea.getText() + " Client(" + id + ") :" + s + "\n");
//                    msgArea.setText("Server : ");
//                    //s=stdin.readLine();
////                    s = SendingMsg.getText();
//                //    s = dis.readUTF();
//                    if (s.equalsIgnoreCase("bye")) {
//                        dos.writeUTF("BYE");
//                        x = 0;
//                        msgArea.setText("Connection ended by server");
//                        break;
//                    }
//                    dos.writeUTF(s);
//                }
//
//                dis.close();
//                client.close();
//                dos.close();
//                if (x == 0) {
//                    System.out.println("Server cleaning up.");
//                    System.exit(0);
//                }
//            } catch (IOException ex) {
//                System.out.println("Error : " + ex);
//            }
//
//        }
//    }
    OwnerPage_Chat(int port) {
        this.port = port;
        pool = Executors.newFixedThreadPool(5);
    }

    public void startServer() throws IOException {
        server = new ServerSocket(5000);

        while (true) {
            client = server.accept();
            clientcount++;
            ServerThread runnable = new ServerThread(client, clientcount, this);
            pool.execute(runnable);
        }
    }

    static class ServerThread extends Thread {

        OwnerPage_Chat server = null;
        Socket client = null;

        int id;
        String s = "";

        ServerThread(Socket client, int count, OwnerPage_Chat server) throws IOException {

            this.client = client;
            this.server = server;
            this.id = count;
            // msgArea.setText("Connection " + id + "established with client " + client);

            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());

        }

        @Override
        public void run() {
            try {
                while (!s.equalsIgnoreCase("bye")) {
                    s = dis.readUTF();

                    txt_area.setText(txt.getText().trim() + "\n " + s);
                }

                dis.close();
                client.close();
                dos.close();
            } catch (Exception ex) {
                int x = 0;
                System.out.println("Error : " + ex);

            }
        }
    }
    
//        ServerSocket s = new ServerSocket(1201);
//        System.out.println("Server waiting Connection...");
//
//        while (true) {
//            client = s.accept();
//            MyThread m = new MyThread(client);
//            m.start();
//        }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JButton send;
    public static javax.swing.JTextField txt;
    private static javax.swing.JTextArea txt_area;
    // End of variables declaration//GEN-END:variables
}

//class MyThread extends Thread {
//
//    static ServerSocket serverSocket;
//    static Socket socket;
//    static DataInputStream dis;
//    static DataOutputStream dos;
//
//    public MyThread(Socket soc) {
//        this.socket = soc;
//    }
//
//    @Override
//    public void run() {
//
//        String msgin = "";
//
//        try {
//
//            dis = new DataInputStream(socket.getInputStream());
//            dos = new DataOutputStream(socket.getOutputStream());
//            while (!msgin.equalsIgnoreCase("Bye")) {
//                msgin = dis.readUTF();
//                OwnerPage_Chat.msgArea.setText(OwnerPage_Chat.msgArea.getText() + "\n" + msgin);
//            }
//            socket.close();
//        } catch (Exception ex) {
//            Logger.getLogger(OwnerPage_Chat.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//}
