import java.io.Serializable;
import java.util.Random;

public class Gate implements Serializable {
    private String terminal;
    private int gate;
    public Gate() {
        Random rand = new Random();
        int term = rand.nextInt(3);
        gate = 1 + rand.nextInt(18);
        switch(term) {
            case 0: terminal = "A"; break;
            case 1: terminal = "B"; break;
            case 2: terminal = "C"; break;
        }
    }
}
