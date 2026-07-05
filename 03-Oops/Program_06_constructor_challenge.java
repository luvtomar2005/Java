class Customer {
    private String name;
    private double creditLimit;
    private String email;

    // 1. NO-ARG CONSTRUCTOR (Chains to the Master constructor with 3 defaults)
    public Customer() {
        this("Default Name", 500.0, "default@email.com");
    }

    // 2. 2-ARG CONSTRUCTOR (Takes name and email, chains to Master with default credit)
    public Customer(String name, String email) {
        this(name, 1000.0, email); // We pass a default 1000.0 credit limit here
    }

    // 3. 3-ARG CONSTRUCTOR (The Master Constructor - actually assigns the fields)
    public Customer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit; // Typo fixed here
        this.email = email;
    }

    // --- GETTERS ---
    public String getName() {
        return name;
    }

    public double getCreditLimit() { // Standardized name to getCreditLimit
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}

public class Program_06_constructor_challenge {
    public static void main(String[] args) {
        
        // Testing the 3-argument constructor
        Customer customer1 = new Customer("Tim", 1000.0, "tim@gmail.com");
        System.out.println("--- Customer 1 (All details provided) ---");
        System.out.println("Name: " + customer1.getName());
        System.out.println("Limit: $" + customer1.getCreditLimit());
        System.out.println("Email: " + customer1.getEmail());

        System.out.println("\n----------------------------------------\n");

        // Testing the 2-argument constructor (Uses default credit limit of 1000.0)
        Customer customer2 = new Customer("Luv", "luv@gmail.com");
        System.out.println("--- Customer 2 (No limit provided) ---");
        System.out.println("Name: " + customer2.getName());
        System.out.println("Limit: $" + customer2.getCreditLimit()); // Automatically 1000.0
        System.out.println("Email: " + customer2.getEmail());
    }
}