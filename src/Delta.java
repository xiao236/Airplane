import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Delta implements Airline {

    public int currentPassengers;
    public int maxPassengers;
    public ArrayList<Passenger> passengers;

    public Delta() {
        currentPassengers = 0;
        passengers = new ArrayList<>();
        maxPassengers = 100;
    }
    public void addPassenger(Passenger p) {
        currentPassengers++;
        passengers.add(p);
    }
    public void preAdd(Passenger p) {
        passengers.add(p);
    }
    public String[] passengers() {
        String[] pass = new String[currentPassengers];
        for (int i = 0; i < currentPassengers; i++) {
            pass[0] = passengers.get(i).toString();
        }
        return pass;
    }
    public String toString() {
        String deltaPass = "";
        for (int i = 0; i < passengers.size(); i++) {
            deltaPass = deltaPass + passengers.get(i).toString() + "\n---------------------DELTA\n";
        }
        return deltaPass;
    }
}
