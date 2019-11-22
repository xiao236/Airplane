import java.io.IOException;
import java.io.*;
import java.net.*;

public class ReservationServer {
    public static void main(String[] args) throws IOException {
        String[] listofpassenger=null;
        ServerSocket serverSocket = new ServerSocket(4242);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();

        while(true){
            String a= reader.readLine();

            switch (a){
                case "Alaska":
                    Alaska al =new Alaska();
                    listofpassenger= al.readClient();
                    break;
                case "Delta":
                    break;
                case "Southwest":
                    break;
                default:
                    break;
            }
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(listofpassenger);

        }
    }

}
