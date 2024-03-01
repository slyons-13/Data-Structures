public class ItemOrder {

    // initialize quantity variable
    private int quantity;
    private Item item;
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // get and set methods
    public int getQuantity() { return quantity; }
    public Item getItem() { return item;}
    public void setQuantity(short quantity) { this.quantity = quantity; }
    public void setItem(Item item) { this.item = item; }
}
