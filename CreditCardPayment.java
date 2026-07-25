interface Payable {
    void processPayment(double amount);
    String getPaymentStatus();
    void refundPayment(double amount);
}

interface Taxable {
    double calculateTax();
    void generateTaxInvoice();
}

interface Loggable {
    void logActivity(String action);
}

// A class can implement multiple interfaces
public class CreditCardPayment implements Payable, Taxable, Loggable {

    private String cardNumber;
    private String status = "PENDING";
    private double amount;
    private double tax;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        this.amount = amount;
        System.out.println("Processing credit card payment: $" + amount);
        this.status = "SUCCESS";
        logActivity("Payment processed: $" + amount);
    }

    @Override
    public String getPaymentStatus() {
        return status;
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding payment: $" + amount);
        status = "REFUNDED";
        logActivity("Refund processed: $" + amount);
    }

    @Override
    public double calculateTax() {
        this.tax = amount * 0.18;
        return tax;
    }

    @Override
    public void generateTaxInvoice() {
        System.out.println("\nTax Invoice:");
        System.out.println("Transaction: Credit Card");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount: $" + amount);
        System.out.println("GST (18%): $" + tax);
        System.out.println("Total: $" + (amount + tax));
    }

    @Override
    public void logActivity(String action) {
        System.out.println("[LOG] Credit Card: " + action + " at " + new java.util.Date());
    }

    public static void main(String[] args) {

        CreditCardPayment payment = new CreditCardPayment("1234-5678-9012-3456");

        payment.processPayment(1000);

        System.out.println("Payment Status: " + payment.getPaymentStatus());

        payment.calculateTax();
        payment.generateTaxInvoice();

        payment.refundPayment(1000);

        System.out.println("Payment Status: " + payment.getPaymentStatus());
    }
}