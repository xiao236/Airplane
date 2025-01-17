import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Xinyi Xiao, Chiho Song
 * @version 12/02/2019
 */
public class ClientHandler implements Runnable {
    Socket socket;

    ClientHandler(Socket inSocket) {
        socket = inSocket;
    }

    public void run() {
        String[] listofpassenger = null;
        Alaska a = new Alaska();
        Delta d = new Delta();
        Southwest s = new Southwest();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("reservations.txt"));
            br.readLine();
            String next = br.readLine();
            BoardingPass bp;
            String[] hold = next.split("/");
            a.currentPassengers = Integer.parseInt(hold[0]);
            a.maxPassengers = Integer.parseInt(hold[1]);
            br.readLine();
            for (int i = 0; i < a.currentPassengers; i++) {
                next = br.readLine();
                hold = next.split(" ");
                Passenger p = new Passenger(hold[0], hold[1].substring(0, hold[1].length() - 1),
                        Integer.parseInt(hold[2]));
                bp = new BoardingPass("Alaska", p.getFirstName(), p.getLastName(), p.getAge(), a.getGate());
                p.setBoardingPass(bp);
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
                Passenger p = new Passenger(hold[0], hold[1].substring(0, hold[1].length() - 1),
                        Integer.parseInt(hold[2]));
                bp = new BoardingPass("Delta", p.getFirstName(), p.getLastName(), p.getAge(), d.getGate());
                p.setBoardingPass(bp);
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
                Passenger p = new Passenger(hold[0], hold[1].substring(0, hold[1].length() - 1),
                        Integer.parseInt(hold[2]));
                bp = new BoardingPass("Delta", p.getFirstName(), p.getLastName(), p.getAge(), s.getGate());
                p.setBoardingPass(bp);
                s.preAdd(p);
                br.readLine();
            }
            br.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.flush();

            out.write(d.currentPassengers + ":" + d.maxPassengers + ":" + d.retrieve() + ":" + a.currentPassengers
                    + ":" + a.maxPassengers + ":" + a.retrieve() + ":"
                    + s.currentPassengers + ":" + s.maxPassengers + ":" + s.retrieve());
            out.newLine();
            out.flush();


            String airline = in.readLine();
            String passengerInfo = in.readLine();
            String[] pass = passengerInfo.split(" ");
            Passenger p = new Passenger(pass[0], pass[1], Integer.parseInt(pass[2]));
            switch (airline) {
                case "Delta":
                    bp = new BoardingPass("Delta", p.getFirstName(), p.getLastName(), p.getAge(), d.getGate());
                    out.write(d.getGate().toString());
                    out.newLine();
                    out.flush();
                    p.setBoardingPass(bp);
                    d.addPassenger(p);
                    break;
                case "Alaska":
                    bp = new BoardingPass("Alaska", p.getFirstName(), p.getLastName(), p.getAge(), a.getGate());
                    out.write(a.getGate().toString());
                    out.newLine();
                    out.flush();
                    p.setBoardingPass(bp);
                    a.addPassenger(p);
                    break;
                case "Southwest":
                    bp = new BoardingPass("Southwest", p.getFirstName(), p.getLastName(), p.getAge(),
                            s.getGate());
                    out.write(s.getGate().toString());
                    out.newLine();
                    out.flush();
                    p.setBoardingPass(bp);
                    s.addPassenger(p);
                    break;
                default:
                    bp = new BoardingPass();
            }
            out.write(bp.toString());
            out.newLine();
            out.flush();
            BufferedWriter bw = new BufferedWriter(new FileWriter("reservations.txt"));
            bw.flush();
            bw.write("ALASKA\n");
            bw.flush();
            bw.write(a.currentPassengers + "/" + a.maxPassengers + "\n");
            bw.flush();
            bw.write("Alaska passenger list\n");
            bw.flush();
            bw.write(a.toString().toUpperCase() + "\n");
            bw.flush();
            bw.write("DELTA\n");
            bw.flush();
            bw.write(d.currentPassengers + "/" + d.maxPassengers + "\n");
            bw.flush();
            bw.write("Delta passenger list\n");
            bw.flush();
            bw.write(d.toString().toUpperCase() + "\n");
            bw.flush();
            bw.write("SOUTHWEST\n");
            bw.flush();
            bw.write(s.currentPassengers + "/" + s.maxPassengers + "\n");
            bw.flush();
            bw.write("Southwest passenger list\n");
            bw.flush();
            bw.write(s.toString().toUpperCase() + "\n");
            bw.flush();
            bw.close();
            out.write(getList(airline));
            out.newLine();
            out.flush();
            while (true) {
                String input = in.readLine();
                if (input.equals("0")) {
                    break;
                }
                out.write(getList(airline));
                out.newLine();
                out.flush();
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection lost with client.");
        }

    }

    public String getList(String airline) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reservations.txt"));
        String ans = "";
        String next = br.readLine();
        while (!(next.equalsIgnoreCase(airline))) {
            next = br.readLine();
        }
        next = br.readLine();
        next = next.substring(0, next.indexOf("/"));
        br.readLine();
        for (int i = 0; i < Integer.parseInt(next); i++) {
            ans = ans + br.readLine() + ":";
            br.readLine();
        }
        return ans;
    }
}
