import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class ReservationClient {
    public static void main(String args[]) throws IOException {
        String DeltaAd = "Delta Airlines is proud to be one of the five premier Airlines at Purdue University.\n" +
                "We are extremely happy to offer exceptional services, with free limited WiFi for all customers.\n" +
                "Passengers who use T-Mobile as a cell phone carrier get additional benefits.\n" +
                "We are also happy to offer power outlets in each seat for passenger use.\n" +
                "We hope you choose to fly Delta as your next Airline.";
        String SouthwestAd = "Southwest Airlines is proud to offer flights to Purdue University.\n" +
                "We are happy to offer free in flight wifi, as well as our amazing snacks.\n" +
                "In addition, we offer flights for much cheaper than other airlines, and offer two free checked bags\n" +
                "We hope you choose Southwest for your next flight\n";
        String AlaskaAd = "Alaska Airlines is proud to serve the strong and knowledgeable Boilermakers from Purdue University.\n" +
                "We primarily fly westward, and often have stops in Alaska and California.\n" +
                "We have first class amneties, even in coach class.\n" +
                "We provide fun snacks, such as pretzels and goldfish.\n" +
                "We also have comfortable seats and free WiFi.\n" +
                "We hope you choose Alaska Airlines for your next itinerary.\n";
        String[] options1 = {
                "Exit", "Book a Flight"
        };
        String[] options2 = {
                "Exit", "Yes, I want to book a flight"
        };
        String[] airlines = {
                "Delta", "Alaska", "Southwest"
        };
        ImageIcon icon = new ImageIcon("purdueLogo.png");
        while(true) {
            String hostName = JOptionPane.showInputDialog(null, "What is the hostname you'd like to connect to?", "Hostname?", JOptionPane.QUESTION_MESSAGE);
            if(hostName==null){
                break;
            }
            String port = JOptionPane.showInputDialog(null, "What is the port you'd like to connect to?", "Port?", JOptionPane.QUESTION_MESSAGE);
            if(port==null){
                break;
            }
            //Socket socket = new Socket(hostName, Integer.parseInt(port));

            int choice = JOptionPane.showOptionDialog(null, "", "Purdue University Flight Reservation System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options1, options1[0]);

            if (choice != 0) {
                choice = JOptionPane.showOptionDialog(null, "Do you want to book a flight today?", "Purdue University Flight Reservation System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
            }else{
                break;
            }
            if (choice != 0) {
                JFrame jf = new JFrame("Purdue University Flight Reservation System");
                jf.setSize(900, 900);
                jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JComboBox<String> airlineList = new JComboBox<>(airlines);
                JPanel panel1 = new JPanel();
                panel1.setPreferredSize(new Dimension(900, 100));
                JPanel panel2 = new JPanel();
                panel2.setSize(900, 500);
                JPanel panel3 = new JPanel();
                JLabel jldelta = new JLabel(DeltaAd);
                JLabel jlsouth = new JLabel(SouthwestAd);
                JLabel jlalaska = new JLabel(AlaskaAd);
                jldelta.setVisible(false);
                jlsouth.setVisible(false);
                jlalaska.setVisible(false);
                panel2.add(jldelta);
                panel2.add(jlsouth);
                panel2.add(jlalaska);
                airlineList.setSelectedIndex(0);
                airlineList.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        JComboBox cb = (JComboBox) actionEvent.getSource();
                        String airline = (String) cb.getSelectedItem();
                        assert airline != null;
                        switch (airline) {
                            case "Delta":
                                jldelta.setVisible(true);
                                jlsouth.setVisible(false);
                                jlalaska.setVisible(false);
                                break;
                            case "Southwest":
                                jlsouth.setVisible(true);
                                jldelta.setVisible(false);
                                jlalaska.setVisible(false);
                                break;
                            case "Alaska":
                                jlalaska.setVisible(true);
                                jldelta.setVisible(false);
                                jlsouth.setVisible(false);
                                break;
                        }
                    }
                });
                JLabel choose = new JLabel("Choose a flight from the drop down menu\n");
                choose.setFont (choose.getFont ().deriveFont (32.0f));
                panel1.add(choose);
                panel1.add(airlineList);
                jf.add(panel1, BorderLayout.NORTH);
                jf.add(panel2, BorderLayout.CENTER);
                jf.add(panel3, BorderLayout.SOUTH);

                jf.setVisible(true);
                //airline = (String) JOptionPane.showInputDialog(null, "Choose a flight from the drop down menu.", "Purdue University Flight Reservation System", JOptionPane.QUESTION_MESSAGE, null, airlines, airlines[0]);
            }else{
                break;
            }
            break;
        }
        //JOptionPane.showMessageDialog(null,"Thank you for using the Purdue University Airline Management System!");
    }
}
