/* Hiding implementation details and showing only essential functionality. */

// In java abstraction can be achieved by using abstract classes and inteface
abstract class Vehicle {

    abstract void start();

    // normal method
    void fuelType() {
        System.out.println("Vehicle needs fuel or batttery ");
    }
}

class Car extends Vehicle {

    // Providing implementation
    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle {

    @Override
    void start() {
        System.out.println("Bike starts with self-start button");
    }
}

public class program_19_abstraction {

    public static void main(String[] args) {
        Vehicle v1 = new Car();

        Vehicle v2 = new Bike();

        v1.start();

        v2.start();

        v1.fuelType();
    }
}



/* real world example You drive a car using:
- steering
- brake
- accelerator
But you do not know:
- engine combustion
- fuel injection
- gearbox internals */

/* But parent class does not define implementation.
Because every vehicle starts differently.
So child classes provide implementation.
This is abstraction. */