/*
 * Author Tran Ngoc Hoi
 * Xtel Company
 * 16/1/2020
 *
 */
package com.xtel.model;

import com.xtel.threadSocket.ThreadSocket;

import java.util.ArrayList;

public class ListUser {
    ArrayList<ThreadSocket> listUser;

    public ListUser() {
        this.listUser = new ArrayList<>();
    }

    public synchronized void addToList(ThreadSocket thSocket) {
        listUser.add(thSocket);
    }

    public synchronized int getSize() {
        return listUser.size();
    }

    public synchronized boolean checkEmpty(){
        return listUser.isEmpty();
    }
    public ThreadSocket getSocketByName(String name) {
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getNameOfUser().equalsIgnoreCase(name) && listUser.get(i).isReady() == true) {
                return listUser.get(i);
            }
        }
        return new ThreadSocket(null,null,"none");
    }
}
