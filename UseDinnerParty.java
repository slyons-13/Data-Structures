import java.util.Scanner; //import Scanner
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseDinnerParty extends JFrame {
    public static void main(String[] args) {
        // create Scanner object
        Scanner sc = new Scanner(System.in);
        Party party = new Party();

        // prompt user for number of guests
        System.out.println("Enter number of guests for the party: ");
        int guests = sc.nextInt(); //save to guests variable
        party.setGuests(guests);  //set number of guests
        System.out.println("The party has " + party.getGuests() + " guests");
        party.displayInvitation();//display party invitation

        DinnerParty dp = new DinnerParty();  //create DinnerParty object
        //prompt user for num of dp guests and save in new variable
        System.out.println("Enter number of guests for the dinner party: ");
        int dpGuests = sc.nextInt();
        dp.setGuests(dpGuests);
        //prompt user for dinner choice, store in new variable
        System.out.println("Enter the menu option (1 for chicken or 2 for veggie): ");
        int dinnerChoice = sc.nextInt();

        // print error message if invalid dinner choice
        if (dinnerChoice != 1 && dinnerChoice != 2) {
            System.out.println("Invalid choice. Please rerun");
        } else {
            //set dinner choice
            dp.setDinnerChoice(dinnerChoice);
            System.out.println("The dinner party has " + dp.getGuests() + " guests");
            System.out.println("Menu option " + dp.getDinnerChoice() + " will be served");
            dp.displayInvitation();
        }

        UseDinnerParty display = new UseDinnerParty();
        display.setVisible(true);

    }

    private UseDinnerParty() {
        Party event = new Party();  // new Party object
        DinnerParty dinParty = new DinnerParty();  //create DinnerParty object

        setTitle("Dinner Party");
        setSize(700, 500);
        setLayout(new BorderLayout());

        // label and field for guest number
        JLabel guestPrompt = new JLabel("Enter number of guests for the party: ");
        JTextField guestField = new JTextField(3);

        // label and field for dinner party guest number
        JLabel dpGuestPrompt = new JLabel("Enter number of guests for the dinner party: ");
        JTextField dpGuestField = new JTextField(3);

        // radio button for dinner choice
        ButtonGroup menu = new ButtonGroup();
        JLabel dinnerChoice = new JLabel("Select menu option: ");
        JRadioButton chicken = new JRadioButton("Chicken");
        JRadioButton veggie = new JRadioButton("Veggie");
        menu.add(chicken);
        menu.add(veggie);

        //button to display party info
        JButton button = new JButton("Click to display party info");

        //northern panel
        JPanel north = new JPanel();
        north.add(guestPrompt);
        north.add(guestField);

        // center panel
        JPanel center = new JPanel();
        center.add(dpGuestPrompt);
        center.add(dpGuestField);
        center.add(dinnerChoice);
        center.add(chicken);
        center.add(veggie);

        JPanel south = new JPanel();

        south.add(button);


        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        //event listeners for menu choice

        chicken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chicken.isSelected()) {
                    dinParty.setDinnerChoice(1);
                    revalidate();
                } else if (veggie.isSelected()){
                    dinParty.setDinnerChoice(2);
                    revalidate();
                }
            }
        });


        //event listener for button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setSize(700, 500);
                frame.setLayout(new GridLayout(2,2));

                int guests = Integer.parseInt(guestField.getText());
                //set party guest number
                event.setGuests(guests);

                int dpGuests = Integer.parseInt(dpGuestField.getText());
                //set dp guest number
                dinParty.setGuests(dpGuests);

                // add labels for number of party guests and dinner party guests
                JLabel party = new JLabel("The party has " + event.getGuests() + " guests");
                JLabel pInvite = new JLabel("Please come to my party!" + "\uD83C\uDF8A");//display party invitation

                JLabel dp = new JLabel("The dinner party has " + dinParty.getGuests() + " guests");
                JLabel menu = new JLabel("Menu option " + dinParty.getDinnerChoice() + " will be served");
                JLabel dpInvite = new JLabel("Please come to my party!" + "\uD83C\uDF8A");

                JLabel blank = new JLabel("");
                frame.add(party);
                frame.add(pInvite);
                frame.add(blank);

                frame.add(dp);

                frame.add(menu);
                frame.add(dpInvite);

                frame.setVisible(true);

                revalidate();

            }
        });

    }
}
