import java.io.*;
import java.util.ArrayList;

public class Alaska implements Airline {
    public int currentPassengers;
    public int maxPassengers;
    public ArrayList<Passenger> passengers;

    public Alaska() {
        currentPassengers = 0;
        maxPassengers = 100;
        passengers = new ArrayList<>();
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
        String alaskaPass = "";
        for (int i = 0; i < passengers.size(); i++) {
            alaskaPass = alaskaPass + passengers.get(i).toString() + "\n---------------------ALASKA\n";
        }
        return alaskaPass;
    }

}
