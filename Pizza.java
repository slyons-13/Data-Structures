import java.util.Arrays;

public class Pizza {
    public String[] toppings = new String[10];
    public float price;
    private int length;
    private String topStr = "";

    public Pizza(String[] toppings, int length) {
        this.length = length;
        this.price = 14 + (2*length);
        //loop through toppings and add them to new string
        for (int i = 0; i < length; i++) {
            // assign toppings to toppings list values
            if (i == length-1) {
                topStr += toppings[i];
            } else {
                // with commas in between unless at the end
                topStr += toppings[i] + ", ";
            }
        }

    }

    public String toString() {
        // add topping string list and price
        String str = topStr + " pizza: $" + price + "0";
        return str;
    }

    // get and set methods for toppings and length
    public void setToppings(String[] toppings) { this.toppings = toppings; }
    public void setLength(int length) { this.length = length; }
    public String[] getToppings() { return toppings; }
    public int getLength() { return length; }
}
