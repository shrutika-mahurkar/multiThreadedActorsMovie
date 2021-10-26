package Customer_Maintenance_application;
/**
 * Customer Class stores data like user’s email address, first name, and
 * last name. It has parameterised constructor and getter methods.
 * @author  Shrutika Mahurkar
 */
public class Customer {
    private String email;
    private String FirstNAme;
    private String LastName;


    public Customer(String email, String firstNAme, String lastName) {
        this.email = email;
        FirstNAme = firstNAme;
        LastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public String getFirstNAme() {
        return FirstNAme;
    }

    public String getLastName() {
        return LastName;
    }



}
