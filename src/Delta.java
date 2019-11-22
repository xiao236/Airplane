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
        maxPassengers = 100;
    }
    public void addPassenger(Passenger p) {
        currentPassengers++;
        passengers.add(p);
    }
    @Override
    public String[] readClient() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reservation.txt"));
        ArrayList<String> listOfpassenger= new ArrayList<>();
        int a=0;
        String b;

        while ((b = br.readLine()) != null){
            if(b.equals("Delta passenger list")){
                break;
            }
            if(a==1) {
                listOfpassenger.add(b);
            }
            if(b.equals("Delta")){
                a++;
            }
        }
        int sizeofarray = listOfpassenger.size();
        String[] arrayofpassenger = new String[sizeofarray];
        a=0;
        for(String k:listOfpassenger){
            arrayofpassenger[a]=k;
            a++;
        }
        return arrayofpassenger;
    }
}
