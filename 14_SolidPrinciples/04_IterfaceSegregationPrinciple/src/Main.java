/* A class should implement only the interfaces it actually needs. 
Large interfaces should be split into smaller, focused interfaces so that
 no class is forced to implement unnecessary methods. */

public class Main {

    public static void main(String[] args) {

        Cook chef = new Chef();
        Serve waiter = new Waiter();
        Clean cleaner = new Cleaner();

        chef.cook();
        waiter.serveCustomer();
        cleaner.washDishes();

    }

}