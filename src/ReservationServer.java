import java.io.IOException;
import java.io.*;
import java.net.*;

public class ReservationServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(4242);
        while(true){
            Socket socket = serverSocket.accept();
            ClientHandler c = new ClientHandler(socket);
            Thread t = new Thread(c);
            t.start();
        }
    }
}
