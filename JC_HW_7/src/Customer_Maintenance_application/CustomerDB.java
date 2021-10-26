package Customer_Maintenance_application;
/* *
*CustomerDB class consist of method to connect to DB and method to manipulate DB like list,add,delete.
*@author  Shrutika Mahurkar
 **/
import java.sql.*;
import java.util.ArrayList;

public class CustomerDB {

    //getConnection method connects the derby database and returns connection
        private static Connection getConnection() throws SQLException {
        Connection connection = null; //connection object
        try {
            String dbURL = "jdbc:derby:BineetDB";  //database URL
            connection = DriverManager.getConnection(dbURL);//connect to DB

            return connection;//return connection
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }//end of getConnection

    // getCustomer method returns an array list of Customer objects for the customers in the Customer table
    public ArrayList<Customer> getCustomer() throws SQLException {
            //Sql Query
        String sql = "SELECT emailAddress,firstname,lastname " +
                "FROM customers " + "ORDER by emailAddress asc ";
        //ArrayList to store Customer objects
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        //connect to DB and execute Query
        try (Connection connection = this.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            //loop while result set have data
            while (rs.next()) {
                //Retrieve the value of the designated column
                String email = rs.getString("emailAddress");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("Lastname");
                //pass values to Customer object
                Customer cust = new Customer(email, firstName, lastName);

                //add object to arraylist
                customerArrayList.add(cust);


            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return customerArrayList;//return Arraylist
    }//end of getCustomer()

    //addCustomer method adds new customer object to DB
    public boolean addCustomer(Customer c) throws SQLException {
            //sql Query to insert new customer data
        String sql = "INSERT INTO Customers " + "(emailAddress,FirstName,LastName) " +
                "Values (?, ?, ?)";
        //connect to DB and execute Query
        try (Connection connection = this.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            //set values in sql query
            ps.setString(1, c.getEmail());
            ps.setString(2, c.getFirstNAme());
            ps.setString(3, c.getLastName());
            ps.executeUpdate();
            System.out.println("JDBC Test was added to the database.");
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }//end of addCustomer

    //deleteCustomer method deletes the customer object from DB
    public boolean deleteCustomer(String email) throws SQLException {
            //sql query to delete customer object
        String sql = "Delete from customers " + "where emailAddress =?";
        //connect to DB and execute Query
        try (Connection connection = this.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            //set value for email in sql query
            ps.setString(1, email);
            int i = ps.executeUpdate();
            //if i=0,it means email not found
            if (i == 0) {
                System.out.println("No email address found. Please enter valid email.");
                ps.close();
                return true;
            }
            else {//email found and deleted
                System.out.println("JDBC Test was deleted from the database.");
                ps.close();
                return true;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }//end of deleteCustomer

    //disconnect method disconnects derby Database
    public boolean disconnect() throws SQLException {
            //Query to shutdown DB
        try {
            String shutdownURL = "jdbc:derby:;shutdown = true";
            DriverManager.getConnection(shutdownURL);


        } catch (SQLException e) {
            if (e.getMessage().equals("Derby System shutdown")) ;
            return true;
        }
        return false;
    }
}//end of disconnect
