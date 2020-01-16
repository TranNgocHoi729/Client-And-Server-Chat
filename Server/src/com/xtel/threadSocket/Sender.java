/*
 * Author Tran Ngoc Hoi
 * Xtel Company
 * 16/1/2020
 *
 */
package com.xtel.threadSocket;

import com.xtel.model.MsQueue;
import com.xtel.model.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sender extends Thread{
    Socket socket;
    MsQueue msQueue;
    String name;

    public Sender(Socket socket, MsQueue msQueue, String name) {
        this.socket = socket;
        this.msQueue = msQueue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            try {
                DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
                if(msQueue.checkEmpty()){
                   continue;
                }
                User user = msQueue.getFirst();
                String mess = user.getName()+" say : "+ user.getMessage();
                dOut.writeUTF(mess);
            }catch (Exception e){

                e.printStackTrace();
            }
        }

    }
}
