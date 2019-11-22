import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationClient {
    public static void main(String args[]) {
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
            JComboBox airlineList = new JComboBox(airlines);
            airlineList.setSelectedIndex(0);
            airlineList.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    actionPerformed(actionEvent);
                }
            });
            //airline = (String) JOptionPane.showInputDialog(null, "Choose a flight from the drop down menu.", "Purdue University Flight Reservation System", JOptionPane.QUESTION_MESSAGE, null, airlines, airlines[0]);
        }
        if (airline != null) {

        }
    }
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String airline = (String)cb.getSelectedItem();

    }
}
