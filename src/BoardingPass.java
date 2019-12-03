import java.io.Serializable;

/**
 * @author Xinyi Xiao, Chiho Song
 * @version 12/02/2019
 */
public class BoardingPass implements Serializable {
    private String airline;
    private String firstName;
    private String lastName;
    private int age;
    private Gate gate;
    private int flightNumber;

    public BoardingPass() {
        airline = "";
        firstName = "";
        lastName = "";
        age = 0;
        gate = new Gate("A");
        flightNumber = 0;
    }

    public BoardingPass(String airline, String firstName, String lastName, int age, Gate gate) {
        this.airline = airline;
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.age = age;
        this.gate = gate;
        switch (airline) {
            case "Delta":
                flightNumber = 16000;
                break;
            case "Alaska":
                flightNumber = 18000;
                break;
            case "Southwest":
                flightNumber = 20000;
                break;
        }
    }

    public String toString() {
        return "<HTML>--------------------------------------------------------------------------------------" +
                "<br/>BOARDING PASS FOR FLIGHT " + flightNumber + " WITH " + airline + " Airlines<br/>PASSENGER" +
                " FIRST NAME: " +
                firstName + "<br/>PASSENGER LAST NAME: " + lastName + "<br/>PASSENGER AGE: " + age +
                "<br/>You can now begin boarding at gate " + gate +
                "<br/>-------------------------------------------------------------------------------------</HTML>";
    }
}
