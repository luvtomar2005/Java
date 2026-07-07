class Car{
    private String model;
    public Car(String model){
        this.model = model;
    }
    class Engine{
        public void start() {
            System.out.println("Starting Engine of " + model);
        }
    }
}
public class Program_02_InnerClass {

    public static void main(String[] args) {
        Car car = new Car("Tesla Model S ");
        Car.Engine engine = car.new Engine();
        engine.start();
    }
}
