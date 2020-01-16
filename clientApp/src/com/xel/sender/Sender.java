/*
* Author Tran Ngoc Hoi
* Xtel Company
* 16/1/2020
* 
*/
package com.xel.sender;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sender extends Thread{
    private Socket socket;
    private String name;
    Scanner scan = new Scanner(System.in);


    public Sender(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    /*
        Enter data and send it to Server.
        Data include : Client name , message , name of client to send message
    */
    @Override
    public void run() {
        while (true) {
            try {
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                System.out.println("System is ready to send .......");
                System.out.println("To user : ");
                String name = scan.nextLine().trim();
                dOut.writeUTF(name);
                System.out.println("Enter message : ");
                String mss = scan.nextLine().trim();
                dOut.writeUTF(mss);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    socket.close();
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
