import java.io.Serializable;

public class Gate implements Serializable {
    private char terminal;
    private int gate;
    public Gate(char terminal, int gate) {
        this.terminal = terminal;
        this.gate = gate;
    }
}
