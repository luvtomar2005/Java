class Demo{
    private static int x;
    void f1(){
        x = 5;
    }
    public  static int getX(){
        return x;
    }
}

public class program_04 {
    public static void main(String[] args) {
        // Accessing private static variable by creating object
        Demo d1 = new Demo();
        d1.f1();
        System.out.println(Demo.getX());
    }
}
