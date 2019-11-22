import java.io.*;
import java.util.ArrayList;

public class Alaska implements Airline {

    public String[] readClient() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reservation.txt"));
        ArrayList<String> listOfpassenger= new ArrayList<>();
        int a=0;
        String b;

        while ((b = br.readLine()) != null){
            if(b.equals("Alaska passenger list")){
                break;
            }
            if(a==1) {
                listOfpassenger.add(b);
            }
            if(b.equals("Alaska")){
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
