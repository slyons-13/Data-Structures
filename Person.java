public class Person {
    private String firstName;
    private String lastName;

    //constructor to create instance of the object
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // get methods for first and last name
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    // set methods for first and last nam
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
