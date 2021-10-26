package cutomer_invoice_report;

import java.util.Date;
/**
 * CustomerInvoice class stores data like customer's emailaAddress,
 * Invoice number,Invoice date,Invoice total
 */
public class CustomerInvoices {
    private String emailAddress;
    private String invoiceNumber;
    private Date date;
    private double invoiceTotal;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Date getDate() {
        return date;
    }

    public double getInvoiceTotal() {

        //String totalStr = Double.toString(invoiceTotal);

        return invoiceTotal;
    }

    public CustomerInvoices(String emailAddress, String invoiceNumber, Date date, double invoiceTotal) {
        this.emailAddress = emailAddress;
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.invoiceTotal = invoiceTotal;
    }



}


