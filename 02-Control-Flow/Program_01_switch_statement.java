public class Program_01_switch_statement {
    public static void main(String[] args) {
        int day = 3;
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid number");
        }
    }
}


/* A switch statement is a control-flow statement used to execute one block
of code from multiple possible options based on the value of an expression. 
It is generally used as a cleaner alternative to long if-else-if chains when
 comparing a single variable against multiple constant values. */
