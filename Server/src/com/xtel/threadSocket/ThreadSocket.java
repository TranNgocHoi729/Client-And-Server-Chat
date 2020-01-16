/*
 * Author Tran Ngoc Hoi
 * Xtel Company
 * 16/1/2020
 *
 */

package com.xtel.threadSocket;

import com.xtel.model.MsQueue;
import com.xtel.model.User;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * This class will be created for a new socket connect to server.
 * It provide 2 method : Receive data from client and send data to Message queue of Server
 * It create 2 queue for save and transfer message.
 */
public class ThreadSocket extends Thread {
    private Socket socket;
    private String name;
    private MsQueue messageReceive; // this queue is used to save message from Client , send it to MessageQueue of Server
    private MsQueue messageSend; // this queue is save message from MessageQueue of Server and send it back to that client
    boolean isReady = false;

    public ThreadSocket(Socket socket, MsQueue receive, String name) {
        this.name = name;
        this.socket = socket;
        messageReceive = receive;
        messageSend = new MsQueue();
    }

    @Override
    public void run() {

        Receiver receive = new Receiver(socket, messageReceive, name);
        Sender sender = new Sender(socket, messageSend, name);
        receive.start();
        sender.start();
        isReady = true;
    }

    public void addToMessSendBack(User user) {
        messageSend.addToMsQueue(user);
    }

    public boolean isReady() {
        return isReady;
    }

    public String getNameOfUser() {
        return name;
    }


}
