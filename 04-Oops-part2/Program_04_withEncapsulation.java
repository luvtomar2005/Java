class BankAccount{
    private String accountHolder;
    private int accountNumber;
    private double balance;
    public BankAccount(String accountHolder , int accountNumber , double balance){

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("rupees" + amount + "deposited");
        }
        else{
            System.out.println("Invalid deposit amount  ");
        }
    }
    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient balance : ");

        }
        else if(amount > 0){
            System.out.println("invalid withdrawl amount ");
        }
        else{
            balance -= amount;
            System.out.println(amount + " withdrawn ");
        }
    }
    public double getBalance(){
        return balance;
    }
    public void displayAccount(){
        System.out.println("Account Holder " + accountHolder);  
        System.out.println("Account Number " + accountNumber);
    }
}

public class Program_04_withEncapsulation {

    public static void main(String[] args) {
        BankAccount account  = new BankAccount("Luv Tomar" , 12345 , 5000);
        account.displayAccount();
        account.deposit(2000);
        account.withdraw(3000);
         System.out.println("Current Balance = " + account.getBalance());
    }
}

