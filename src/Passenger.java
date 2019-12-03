import java.io.Serializable;

/**
 * @author Xinyi Xiao, Chiho Song
 * @version 12/02/2019
 */
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

    public void setBoardingPass(BoardingPass b) {
        this.bp = b;
    }

    public String toString() {
        String p = firstName + " " + lastName + ", " + age;
        p = p.toUpperCase();
        return p;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String initialString() {
        return firstName.substring(0, 1).toUpperCase() + ". " + lastName.toUpperCase() + ", " + age;
    }
}
