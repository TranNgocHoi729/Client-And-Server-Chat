/*
* Author Tran Ngoc Hoi
* Xtel Company
* 16/1/2020
* 
*/
package com.xtel.Receiver;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver extends Thread {

    Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    /*
        Read Data from Server and display it
    */
    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dIn = new DataInputStream(socket.getInputStream());
                String mess = dIn.readUTF();
                System.out.println(mess);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    socket.close();
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
