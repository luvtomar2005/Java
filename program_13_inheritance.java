
class Nokia1{
    int x, y;
    void f1(){
        System.out.println("Parent's function1 is executed");
    }

    void f2(){
        System.out.println("Parent's function2 is executed");
    }
}
class Nokia2 extends Nokia1{
    int z;
    void f3(){
        System.out.println("Child function1 is executed");
    }
}
public class program_13_inheritance {
    public static void main(String[] args) {
        Nokia2 n1 = new Nokia2();
        n1.f3();
        n1.f2();
        n1.f1();
    }
}
