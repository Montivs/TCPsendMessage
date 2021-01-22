package util;
import server.TCPServer;
import client.TCPClient;

import java.io.IOException;
public class start {

    public static void main(String []args) throws IOException, InterruptedException {

        if(args.length == 2){
            TCPClient.main(args);
            return;
        }
        TCPServer.main(args);


        //FUNKTIONIERT
    }
}
