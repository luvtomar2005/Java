// classes and objects
class B{
    private int mic;
    private int cam;
    void setValue(){
        mic = 2;
        cam = 2;

    }
    void display(){
        System.out.println(mic);
        System.out.println(cam);
    }
}


public class program_07 {
    public static void main(String[] args) {
        B b1 = new B();
        b1.display();
        b1.setValue();
        b1.display();

    }
}
