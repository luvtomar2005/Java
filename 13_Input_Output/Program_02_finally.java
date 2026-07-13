public class Program_02_finally {
    public static void main(String[] args) {
        try{
            System.out.println("Inside the try block");
            int result = 10 / 0;

        }
        catch(ArithmeticException e){
            System.out.println("Exception Handled ");
        }
        finally {
            System.out.println("Finally Block executed");
        }
        System.out.println("Program Continues ");
    }
}
