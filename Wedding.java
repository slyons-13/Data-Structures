import java.util.Scanner;

public class Wedding {
    private String date;
    private String location;
    private Couple couple;


    public Wedding(Couple couple, String date, String location) {
        // construct couple
        this.couple = couple;
        // construct date
        this.date = date;
        // construct location;
        this.location = location;
    }

    // get methods for couple, date, and location
    public Couple getCouple() { return couple; }
    public String getDate() { return date; }
    public String getLocation() { return location; }

    // set methods for couple, date, and location
    public void setCouple(Couple couple) { this.couple = couple; }
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }

}
