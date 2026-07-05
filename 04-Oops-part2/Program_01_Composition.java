class Engine {
    private String model;
    
    public Engine(String model) {
        this.model = model;
    }
    
    public void start() {
        System.out.println(model + " engine has started.");
    }
    
    public void stop() {
        System.out.println(model + " engine has stopped.");
    }
}

class Car {
    private String brand;
    private Engine engine; // Composition: Car HAS-A Engine
    
    public Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }
    
    // Fixed: Handles starting the car
    public void startCar() {
        System.out.println("Starting " + brand + "...");
        engine.start();
        System.out.println(brand + " is ready to go.");
    }

    // Fixed: Added the missing stopCar method
    public void stopCar() {
        System.out.println("Stopping " + brand + "...");
        engine.stop();
        System.out.println(brand + " has stopped.");
    }
}

public class Program_01_Composition {
    public static void main(String[] args) {
        Engine engine = new Engine("Honda i-VTEC");
        Car car = new Car("Honda City", engine);

        car.startCar();
        System.out.println();
        car.stopCar();
    }
}