import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ReservationClient {
    public static void main(String args[]) throws IOException {
        String nameOfAirline;
        String[] options1 = {
                "Exit", "Book a Flight"
        };
        String[] options2 = {
                "Exit", "Yes, I want to book a flight"
        };
        ImageIcon icon = new ImageIcon("purdueLogo.png");
        while (true) {
            String hostName = JOptionPane.showInputDialog(null, "What is the hostname you'd like to connect to?", "Hostname?", JOptionPane.QUESTION_MESSAGE);
            if (hostName == null) {
                break;
            }
            String port = JOptionPane.showInputDialog(null, "What is the port you'd like to connect to?", "Port?", JOptionPane.QUESTION_MESSAGE);
            if (port == null) {
                break;
            }
            Socket socket = new Socket(hostName, Integer.parseInt(port));

            int choice = JOptionPane.showOptionDialog(null, "", "Purdue University Flight Reservation System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options1, options1[0]);

            if (choice != 0) {
                choice = JOptionPane.showOptionDialog(null, "Do you want to book a flight today?", "Purdue University Flight Reservation System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
            } else {
                break;
            }
            if (choice != 0) {
                createAndShowGUI(socket);
                //airline = (String) JOptionPane.showInputDialog(null, "Choose a flight from the drop down menu.", "Purdue University Flight Reservation System", JOptionPane.QUESTION_MESSAGE, null, airlines, airlines[0]);
            } else {
                break;
            }
            break;
        }
        //JOptionPane.showMessageDialog(null,"Thank you for using the Purdue University Airline Management System!");
    }


    private static void createAndShowGUI(Socket socket) {
        String[] airlines = {
                "Delta", "Alaska", "Southwest"
        };
        String DeltaAd = "<html>Delta Airlines is proud to be one of the five premier Airlines at Purdue University.<br/>" +
                "We are extremely happy to offer exceptional services, with free limited WiFi for all customers.<br/>" +
                "Passengers who use T-Mobile as a cell phone carrier get additional benefits.<br/>" +
                "We are also happy to offer power outlets in each seat for passenger use.<br/>" +
                "We hope you choose to fly Delta as your next Airline.</html>";
        String SouthwestAd = "<html>Southwest Airlines is proud to offer flights to Purdue University.<br/>" +
                "We are happy to offer free in flight wifi, as well as our amazing snacks.<br/>" +
                "In addition, we offer flights for much cheaper than other airlines, and offer two free checked bags<br/>" +
                "We hope you choose Southwest for your next flight</html>";
        String AlaskaAd = "<html>Alaska Airlines is proud to serve the strong and knowledgeable Boilermakers from Purdue University.<br/>" +
                "We primarily fly westward, and often have stops in Alaska and California.<br/>" +
                "We have first class amneties, even in coach class.<br/>" +
                "We provide fun snacks, such as pretzels and goldfish.<br/>" +
                "We also have comfortable seats and free WiFi.<br/>" +
                "We hope you choose Alaska Airlines for your next itinerary.</html>";
        JFrame jf = new JFrame("Purdue University Flight Reservation System");
        jf.setPreferredSize(new Dimension(900, 700));
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
        JTextField jt = new JTextField("Delta");

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
                String a;
                assert airline != null;
                switch (airline) {
                    case "Delta":
                        jldelta.setVisible(true);
                        jlsouth.setVisible(false);
                        jlalaska.setVisible(false);
                        jt.setText("Delta");
                        break;
                    case "Southwest":
                        jlsouth.setVisible(true);
                        jldelta.setVisible(false);
                        jlalaska.setVisible(false);
                        jt.setText("Southwest");
                        break;
                    case "Alaska":
                        jlalaska.setVisible(true);
                        jldelta.setVisible(false);
                        jlsouth.setVisible(false);
                        jt.setText("Alaska");
                        break;
                }
            }
        });
        JLabel choose = new JLabel("Choose a flight from the drop down menu\n");
        choose.setFont(choose.getFont().deriveFont(32.0f));
        panel1.add(choose);
        panel1.add(airlineList);
        JButton button1 = new JButton("Exit");
        JButton button2 = new JButton("Choose this flight");
        
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                createAndShowGUII(jt.getText(),socket);
            }
        });

        panel3.add(button1);
        panel3.add(button2);

        jf.add(panel1, BorderLayout.NORTH);
        jf.add(panel2, BorderLayout.CENTER);
        jf.add(panel3, BorderLayout.SOUTH);

        jf.pack();
        jf.setVisible(true);
    }

    private static void createAndShowGUII(String nameofairline,Socket socket) {
        JFrame jf = new JFrame("Purdue University Flight Reservation System");
        jf.setSize(new Dimension(900, 700));
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(900, 100));
        JPanel panel2 = new JPanel();
        panel2.setSize(900, 500);
        JPanel panel3 = new JPanel();
        JLabel choose = new JLabel("Are you sure that you want to book a flight on "+nameofairline);
        choose.setFont(choose.getFont().deriveFont(32.0f));
        panel1.add(choose);
        JButton button1 = new JButton("Exit");
        JButton button2 = new JButton("No, I want a different flight");
        JButton button3 = new JButton("Yes, I want this flight");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                createAndShowGUI(socket);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(nameofairline);
                    oos.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                createAndShowGUIII(nameofairline,socket);
            }
        });
        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3);
        jf.add(panel1, BorderLayout.NORTH);
        jf.add(panel2, BorderLayout.CENTER);
        jf.add(panel3, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

    private static void createAndShowGUIII(String nameofairline,Socket socket) {
        String[] options1 = {
                "No", "Yes"
        };
        JFrame jf = new JFrame("Purdue University Flight Reservation System");
        jf.setSize(new Dimension(900, 700));
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(900, 100));
        JPanel panel2 = new JPanel();
        panel2.setSize(900, 500);
        JPanel panel3 = new JPanel();
        JLabel choose = new JLabel("Please input your information below.");
        panel1.add(choose);

        JTextField jt1= new JTextField(null,3);
        JTextField jt2= new JTextField(null,3);
        JTextField jt3= new JTextField(null,3);
        JLabel jl1 = new JLabel("What is your first name?");
        JLabel jl2 = new JLabel("What is your last name?");
        JLabel jl3 = new JLabel("What is your age?");
        panel2.add(jl1);
        panel2.add(jt1);
        panel2.add(jl2);
        panel2.add(jt2);
        panel2.add(jl3);
        panel2.add(jt3);
        JButton button1 = new JButton("Exit");
        JButton button2 = new JButton("Next");

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showOptionDialog(null,
                        "Are all the details you entered correct?\n"+
                                "The passenger's name is "+ jt1.getText()+" "+jt2.getText()+" and their age is "+ jt3.getText()+
                                "\nIf all the information shown is correct, select the Yes button below, otherwise, select the No button"
                        , "Comfirm Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options1, options1[0]);
                if(choice==0){
                }else{
                    jf.setVisible(false);
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        Passenger p = new Passenger(jt1.getText(), jt2.getText(), Integer.parseInt(jt3.getText()));
                        oos.writeObject(jt1.getText()+" "+ jt2.getText()+" "+ jt3.getText());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    createAndShowGUIIII(nameofairline,socket);
                }



            }
        });

        panel3.add(button1);
        panel3.add(button2);
        jf.add(panel1, BorderLayout.NORTH);
        jf.add(panel2, BorderLayout.CENTER);
        jf.add(panel3, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

    private static void createAndShowGUIIII(String nameofairline,Socket socket) {
        JFrame jf = new JFrame("Purdue University Flight Reservation System");
        jf.setSize(new Dimension(900, 700));
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(900, 100));
        JPanel panel2 = new JPanel();
        panel2.setSize(900, 500);
        JPanel panel3 = new JPanel();
        JLabel choose = new JLabel("<html>Flight data displaying for "+nameofairline+"" +
                " Airlines<br/>Enjoy your flight!<br/>Flight is now boarding at Gate </html>");
        panel1.add(choose);

        //JScrollPane scrollPane = new JScrollPane(textArea);

        jf.add(panel1, BorderLayout.NORTH);
        jf.add(panel2, BorderLayout.CENTER);
        jf.add(panel3, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }
}