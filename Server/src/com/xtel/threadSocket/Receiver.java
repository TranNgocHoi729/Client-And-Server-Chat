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

public class Receiver extends Thread {
    Socket socket;
    MsQueue messageReceive;
    String name;

    public Receiver(Socket socket, MsQueue msQueue, String name) {
        this.socket = socket;
        this.messageReceive = msQueue;
        this.name = name;
    }
/*
*   This thread is use to read Message and name of targetUser this message wanna sends
*   Data sends by User Status
* */

    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dIn = new DataInputStream(socket.getInputStream());
                String userTarget = dIn.readUTF();
                String mess = dIn.readUTF();
                User user = new User(name, mess, userTarget);
                System.out.println("user "+ name+ " send message to user "+userTarget+" : "+ mess);
                messageReceive.addToMsQueue(user);
            } catch (Exception e) {

            }

        }
    }
}
