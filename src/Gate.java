import java.io.Serializable;
import java.util.Random;

public class Gate implements Serializable {
    private String terminal;
    private int gate;
    public Gate(String terminal) {
        Random rand = new Random();
        this.terminal = terminal;
        gate = 1 + rand.nextInt(18);
    }
    public String toString() {
        return terminal + gate;
    }
}
