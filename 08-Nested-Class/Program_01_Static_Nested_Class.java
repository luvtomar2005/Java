class Car {

    // Static Variable (belongs to Car class)
    private static String company = "Tesla";

    // Instance Variable (belongs to each Car object)
    private String model;

    public Car(String model) {
        this.model = model;
    }

    // Static Nested Class
    static class Engine {

        private int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        public void displayCompany() {

            // Can access static member directly
            System.out.println("Company : " + company);
        }

        public void displayHorsePower() {
            System.out.println("Horse Power : " + horsePower);
        }

        public void displayCarModel(Car car) {

            // Cannot access model directly.
            // Need a Car object.

            System.out.println("Car Model : " + car.model);
        }

        /*
        This will NOT compile.

        public void test() {
            System.out.println(model);
        }

        Error:
        Cannot make a static reference to the non-static field model
        */
    }
}

/**
 * Program_01_Static_Nested_Class
 */
public class Program_01_Static_Nested_Class {
    public static void main(String[] args) {

        // Creating Car Object
        Car car = new Car("Model S");

        // Creating Engine Object
        // Notice: No Car object is needed here.
        Car.Engine engine = new Car.Engine(670);

        engine.displayCompany();

        engine.displayHorsePower();

        engine.displayCarModel(car);
    }
    
}

