import java.io.IOException;
import java.io.Serializable;

public interface Airline extends Serializable {
    String[] readClient() throws IOException;
    void addPassenger(Passenger p);
}
