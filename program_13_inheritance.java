
// Superclass (Parent Class)
class Vehicle {
    // Attributes of the parent
    String brand = "Ford";
    
    // Method of the parent
    public void honk() {
        System.out.println("Beep, beep!");
    }
}

// Subclass (Child Class) using the 'extends' keyword
class Car extends Vehicle {
    // Unique attribute for the child class
    String modelName = "Mustang";
}



public class program_13_inheritance {
    public static void main(String[] args) {
        // Create an object of the Car class
        Car myCar = new Car();

        // 1. Accessing a method from the parent (Vehicle) class
        myCar.honk(); 

        // 2. Accessing attributes from both parent and child classes
        System.out.println("Brand: " + myCar.brand);      // Inherited from Vehicle
        System.out.println("Model: " + myCar.modelName);  // Unique to Car
    }
}


