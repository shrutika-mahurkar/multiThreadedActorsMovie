package Customer_Maintenance_application;

import java.util.Scanner;

public class CustomerMaintAppValidator {
    Scanner readInput;

    // Constructor
    public CustomerMaintAppValidator(Scanner sc) {
        readInput = sc;
    }

    /**
     * method getRequiredString returns string expected from the user.
     * It prompt the error message if user did not entered any string.
     * @param prompt
     *
     */
    public String getRequiredString(String prompt) {
        String s = " ";//variable to store string
        boolean isValid = false;//Boolean variable
        while (!isValid) { //loop until user enters string
            System.out.printf(prompt);	//prompt message
            s = readInput.nextLine();//assign string to variable s

            if (s.length() >0) {//check if user entered null string
                //s = readInput.nextLine();

                isValid = true;  //set boolean variable to true
            } else  {  //if not,prompt error message
                System.out.println("Error! This entry is required. Try again");

            }

        }

        return s;  //return string
    }


}
