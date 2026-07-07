class Utility{
    public static <T> T getValue(T value){
        return value;
    }
    
}

public class Program_03_generics_method{
    public static void main(String [] args){
        String name = Utility.getValue("Luv");
        Integer age = Utility.getValue(21);
        Double salary = Utility.getValue(50000.4);
        System.out.println(name);
        System.out.println(age);
        System.out.println(salary);
    }
}