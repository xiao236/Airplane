/**
 * @author Xinyi Xiao, Chiho Song
 * @version 12/02/2019
 */

import java.io.IOException;
import java.io.Serializable;

public interface Airline extends Serializable {
    void addPassenger(Passenger p);

    String[] passengers();
}
