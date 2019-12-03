import java.io.Serializable;

public class BoardingPass implements Serializable {
    private String airline;
    private String firstName;
    private String lastName;
    private int age;
    private Gate gate;
    private int flightNumber;

    public BoardingPass(String airline, String firstName, String lastName, int age, Gate gate) {
        this.airline = airline;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gate = gate;

        switch(airline) {
            case "Delta": flightNumber = 20000; break;
            case "Alaska": flightNumber = 18000; break;
            case "Southwest": flightNumber = 22000; break;
            default: flightNumber = 16000; break;
        }
    }
    public String toString() {
        return "<HTML>BOARDING PASS FOR FLIGHT " + flightNumber + " WITH " + airline + " Airlines<br/>PASSENGER FIRST NAME: " +
                firstName + "<br/>PASSENGER LAST NAME: " + lastName + "<br/>PASSENGER AGE: " + age +
                "<br/>You can now begin boarding at gate " + gate.toString()+"<HTML>";
    }
}
