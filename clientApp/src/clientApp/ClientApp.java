/*
 * Author Tran Ngoc Hoi
 * Xtel Company
 * 16/1/2020
 *
 */
package clientApp;

import com.xel.sender.Sender;
import com.xtel.Receiver.Receiver;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ClientApp {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.190",9999);
            System.out.println("Client is Running...........");
            System.out.println("Enter your name : ");
            String name = new Scanner(System.in).nextLine().trim();
            new DataOutputStream(socket.getOutputStream()).writeUTF(name);
            Sender sender = new Sender(socket,name);
            Receiver receiver = new Receiver(socket);
            sender.start();
            receiver.start();
        }catch (Exception e){
            return;
        }
    }
    
}
