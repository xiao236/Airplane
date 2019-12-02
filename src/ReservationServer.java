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
        br.readLine();
        String next = br.readLine();
        String[] hold = next.split("/");
        a.currentPassengers = Integer.parseInt(hold[0]);
        a.maxPassengers = Integer.parseInt(hold[1]);
        br.readLine();
        for (int i = 0; i < a.currentPassengers; i++) {
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
        d.currentPassengers = Integer.parseInt(hold[0]);
        d.maxPassengers = Integer.parseInt(hold[1]);
        br.readLine();
        for (int i = 0; i < d.currentPassengers; i++) {
            next = br.readLine();
            hold = next.split(" ");
            Passenger p = new Passenger(hold[0], hold[1].substring(0, hold[1].length()-1), Integer.parseInt(hold[2]));
            d.addPassenger(p);
            br.readLine();
        }
        br.readLine();
        br.readLine();
        next = br.readLine();
        hold = next.split("/");
        s.currentPassengers = Integer.parseInt(hold[0]);
        s.maxPassengers = Integer.parseInt(hold[1]);
        br.readLine();
        for (int i = 0; i < s.currentPassengers; i++) {
            next = br.readLine();
            hold = next.split(" ");
            Passenger p = new Passenger(hold[0], hold[1].substring(0, hold[1].length()-1), Integer.parseInt(hold[2]));
            s.addPassenger(p);
            br.readLine();
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
