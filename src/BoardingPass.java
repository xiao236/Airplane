import java.io.Serializable;

public class BoardingPass implements Serializable {
    private String airline;
    private String firstName;
    private String lastName;
    private int age;
    private Gate gate;

    public BoardingPass(String airline, String firstName, String lastName, int age, Gate gate) {
        this.airline = airline;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gate = gate;
    }
}
