/*
 * Author Tran Ngoc Hoi
 * Xtel Company
 * 16/1/2020
 *
 */
package com.xtel.model;

import java.util.concurrent.LinkedBlockingQueue;

public class MsQueue {
    LinkedBlockingQueue<User> msQueue;

    public MsQueue() {
        this.msQueue = new LinkedBlockingQueue<>();
    }


    public synchronized int sizeOfQueue() {
        return msQueue.size();
    }

    public synchronized User getFirst() {
        return msQueue.poll();
    }

    public synchronized void addToMsQueue(User user) {
        msQueue.add(user);
        System.out.println("added : "+ user.getName() + ":"+ user.getMessage()+":"+ user.getUserTarget());
    }

    public boolean checkEmpty(){
        return msQueue.isEmpty();
    }
}
