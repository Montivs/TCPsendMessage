package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private final int port;
    public final static int PORTNUMBER = 4444;
    public final String message = "Message from Server!";

    public TCPServer(int port) {
        this.port = port;
    }

    public static void main(String[]args) throws IOException, InterruptedException {
        TCPServer tcpServer = new TCPServer(PORTNUMBER);
        tcpServer.sendMessage();

    }

    private void sendMessage() throws IOException, InterruptedException {
        ServerSocket srvSocket = new ServerSocket(this.port);
        System.out.println("server socket created");

        Socket socket = srvSocket.accept();
        System.out.println("client connection accpted");

        socket.getInputStream().read();
        System.out.println("read something");

        OutputStream os = socket.getOutputStream();
        os.write(message.getBytes());
        System.out.println("write something");

        Thread.sleep(5000);
        System.out.println("sleep");
        os.close();
        System.out.println("server closed");

    }
}
