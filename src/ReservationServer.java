import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.Arrays;

/**
 * @author Xinyi Xiao, Chiho Song
 * @version 12/02/2019
 */
public class ReservationServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket socket = new ServerSocket(0);
        System.out.printf("<Now serving clients on port %d...>%n", socket.getLocalPort());

        int i = 0;
        while (true) {
            Socket socket1 = socket.accept();
            i++;
            System.out.printf("<Client %d connected...>%n", i);
            ClientHandler c = new ClientHandler(socket1);
            Thread t = new Thread(c);
            t.start();
        }

    }

}
