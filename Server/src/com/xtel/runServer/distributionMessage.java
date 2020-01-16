/*
 * Author Tran Ngoc Hoi
 * Xtel Company
 * 16/1/2020
 *
 */
package com.xtel.runServer;

import com.xtel.model.ListUser;
import com.xtel.model.MsQueue;
import com.xtel.model.User;
import com.xtel.threadSocket.ThreadSocket;

import java.util.ArrayList;

public class distributionMessage extends Thread {
    private ListUser allSocket;
    private MsQueue mainMsQueue;

    public distributionMessage(ListUser allSocket, MsQueue mainMsQueue) {
        this.allSocket = allSocket;
        this.mainMsQueue = mainMsQueue;
    }

    @Override
    public void run() {
        while (true) {
            if (allSocket.getSize() > 1) {
                if (!mainMsQueue.checkEmpty()) {
                    User userTaget = mainMsQueue.getFirst();
                    ThreadSocket threadSocket = null;
                    try {
                        threadSocket = allSocket.getSocketByName(userTaget.getUserTarget());
                    } catch (Exception e) {
                        continue;
                    }
                    threadSocket.addToMessSendBack(userTaget);

                }
            }
        }
    }

}
