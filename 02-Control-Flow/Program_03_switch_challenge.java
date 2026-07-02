public class Program_03_switch_challenge {
    public static void main(String[] args) {
        System.out.println(printNato('a'));
        System.out.println(printNato('s'));
        System.out.println(printNato('d'));
        System.out.println(printNato(''));
    }
    public static void printNato(char letter){
        switch(Character.toUpperCase(letter)){
            case 'A' -> System.out.println("Able");
            case 'B' -> System.out.println("Bravo");
            case 'C' -> System.out.println("Charlie");
            case 'D' -> System.out.println("Delta");

            default -> System.out.println("Letter Not found");
        }
    }    
    
}

