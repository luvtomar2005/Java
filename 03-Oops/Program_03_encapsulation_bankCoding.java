class Account {

    // Private Fields (Encapsulation)
    private String number;
    private double balance;
    private String customerName;
    private String customerEmail;

    // Getter and Setter for Account Number
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // Getter and Setter for Balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter and Setter for Customer Name
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter and Setter for Customer Email
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
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
}

public class Program_03_encapsulation_bankCoding {

    public static void main(String[] args) {

        Account bobAccount = new Account();

        bobAccount.setNumber("123456789");
        bobAccount.setBalance(1000.00);
        bobAccount.setCustomerName("Bob Brown");
        bobAccount.setCustomerEmail("bob@gmail.com");

        System.out.println("Account Number : " + bobAccount.getNumber());
        System.out.println("Customer Name  : " + bobAccount.getCustomerName());
        System.out.println("Customer Email : " + bobAccount.getCustomerEmail());
        System.out.println("Balance        : $" + bobAccount.getBalance());

        System.out.println();

        bobAccount.depositFunds(500);

        bobAccount.withdrawFunds(300);

        bobAccount.withdrawFunds(1500);
    }
}