
class Nokia1{
    int x, y;

    Nokia1() {
        System.out.println("Parent's constructor is executed");
    }
    
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

    public Nokia2() {
        super(); 
        /* 'super()' invokes the constructor of the immediate parent class (Nokia1).
         Even if you omit 'super()', the Java compiler implicitly inserts it 
         as the very first line of a child constructor. */
        System.out.println("Child's constructor executed");
    }
    
}

public class program_14_inheritance_using_constructor {
    public static void main(String[] args) {
        
    }
}
