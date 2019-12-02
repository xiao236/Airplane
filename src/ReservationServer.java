import java.io.IOException;
import java.io.*;
import java.net.*;

public class ReservationServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
            a.preAdd(p);
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
            d.preAdd(p);
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
            s.preAdd(p);
            br.readLine();
        }


        ServerSocket serverSocket = new ServerSocket(4242);
        Socket socket = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();

        out.writeObject(d.currentPassengers);
        out.writeObject(d.maxPassengers);
        out.writeObject(d.passengers());

        out.writeObject(a.currentPassengers);
        out.writeObject(a.maxPassengers);
        out.writeObject(a.passengers());

        out.writeObject(s.currentPassengers);
        out.writeObject(s.maxPassengers);
        out.writeObject(s.passengers());

        String airline = (String)in.readObject();
        System.out.println("recieved");
        String passengerInfo = (String)in.readObject();
        String[] pass = passengerInfo.split(" ");
        Passenger p = new Passenger(pass[0], pass[1], Integer.parseInt(pass[2]));
        switch(airline) {
            case "Delta":
                d.addPassenger(p);
                break;
            case "Alaska":
                a.addPassenger(p);
                break;
            case "Southwest":
                s.addPassenger(p);
                break;
        }
        PrintWriter pw = new PrintWriter(new FileOutputStream("reservations.txt"));
        pw.println("ALASKA");
        pw.println(a.currentPassengers + "/" + a.maxPassengers);
        pw.println("Alaska passenger list");
        pw.println(a.toString());
        pw.println("DELTA");
        pw.println(d.currentPassengers + "/" + d.maxPassengers);
        pw.println("Delta passenger list");
        pw.println(d.toString());
        pw.println("SOUTHWEST");
        pw.println(s.currentPassengers + "/" + s.maxPassengers);
        pw.println("Southwest passenger list");
        pw.println(s.toString());
    }

}
