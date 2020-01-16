/*
* Author Tran Ngoc Hoi
* Xtel Company
* 16/1/2020
*
*/


package com.xtel.runServer;

import com.xtel.model.ListUser;
import com.xtel.model.MsQueue;
import com.xtel.threadSocket.ThreadSocket;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    ServerSocket server ;
    MsQueue messageReceive;
    ListUser list;
    public Server(ServerSocket server, MsQueue mainMessageQueue,ListUser list) {
        this.server = server;
        this.messageReceive = mainMessageQueue;
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("-----------------------------");
        System.out.println("Server is running ..........");
        while (true){
            try {
                Socket socket = server.accept();
                System.out.println("Connect to client : "+ socket.getInetAddress().toString()+" At port : "+ socket.getPort());
                String name = new DataInputStream(socket.getInputStream()).readUTF();
                ThreadSocket thSocket = new ThreadSocket(socket,messageReceive, name);
                list.addToList(thSocket);
                thSocket.start();
            }catch (Exception e){

            }

        }
    }
}
