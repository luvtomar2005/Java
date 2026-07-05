class Account {

    // Private Fields (Encapsulation)
    private String number;
    private double balance;
    private String customerName;
    private String customerEmail;

    // 1. DEFAULT CONSTRUCTOR (Chained)
    public Account() {
        this("99999", 50.0, "Default Name", "default@email.com");
        System.out.println("Empty constructor called (Defaults applied via chaining).");
    }

    // 2. MAIN CONSTRUCTOR
    public Account(String number,
                   double balance,
                   String customerName,
                   String customerEmail) {
        System.out.println("Account constructor with parameters called.");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    // Deposit Method
    public void depositFunds(double depositAmount) {
        balance += depositAmount;
        System.out.println("Deposit of $" + depositAmount +
                " made. New balance = $" + balance);
    }

    // Withdraw Method
    public void withdrawFunds(double withdrawalAmount) {
        if (balance - withdrawalAmount < 0) {
            System.out.println("Insufficient Funds! You only have $" + balance);
        } else {
            balance -= withdrawalAmount;
            System.out.println("Withdrawal of $" + withdrawalAmount +
                    " processed. Remaining balance = $" + balance);
        }
    }

    // --- GETTERS AND SETTERS ---
    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
} // <--- Added this bracket to CLOSE the Account class properly!

public class Program_05_constructor_chaining {
    public static void main(String[] args) {
        System.out.println("--- Creating Tim's Account (Using Default Constructor) ---");
        Account timAccount = new Account();

        System.out.println("\n--- Tim's Account Details ---");
        System.out.println("Customer Name:  " + timAccount.getCustomerName());
        System.out.println("Account Number: " + timAccount.getNumber());
        System.out.println("Starting Bal:   $" + timAccount.getBalance());

        System.out.println("\n-------------------------------------------------------\n");

        System.out.println("--- Creating Bob's Account (Using Parameterized Constructor) ---");
        Account bobAccount = new Account("12345", 1000.0, "Bob", "bob@gmail.com");

        System.out.println("\n--- Bob's Account Details ---");
        System.out.println("Customer Name:  " + bobAccount.getCustomerName());
        System.out.println("Starting Bal:   $" + bobAccount.getBalance());
    }
}