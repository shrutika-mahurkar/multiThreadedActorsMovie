package cutomer_invoice_report;
import java.sql.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * CustomerInvoiceApp connects to a derby database named BineetDB and displays a list of all customer's details
 * like email address,invoice number, invoice date and total.
 * @author Shrutika Mahurkar
 *
 */

public class CustomerInvoiceApp {
    public static void main(String args[]) throws SQLException {
        System.out.println("Welcome to Customer Invoices Report\n");
      //call displayInvoices method
      displayInvoices();
      //call disconnect method
      disconnect();

    }

    //getConnection method connects the derby database and returns connection
    private static Connection getConnection() throws SQLException {
        Connection connection = null;//connection object

        try {

            String dbURL = "jdbc:derby:BineetDB";//database URL
            connection = DriverManager.getConnection(dbURL);//connect to DB
            return connection;

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }//end of getConnection()

    //getCustomerInvoice() method gets object of customer and return Arraylist of object
    public static ArrayList<CustomerInvoices> getCustomerInvoice() throws SQLException {
        //SQL query to get required data
        String sql = "select c.EMAILADDRESS,i.INVOICENUMBER,i.INVOICEDAte,i.INVOICETOTAL " +
                "from customers c inner join invoices i " +
                "on c.customerid = i.customerid " +
                "order by c.emailaddress asc";
        //ArrayList to store customerInvoice details
        ArrayList<CustomerInvoices> customerInvoices = new ArrayList<>();
        //connect to DB and execute Query
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            //Retrieve the value of the designated column
            while (rs.next()) {
                String email = rs.getString("emailAddress");
                String invoiceNumber = rs.getString("invoiceNumber");
                Date date = rs.getDate("invoiceDate");
                double total = rs.getDouble("invoicetotal");
                //pass values to CustomerInvoices object
                CustomerInvoices c = new CustomerInvoices(email, invoiceNumber, date, total);
                //add object to arraylist
                customerInvoices.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }

        return customerInvoices;//return arraylist
    }//end of getCustomerInvoice()

    //displayInvoices method display the data store in arraylist using padWithSpace method of StringUtil class
    public static  void displayInvoices() throws SQLException {
        ArrayList<CustomerInvoices> invoices = getCustomerInvoice();
        for(int i=0;i<invoices.size();i++){
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");

            System.out.print(StringUtils.padWithSpaces(invoices.get(i).getEmailAddress(),40));
            System.out.print(StringUtils.padWithSpaces(invoices.get(i).getInvoiceNumber(),20));
            System.out.print(StringUtils.padWithSpaces(formatter.format(invoices.get(i).getDate()).toString(),20));
            System.out.println(StringUtils.padWithSpaces(currency.format(invoices.get(i).getInvoiceTotal()),20));
        }
    }//end of displayInvoices

//disconnect method disconnects derby Database
    public static boolean disconnect() throws SQLException {
        //Query to shutdown DB
        try {
            String shutdownURL = "jdbc:derby:;shutdown = true";
            DriverManager.getConnection(shutdownURL);
        } catch (SQLException e) {
            if (e.getMessage().equals("Derby System shutdown")) ;
            return true;
        }
        return false;
    }//end of disconnect method

}
