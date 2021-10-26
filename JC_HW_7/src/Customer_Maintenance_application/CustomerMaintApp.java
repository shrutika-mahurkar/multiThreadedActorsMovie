package Customer_Maintenance_application;
/**
 * CustomerMaintApp maintains the data of customer stored in Derby Database name BineetDB.
 * It displays five commands :list, add, del, help, and exit.
 * and execute operation according to it.
 * It uses customer and customerDB class to work with the customer data.
 *
 * @author  Shrutika Mahurkar
 */

import cutomer_invoice_report.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMaintApp {
    //Create scanner object
    static Scanner readInput = new Scanner(System.in);
    //Create CustomerMaintAppValidator class object to validate the command entered by user
    static CustomerMaintAppValidator validate = new CustomerMaintAppValidator(readInput);

    public static void main(String args[]) throws SQLException {
        //display welcome message
        System.out.println("Welcome to Customer Maintenance Application");
        String command="";
        //loop until user enter exit
        while(!command.equals("exit")) {
            displayCommands();//display main commands
            command = validate.getRequiredString("Enter a command :");//wait for user choice
            System.out.println();
            executeUserCommand(command);//call executeUserCommand method

        }

    }//end of main

    //displayCommand method to display main commands
    public static void displayCommands(){
        System.out.println("COMMAND MENU\n" +
                "list\t-list all customers\n" +
                "add\t\t-add a customer\n" +
                "del\t\t-delete a customer\n" +
                "help\t-show this menu\n" +
                "exit\t-Exit this application\n");
    }

    //executeUserCommand method to execute operation according to user command.
    public static void executeUserCommand(String command) throws SQLException {
        //Arraylist to get list of all customer from DB
        ArrayList<Customer> customerList = new ArrayList<>();
        //object of CustomerDB class
        CustomerDB customerdb = new CustomerDB();

        switch (command) {
            //If the user enters “list”, the application displays the customer data that’s stored in a database
            //table.
            case "list":
                customerList = customerdb.getCustomer();//call getCustomer method
                for (int i =0;i< customerList.size();i++){//display customer data
                    System.out.print(StringUtils.padWithSpaces(customerList.get(i).getEmail(),40));
                    System.out.print(StringUtils.padWithSpaces(customerList.get(i).getFirstNAme(),40));
                    System.out.println(StringUtils.padWithSpaces(customerList.get(i).getLastName(),40));
                }
                System.out.println();
                break;

                //If the user enters “add”, the application prompts the user to enter data for a customer and
            //saves that data to the database table.
            case "add":
                //get information about customer
                String newEmail = validate.getRequiredString("Enter customer email address :");
                String newFirstName = validate.getRequiredString("Enter customer's first name :");
                String newlastName = validate.getRequiredString("Enter customer's last name :");
                //pass it customer class object
                Customer newCustomer = new Customer(newEmail,newFirstName,newlastName);
                customerdb.addCustomer(newCustomer);//call addCustomer method
                System.out.println();
                break;

           // If the user enters “del”, the application prompts the user for an email address and deletes the
            //corresponding customer from the database table.
            case "del":
                //get email address to delete customer object
                String delEmail = validate.getRequiredString("Enter customer email to delete :");
                customerdb.deleteCustomer(delEmail);//call deleteCustomer method
                System.out.println();
                break;

                //If the user enters “help”, the application displays the menu again
            case "help":
                System.out.println();
                break;

                //If the user enters “exit”, the application displays a goodbye message and exits.
            //also disconnects DB
            case "exit":
                System.out.println("goodbye");
                customerdb.disconnect();
                break;
                //if user enter other than expected commands,display message
            default:
                System.out.println("Please enter valid command from main menu\n");
        }

    }//end of executeUserCommand

}
