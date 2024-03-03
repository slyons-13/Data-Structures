public class DeliveryPizza extends Pizza {

    private float fee;
    private String address;

    public DeliveryPizza(String address, String[] toppings, int length) {
        super(toppings, length);
        this.address = address;
        if(price > 18) {
            this.fee = 3;
        } else {
            this.fee = 5;
        }
    }

    public void setAddress(String address) { this.address = address; }
    public void setFee(float fee) { this.fee = fee;}

    public String getAddress() { return address; }
    public float getFee() { return fee; }

}
