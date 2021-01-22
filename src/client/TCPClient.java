package client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient {

    private final String host;
    private final int port;
    private String irgendwas = "...";

    public TCPClient(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) throws IOException {

        String hostname = args[0];
        int portnumber = Integer.parseInt(args[1]);

        TCPClient tcpClient = new TCPClient(hostname,portnumber);
        tcpClient.receiveMessage();

    }

    private void receiveMessage() throws IOException {
        Socket socket = new Socket(this.host,this.port);
        socket.getOutputStream().write(irgendwas.getBytes());

        InputStream is = socket.getInputStream();

        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        int i = 0;

        int read = 0;
        do{
            read = is.read();
            if(read!= -1){
                boas.write(read);
            }
        }while(read != -1);
        String receivedString = new String(boas.toByteArray());
        System.out.println("Received: "+receivedString);

    }
}

