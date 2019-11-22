import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationClient {
    public static void main(String args[]) {
        String DeltaAd = "Delta Airlines is proud to be one of the five premier Airlines at Purdue University." +
                "We are extremely happy to offer exceptional services, with free limited WiFi for all customers." +
                "Passengers who use T-Mobile as a cell phone carrier get additional benefits." +
                "We are also happy to offer power outlets in each seat for passenger use." +
                "We hope you choose to fly Delta as your next Airline.";
        String SouthwestAd = "Southwest Airline";
        String[] options1 = {
                "Exit", "Book a Flight"
        };
        String[] options2 = {
                "Exit", "Yes, I want to book a flight"
        };
        String[] airlines = {
                "Delta", "Alaska", "Southwest"
        };
        String hostName = JOptionPane.showInputDialog(null, "What is the hostname you'd like to connect to?", "Hostname?", JOptionPane.QUESTION_MESSAGE);
        String port = JOptionPane.showInputDialog(null, "What is the port you'd like to connect to?", "Port?", JOptionPane.QUESTION_MESSAGE);
        String airline = "";
        ImageIcon icon = new ImageIcon("purdueLogo.png");
        int choice = JOptionPane.showOptionDialog(null, "", "Purdue University Flight Reservation System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options1, options1[0]);

        if (choice != 0) {
            choice = JOptionPane.showOptionDialog(null, "Do you want to book a flight today?", "Purdue University Flight Reservation System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
        }
        if (choice != 0) {
            JFrame jf = new JFrame("Purdue University Flight Reservation System");
            jf.setSize(900, 900);
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JComboBox<String> airlineList = new JComboBox<>(airlines);
            airlineList.setSelectedIndex(0);
            airlineList.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JComboBox cb = (JComboBox)actionEvent.getSource();
                    String airline = (String)cb.getSelectedItem();
                    assert airline != null;
                    switch (airline) {
                        case "Delta": jf.add(new JLabel(DeltaAd)); break;
                        case "Southwest": jf.add(new JLabel(SouthwestAd)); break;
                    }
                }
            });
            jf.add(airlineList);
            jf.setVisible(true);
            //airline = (String) JOptionPane.showInputDialog(null, "Choose a flight from the drop down menu.", "Purdue University Flight Reservation System", JOptionPane.QUESTION_MESSAGE, null, airlines, airlines[0]);
        }
        if (airline != null) {

        }
    }
}
