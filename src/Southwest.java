import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Southwest implements Airline {
    @Override
    public String[] readClient() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reservation.txt"));
        ArrayList<String> listOfpassenger= new ArrayList<>();
        int a=0;
        String b;

        while ((b = br.readLine()) != null){
            if(b.equals("Southwest passenger list")){
                break;
            }
            if(a==1) {
                listOfpassenger.add(b);
            }
            if(b.equals("Southwest")){
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
