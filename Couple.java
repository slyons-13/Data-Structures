public class Couple {
    Person bride;
    Person groom;
    public Couple(Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }

    // get method for bride and groom Person
    public Person getBride() { return bride; }
    public Person getGroom() { return groom; }

    // set methods for pride and groom Person
    public void setBride(Person bride) {
        this.bride = bride;
    }

    public void setGroom(Person groom) {
        this.groom = groom;
    }



}
