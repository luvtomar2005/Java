class Parent{
    int x , y;
}

class Example extends Parent{

    // super.x and super.y refer to parent class variables
    void f1(int x , int y){
        super.x = x;
        super.y = y;
    }

    void display(){
        System.out.println(super.x);
        System.out.println(super.y);
    }
}



public class program_16_super_keyword {
    public static void main(String[] args) {
        Example e1 = new Example();

        e1.f1(55 , 66);

        e1.display();
    }
}


/* super keyword in Java is a reference variable used to 
refer to the immediate parent class object. */