class Bank{
    public void processTransaction() {
        class Validator{
            public void validate() {
                System.out.println("Transaction Validated ");
            }
        }
        Validator  validator = new Validator();
        validator.validate();
    }
}

/**
 * Program_03_LocalClass
 */
public class Program_03_LocalClass {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.processTransaction();
    }
}