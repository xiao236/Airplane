import java.io.Serializable;
import java.util.Random;

/**
 * @author Xinyi Xiao, Chiho Song
 * @version 12/02/2019
 */

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
