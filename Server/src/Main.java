import com.xtel.model.ListUser;
import com.xtel.model.MsQueue;
import com.xtel.runServer.Server;
import com.xtel.runServer.distributionMessage;

import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            MsQueue mainMsQueue = new MsQueue();
            ServerSocket server = new ServerSocket(9999);
            ListUser listUser = new ListUser();
            Server serverHandle = new Server(server,mainMsQueue,listUser);
            distributionMessage dbM = new distributionMessage(listUser,mainMsQueue);
            serverHandle.start();
            dbM.start();
        }catch (Exception e){

        }

    }
}
