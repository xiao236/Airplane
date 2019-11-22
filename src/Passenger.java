import java.io.Serializable;

public class Passenger implements Serializable {
    private String firstName;
    private String lastName;
    private BoardingPass bp;
    private int age;
    public Passenger(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setBoardingPass(BoardingPass bp) {
        this.bp = bp;
    }
    public String toString() {
        String p = firstName.charAt(0) + ". " + lastName + ", " + age;
        p = p.toUpperCase();
        return p;
    }
}
