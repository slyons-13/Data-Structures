import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaApp2 extends JFrame {

    //initialize price vars
    float sizePrice = 0;
    float toppings = 0;
    float total = 0;

    // blank price label to be updated later
    JLabel totalPrice = new JLabel("");


    public static void main(String[] args) {
        //constructor for PizzaApp2 object
        PizzaApp2 start = new PizzaApp2();
        start.setVisible(true);
    }

    private PizzaApp2() {
        //create window and set minimum size
        setTitle("Pizza Application");
        setSize(700, 501);
        //set grid layout for window
        setLayout(new GridLayout(6, 2));
        setBackground(Color.red);

        // String array of size options
        String[] sizes = {"*Select size:", "Small", "Medium", "Large", "Super"};
        // create dropdown menu of size options
        JComboBox<String> dropdown = new JComboBox<>(sizes);
        add(dropdown);

        // blank label for formatting
        JLabel blank1 = new JLabel("");
        add(blank1);

        // check boxes for topping options
        JCheckBox veggie = new JCheckBox("Veggie", false);
        JCheckBox chicken = new JCheckBox("Chicken", false);
        JCheckBox hamburger = new JCheckBox("Hamburger", false);
        JCheckBox cheese = new JCheckBox("Extra Cheese", false);

        // label for checkboxes
        JLabel choose = new JLabel("Choose up to 3 toppings:");
        add(choose);

        //blank label for formatting
        JLabel blank2 = new JLabel("");
        add(blank2);

        // show checkboxes
        add(veggie);
        add(chicken);
        add(hamburger);
        add(cheese);

        // create calculate price button
        JButton button = new JButton("Calculate Price");
        button.setBackground(Color.GREEN);
        button.setOpaque(true);
        add(button);

        // create exit button
        JButton exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setOpaque(true);
        add(exit);

        add(totalPrice);

        //event listeners for toppings checkboxes, set or subtract toppings price
            //if topping is unselected

        veggie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (veggie.isSelected()) {
                    toppings += 0.50;
                } else {
                    toppings -= 0.50;
                }
            }
        });

        chicken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chicken.isSelected()) {
                    toppings += 0.50;
                } else {
                    toppings -= 0.50;
                }
            }
        });

        hamburger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hamburger.isSelected()) {
                    toppings += 0.50;
                } else {
                    toppings -= 0.50;
                }
            }
        });

        //event listener for size selection (dropdown)
        //set sizePrice depending on which size is selected
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalPrice.setText("");
                if (dropdown.getSelectedItem().equals("Small")) {
                    sizePrice = (float) 5.00;
                } else if (dropdown.getSelectedItem().equals("Medium")) {
                    sizePrice = (float) 10.00;
                } else if (dropdown.getSelectedItem().equals("Large")) {
                    sizePrice = (float) 15.00;
                } else if (dropdown.getSelectedItem().equals("Super")) {
                    sizePrice = (float) 20.00;
                }

            }
        });

        // event listener for calculate price button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // prompt user to select a size if no size is selected
                if (dropdown.getSelectedItem().equals("*Select size:")) {
                    totalPrice.setText("Please select a size.");
                    sizePrice = 0;
                    revalidate();
                //prompt user to choose 3 toppings if 4 are seleected
                } else if (veggie.isSelected() && chicken.isSelected() && hamburger.isSelected() && cheese.isSelected()) {
                    totalPrice.setText("Please only choose 3 toppings.");
                    toppings = 0;
                    revalidate();
                // account for 3 topping discount
                } else {
                    if (toppings == 1.50) {
                        toppings = (float) 1.25;
                    }
                    total = sizePrice + toppings;
                    totalPrice.setText("Your total is $" + total);
                    revalidate();

                }
            }
        });

        //action listener for exit button
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //close window
                System.exit(0);
            }
        });


    }


}