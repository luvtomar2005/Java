

public class Program_04_more_on_methods {
    public static void main(String[] args) {
        // we can also call this function such as
        boolean gameOver = true;
        int score = 3;
        int levelCompleted = 4;
        int bonus = 1;
        calculateScore(gameOver , score, levelCompleted , bonus);
    }
    private static void calculateScore(boolean gameOver , int score , int levelCompleted , int bonus){
        int finalScore = score;
        if(gameOver){
            finalScore += score + finalScore + 2;
            System.out.println("You final score is " + finalScore);
        }
        
    }
}
