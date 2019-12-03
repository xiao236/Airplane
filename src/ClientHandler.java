import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket socket;

    ClientHandler(Socket inSocket){
        socket = inSocket;
    }

    public void run(){
        String[] listofpassenger=null;
        Alaska a = new Alaska();
        Delta d = new Delta();
        Southwest s = new Southwest();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("reservations.txt"));
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
            br.close();


            ServerSocket serverSocket = new ServerSocket(4242);
            Socket socket = serverSocket.accept();
            System.out.println(0);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(1);
            // open BufferedWriter to send messages to  the server.
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.flush();


            out.write(d.currentPassengers + ":" + d.maxPassengers + ":" + d.retrieve() + ":" + a.currentPassengers + ":" + a.maxPassengers + ":" + a.retrieve() + ":"
                    + s.currentPassengers + ":" + s.maxPassengers + ":" + s.retrieve());
            out.newLine();
            out.flush();

            String airline = in.readLine();
            String passengerInfo = in.readLine();
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
