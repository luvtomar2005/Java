// How we can access private static variable without creating object
// Just make the function static 

class Demo{
    private static int x;
    static void f1(){
        x = 5;
    }
}

public class program_05_interview_questions {
    public static void main(String[] args) {
        Demo.f1();
    }
}
