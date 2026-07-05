// class Vehicle {
class Vehicle{
    public void start() {
        System.out.println("Vehicle starts in a generic way  ");
    }
}
class Honda extends Vehicle{
    @Override
    public void start(){
        System.out.println("Honda starts with a key ");
    }
}

class Tesla extends Vehicle{
    @Override
    public void start(){
        System.out.println("Tesla starts silently  using electric power ");
    }
}

class BMW extends Vehicle{
    @Override
    public void start(){
        System.out.println("BMW starts with a push button ");
    }
}

public class Program_05_Polymorphisml {
    public static void main(String[] args) {
        Vehicle vehicle = new Honda();
        vehicle.start();
        System.out.println();
        vehicle = new Tesla();
        vehicle.start();
        System.out.println();
        vehicle = new BMW();
        vehicle.start();
        System.out.println();
        vehicle = new Vehicle();
        vehicle.start();
    }
    
}
