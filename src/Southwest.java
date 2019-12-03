import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Southwest implements Airline {
    public int currentPassengers;
    public int maxPassengers;
    public ArrayList<Passenger> passengers;

    public Southwest() {
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
        String southPass = "";
        for (int i = 0; i < passengers.size(); i++) {
            southPass = southPass + passengers.get(i).toString() + "\n---------------------SOUTHWEST\n";
        }
        return southPass;
    }
    public int getCurrentPassengers() {
        return currentPassengers;
    }
    public int getMaxPassengers() {
        return maxPassengers;
    }
    public String getPassengers() {
        String pass = "<html>";
        for (int i = 0; i < passengers.size(); i++) {
            pass = pass + passengers.get(i).toString() + "<br/>";
        }
        pass = pass + "</html";
        return pass;
    }
    public String retrieve() {
        String ans = "";
        for (int i = 0; i < passengers.size(); i++) {
            ans = ans + passengers.get(i).toString() + ";";
        }
        return ans;
    }
}
