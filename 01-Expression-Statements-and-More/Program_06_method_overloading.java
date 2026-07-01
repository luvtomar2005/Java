public class Program_06_method_overloading {
    public static void main(String[] args) {
        calculateScore("Virat", 10);
        calculateScore2(100);
    }
    public static void calculateScore(String playerName , int score){
        System.out.println("Player " + playerName + " scored " + score + " in the test series");
    }
    public static void calculateScore2(int score){
        System.out.println("Player scored " + score);
    }
}

/* Method overloading is deining mehtod with same name and same class but with different
parameters lists . The method are distinguish by not of types order or list 

how does java identify method overloading ? -> not by return type
Java identifies the method by the method structure how it is being created and how it being called
and by which parameters it is being called...

Some programming languages allow methods to define default values for parameters, meaning if the caller doesn't provide a value, the default is used automatically. Java does not support 
default parameter values. 
Instead, Java achieves similar functionality using method overloading.

*/