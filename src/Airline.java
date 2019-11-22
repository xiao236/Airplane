import java.io.IOException;
import java.io.Serializable;

public interface Airline extends Serializable {
    public String[] readClient() throws IOException;
}
