import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoPizza extends JFrame {
    String address = new String();
    float fee;
    String[] toppings = new String[10];
    int length;

    public static void main(String[] args) {
        //construct gui object
        DemoPizza display = new DemoPizza();
        display.setVisible(true);
    }

    private DemoPizza() {
        setTitle("Pizza Order");
        setSize(500, 400);
        setLayout(new GridLayout(3, 1));

        // check for delivery
        JCheckBox delivery = new JCheckBox("Delivery");
        // button for entering toppings
        JButton enter = new JButton("Enter toppings (up to 10)");
        enter.setSize(50, 20);
        // button to show order info
        JButton order = new JButton("Display order details");

        add(delivery);
        add(enter);
        add(order);

        delivery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(delivery.isSelected()) {
                    // get entered text from popup
                    address = JOptionPane.showInputDialog("Enter Delivery Address: ");
                } else {
                    // set address to empty string
                    address = "";
                }

            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                // loop and display input dialogs for user to enter toppings
                for(i = 0; i < 10; i++) {
                    toppings[i] = (JOptionPane.showInputDialog("Enter a topping or QUIT to quit: "));
                    if(toppings[i].equals("QUIT")) {
                        // end if they enter quit
                        // set length equal to counter
                        length = i;
                        break;
                    }
                    // set length equal to counter
                    length = i;
                }

            }
        });

        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (address.isEmpty()) {
                    // create object
                    Pizza pizza = new Pizza(toppings, length);
                    // create label with pizza info
                    JLabel info = new JLabel(pizza.toString());
                    info.setForeground(Color.BLUE);
                    //show label
                    JOptionPane.showMessageDialog(null, info);

                } else {
                    // create delivery pizza object
                    DeliveryPizza dPizza = new DeliveryPizza(address, toppings, length);
                    // create label with pizza info
                    JLabel info = new JLabel(dPizza.toString() + ", delivered to " + address +
                            ". Delivery fee: $" + dPizza.getFee() + "0");
                    info.setForeground(Color.BLUE);
                    JOptionPane.showMessageDialog(null, info);
                }

            }
        });

    }
}
