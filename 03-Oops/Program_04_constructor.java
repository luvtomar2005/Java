class Account {

    // Private Fields (Encapsulation)
    private String number;
    private double balance;
    private String customerName;
    private String customerEmail;

    // Constructor
    public Account(String number,
                   double balance,
                   String customerName,
                   String customerEmail) {
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
    // (Allows safe access to private fields)

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

    
}

public class Program_04_constructor {
    public static void main(String[] args) {
        // Creating Bob's Account
        Account bobAccount = new Account(
                "12345",
                1000.0,
                "Bob",
                "bob@gmail.com"
        );
        System.out.println("=== Account Details ===");
        System.out.println("Customer Name:  " + bobAccount.getCustomerName());
        System.out.println("Account Number: " + bobAccount.getNumber());
        System.out.println("Email Address:  " + bobAccount.getCustomerEmail());
        System.out.println("Starting Bal:   $" + bobAccount.getBalance());
        System.out.println("=======================\n");

        // Performing Transactions
        bobAccount.depositFunds(500);   // Success
        bobAccount.withdrawFunds(300);  // Success
        bobAccount.withdrawFunds(1500); // Fails (Insufficient funds)
    }
}