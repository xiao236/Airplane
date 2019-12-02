import java.io.IOException;
import java.io.*;
import java.net.*;

public class ReservationServer {
    public static void main(String[] args) throws IOException {
        String[] listofpassenger=null;
        Alaska a = new Alaska();
        Delta d = new Delta();
        Southwest s = new Southwest();

        BufferedReader br = new BufferedReader(new FileReader("reservations.txt"));
        int[] howManyPassengers = new int[2];
        br.readLine();
        String next = br.readLine();
        String[] hold = next.split("/");
        for (int i = 0; i < 2; i ++) {
            howManyPassengers[i] = Integer.parseInt(hold[i]);
        }
        br.readLine();
        br.readLine();
        for (int i = 0; i < howManyPassengers[0]; i++) {
            next = br.readLine();
            hold = next.split(" ");
            Passenger p = new Passenger(hold[0], hold[1].substring(0, hold[1].length()-1), Integer.parseInt(hold[2]));
            a.addPassenger(p);
            br.readLine();
        }
        br.readLine();
        br.readLine();
        next = br.readLine();
        hold = next.split("/");
        for (int i = 0; i < 2; i ++) {
            howManyPassengers[i] = Integer.parseInt(hold[i]);
        }


        ServerSocket serverSocket = new ServerSocket(4242);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.flush();

        while(true){
            String yes = reader.readLine();

            switch (yes){
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
