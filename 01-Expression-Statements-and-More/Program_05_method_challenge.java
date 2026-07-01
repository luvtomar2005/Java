public class Program_05_method_challenge {
    public static void main(String[] args) {
        int position = calculateHighScorePosition(300);
        displayHighScorePosition("Luv", position);
    }
    public static void displayHighScorePosition(String playerName, int position){
        System.out.println(playerName + " Managed To get" + " into position " + position + " in the high scoere list");
    }
    public static int calculateHighScorePosition(int playerScore){
        if(playerScore >= 1000){
            return 1;
        }
        else if(playerScore >= 500 && playerScore < 1000){
            return 2;
        }
        else{
            return 3;
        }
    }
}
