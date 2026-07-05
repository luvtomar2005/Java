class BankAccount{
    public String accountHolder;
    public int accountNumber;
    public double balance;
    public void displayAccount(){
        System.out.println("Account Holder " + accountHolder);
        System.out.println("Account Number " + accountNumber);
        System.out.println("Balance " + balance);
    }
}
public class Program_03_withoutEncapsulation {
    public static void main(String [] args){
        BankAccount account = new BankAccount();
    account.accountHolder = "Luv Tomar";
    account.balance = 5000;
    account.displayAccount();
    System.out.println("\nSomeone changes the balance directly...");
    account.balance = -1000000;
    account.displayAccount();
    }
}

