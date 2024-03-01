import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCart extends JFrame{
    // create Item and ItemOrder objects
    Item tissues = new Item("Tissue boxes", 4);
    Item eggs = new Item("Eggs", 8);
    Item milk = new Item("Milk", 12);
    Item bread = new Item("Bread", 8);
    ItemOrder tissueOrder = new ItemOrder(tissues, 0);
    ItemOrder eggOrder = new ItemOrder(eggs, 0);
    ItemOrder milkOrder = new ItemOrder(milk, 0);
    ItemOrder breadOrder = new ItemOrder(bread, 0);

    float price = 0;

    public static void main(String[] args) {
        // construct GUI object
        ShoppingCart display = new ShoppingCart();
        display.setVisible(true);
    }

    public ShoppingCart() {
        // ArrayList to store item orders
        ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();

        // set main window characteristics
        setTitle("Shopping Cart");
        setSize(700, 500);
        setLayout(new BorderLayout());

        JLabel instructions = new JLabel("Select quantity of each item");

        // labels for items
        JLabel tissueLabel = new JLabel(tissues.getName() + " $" + tissues.getPrice());
        JLabel eggLabel = new JLabel(eggs.getName() + " $" + eggs.getPrice());
        JLabel milkLabel = new JLabel(milk.getName() + " $" + milk.getPrice());
        JLabel breadLabel= new JLabel(bread.getName() + " $" + bread.getPrice());


        // dropdown menus for quantities
        Short[] quantity = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        JComboBox<Short> tissueNum = new JComboBox<>(quantity);
        JComboBox<Short> eggNum = new JComboBox<>(quantity);
        JComboBox<Short> milkNum = new JComboBox<>(quantity);
        JComboBox<Short> breadNum = new JComboBox<>(quantity);


        // buttons to add to cart
        JButton tissueAdd = new JButton("Add to cart");
        JButton eggAdd = new JButton("Add to cart");
        JButton milkAdd = new JButton("Add to cart");
        JButton breadAdd = new JButton("Add to cart");

        //buttons to remove from cart
        JButton tissueRemove = new JButton("Remove from cart");
        JButton eggRemove = new JButton("Remove from cart");
        JButton milkRemove = new JButton("Remove from cart");
        JButton breadRemove = new JButton("Remove from cart");

        // add elements to frame
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 4));
        center.add(tissueLabel);
        center.add(tissueNum);
        center.add(tissueAdd);
        center.add(tissueRemove);
        center.add(eggLabel);
        center.add(eggNum);
        center.add(eggAdd);
        center.add(eggRemove);
        center.add(milkLabel);
        center.add(milkNum);
        center.add(milkAdd);
        center.add(milkRemove);
        center.add(breadLabel);
        center.add(breadNum);
        center.add(breadAdd);
        center.add(breadRemove);

        // create display price button and view cart button
        JPanel south = new JPanel();
        JButton priceBtn = new JButton("Display total price");
        JButton cart = new JButton("View Cart");
        south.add(priceBtn);
        south.add(cart);

        add(instructions, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        // action listeners for item buttons

        tissueAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get quantity from dropdown menu
                short quantity = (short)tissueNum.getSelectedItem();
                // set order quantity
                tissueOrder.setQuantity(quantity);
                // add item order to the list
                list.add(tissueOrder);
                price += tissues.getPrice() * quantity;
            }
        });

        tissueRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // remove order from list and price from total price variable
                if (list.contains(tissueOrder)) {
                    short quantity = (short)tissueNum.getSelectedItem();
                    list.remove(tissueOrder);
                    price -= tissues.getPrice() * quantity;
                }
            }
        });

        eggAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get quantity from dropdown menu
                short quantity = (short)eggNum.getSelectedItem();
                // set order quantity
                eggOrder.setQuantity(quantity);
                // add item order to the list
                list.add(eggOrder);
                price += eggs.getPrice() * quantity;
            }
        });

        eggRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.contains(eggOrder)) {
                    short quantity = (short)eggNum.getSelectedItem();
                    list.remove(eggOrder);
                    price -= eggs.getPrice() * quantity;
                }
            }
        });

        milkAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get quantity from dropdown menu
                short quantity = (short)milkNum.getSelectedItem();
                // set order quantity
                milkOrder.setQuantity(quantity);
                // add item order to the list
                list.add(milkOrder);
                price += milk.getPrice() * quantity;
            }
        });

        milkRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.contains(milkOrder)) {
                    short quantity = (short)milkNum.getSelectedItem();
                    list.remove(milkOrder);
                    price -= milk.getPrice() * quantity;
                }
            }
        });

        breadAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get quantity from dropdown menu
                short quantity = (short)breadNum.getSelectedItem();
                // set order quantity
                breadOrder.setQuantity(quantity);
                // add item order to the list
                list.add(breadOrder);
                price += bread.getPrice() * quantity;
            }
        });

        breadRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.contains(breadOrder)) {
                    short quantity = (short)breadNum.getSelectedItem();
                    list.remove(breadOrder);
                    price -= bread.getPrice() * quantity;
                }
            }
        });


        //action listener for price display btn
        priceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel ttlprice = new JLabel("$" + price);
                ttlprice.setForeground(Color.BLUE);
                // show popup message
                JOptionPane.showMessageDialog(null, ttlprice);
            }
        });

        // action listener for view cart button
        cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String items = "";
                // concatenate item numbers and names to label string
                // if the items are in the cart
                if (list.contains(tissueOrder)){
                    items += tissueOrder.getQuantity() + " tissue boxes. "; }
                if (list.contains(eggOrder)){
                    items += eggOrder.getQuantity() + " dozen eggs. "; }
                if (list.contains(milkOrder)){
                    items += milkOrder.getQuantity() + " gallons of milk. "; }
                if (list.contains(breadOrder)){
                    items += breadOrder.getQuantity() + " loaves of bread. "; }

                // if cart is empty
                if (items.isEmpty()) {
                    items = "Cart is empty.";
                }

                // create label and show popup message
                JLabel cart = new JLabel(items);
                cart.setForeground(Color.BLUE);
                JOptionPane.showMessageDialog(null, cart);
            }
        });

    }

}
