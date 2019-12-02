import java.io.IOException;
import java.io.Serializable;

public interface Airline extends Serializable {
    void addPassenger(Passenger p);
    String[] passengers();
}
