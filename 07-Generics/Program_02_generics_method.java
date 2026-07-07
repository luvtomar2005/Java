class Printer{
    public <T> void print(T value){
        System.out.println(value);
    }
  
}

public class Program_02_generics_method {

    public static void main(String[] args) {
        
        Printer printer = new Printer();
        printer.print("JAVA");
        printer.print(100);
        printer.print(45.6);
        printer.print(true);
    
    }
}