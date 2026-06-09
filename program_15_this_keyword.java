class Example{
    private int x , y;

    // this.x and this.y refer to object variables
    // x and y on right side are method parameters
    // used to remove ambiguity between local and instance variables
    void f1(int x , int y){
        this.x = x;
        this.y = y;
    }

    // prints object variables
    void display(){
        System.out.println(x);
        System.out.println(y);
    }
}

public class program_15_this_keyword {
    public static void main(String[] args) {

        // object creation
        Example e1 = new Example();

        // assigns values to object variables
        e1.f1(55 , 66);

        // displays assigned values
        e1.display();
    }
}

/* this keyword in Java is a reference variable that refers to 
the current object of the class.

Then immediately explain its main use:

It is mainly used to differentiate instance variables from local variables
 when both have the same name. */