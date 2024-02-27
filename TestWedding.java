import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestWedding extends JFrame {
    public static void main(String[] args) {
        // create Scanner object
        Scanner sc = new Scanner(System.in);

        // read in user data
//        System.out.println("Enter bride's first name: ");
//        String brideFirst = sc.next();
//        System.out.println("Enter bride's last name: ");
//        String brideLast = sc.next();
//
//        System.out.println("Enter groom's first name: ");
//        String groomFirst = sc.next();
//        System.out.println("Enter groom's last name: ");
//        String groomLast = sc.next();
//
//        System.out.println("Enter wedding date: ");
//        String date = sc.next();
//
//        System.out.println("Enter wedding location: ");
//        String location = sc.next();
//
//        // create Couple inputs
//        Person bride = new Person(brideFirst, brideLast);
//        Person groom = new Person(groomFirst, groomLast);
//        Couple couple = new Couple(bride, groom);
//
//        Wedding event = new Wedding(couple, date, location);
//
//        // print wedding details
//        //Wedding for Couple on Date at Location
//        System.out.println("Wedding for " + event.getCouple().getBride().getFirstName() + " " + event.getCouple().getBride().getLastName() +
//                        " and " + event.getCouple().getGroom().getFirstName() + " " + event.getCouple().getGroom().getLastName() +
//                        " on " + event.getDate() + " at " + event.getLocation());
//        System.out.println(event.getCouple().getBride().getFirstName());

        TestWedding display = new TestWedding();
        display.setVisible(true);
    }

    private TestWedding() {
        setTitle("Wedding Planner");
        setSize(700, 500);
        // set border layout
        setLayout(new BorderLayout());

        // labels and text fields for bride name
        JLabel brideFirstPrompt = new JLabel("Enter bride's first name: ");
        JTextField brideFirstField = new JTextField(12);
        JLabel brideLastPrompt = new JLabel("Enter bride's last name: ");
        JTextField brideLastField = new JTextField(12);

        //add elements to north panel
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());
        north.add(brideFirstPrompt);
        north.add(brideFirstField);
        north.add(brideLastPrompt);
        north.add(brideLastField);

        // labels and text fields for groom name
        JLabel groomFirstPrompt = new JLabel("Enter groom's first name: ");
        JTextField groomFirstField = new JTextField(12);
        JLabel groomLastPrompt = new JLabel("Enter groom's last name: ");
        JTextField groomLastField = new JTextField(12);

        //add elements to center panel
        JPanel center = new JPanel();
        center.add(groomFirstPrompt);
        center.add(groomFirstField);
        center.add(groomLastPrompt);
        center.add(groomLastField);

        // label and text field for date
        JLabel datePrompt = new JLabel("Enter wedding date: ");
        JTextField dateField = new JTextField(6);

        // label and text field for date
        JLabel locationPrompt = new JLabel("Enter wedding location: ");
        JTextField locationField = new JTextField(12);

        // enter button
        JButton button = new JButton("Display wedding details");

        JPanel south = new JPanel();
        south.setLayout(new GridLayout(3, 2));

        //add elements to south panel
        south.add(datePrompt);
        south.add(dateField);
        south.add(locationPrompt);
        south.add(locationField);
        south.add(button);

        // add panels to overall frame
        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);


        //event listener for button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get text from textfields
                String brideFirst = brideFirstField.getText();
                String brideLast = brideLastField.getText();
                String groomFirst = groomFirstField.getText();
                String groomLast = groomLastField.getText();
                String date = dateField.getText();
                String location = locationField.getText();

                // construct the objects needed for Wedding
                Person bride = new Person(brideFirst, brideLast);
                Person groom = new Person(groomFirst, groomLast);
                Couple couple = new Couple(bride, groom);
                Wedding event = new Wedding(couple, date, location);

                // label for detail display
                JLabel details = new JLabel("Wedding for " + event.getCouple().getBride().getFirstName() + " " +
                        event.getCouple().getBride().getLastName() + " and " + event.getCouple().getGroom().getFirstName() + " " +
                        event.getCouple().getGroom().getLastName() + " on " + event.getDate() + " at " + event.getLocation());
                // format label
                details.setForeground(Color.BLUE);
                details.setFont(new Font("Brush Script MT", Font.BOLD, 50));

                // show message dialog with wedding details
                JOptionPane.showMessageDialog(null, details);

            }
        });







    }

}
