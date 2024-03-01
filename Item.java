public class Item {
    private String name;
    private int price;

    // constructor for item objects
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // get methods for name and price
    public String getName() { return name;}
    public int getPrice() { return price; }

    // set methods for name and price
    public void setName(String name) { this.name = name; }
    public void setPrice(int price) { this.price = price; }

}
