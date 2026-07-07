// interface Animal {
interface Animal{
    void sound();
}

public class Progam_04_AnonymysClass {

    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void sound () {
                System.out.println("Dog Barks ");
            }
        };
        animal.sound();
    }
}

