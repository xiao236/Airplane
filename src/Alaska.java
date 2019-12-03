import java.io.*;
import java.util.ArrayList;

/**
 * @author Xinyi Xiao, Chiho Song
 * @version 12/02/2019
 */
public class Alaska implements Airline {
    int currentPassengers;
    int maxPassengers;
    private ArrayList<Passenger> passengers;
    private Gate gate;

    public Alaska() {
        currentPassengers = 0;
        maxPassengers = 100;
        passengers = new ArrayList<>();
        gate = new Gate("A");

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
            alaskaPass = alaskaPass + passengers.get(i).initialString() + "\n---------------------ALASKA\n";
        }
        return alaskaPass;
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

    public Gate getGate() {
        return gate;
    }

}
