public class Program_01{
    public static void main(String[] args) {
        double value1 = 10000 * 5;
        int highScore = 1000;
        if(highScore > 3){
            highScore = 100 + highScore;
        }
        int health = 25;
        if((health > 23) && (highScore > 300)){
            health = health + 100;
        }
    }
}

/* Exprrssion -> Expression an piece of code which returns some value
it may be either integer , float , true and false and etc and statements
is a complete instruction that jvm executes and its end with semicolon but the if else 
block is also a statement because it is something which is defined 
if we have to check how many expression are there just chekc which values are evaluation somehting

*/