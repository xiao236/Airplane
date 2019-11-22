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
    public String toString() {
        return "BOARDING PASS FOR FLIGHT 18000 WITH " + airline + " Airlines\nPASSENGER FIRST NAME: " +
                firstName + "\nPASSENGER LAST NAME: " + lastName + "\nPASSENGER AGE: " + age +
                "\nYou can now begin boarding at gate " + gate;
    }
}
