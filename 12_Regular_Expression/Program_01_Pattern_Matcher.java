
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Program_01_Pattern_Matcher {
    public static void main(String [] args){
        String text = "Java17 Spring2026 SQL99";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println("Match     : " + matcher.group());
            System.out.println("Starts At : " + matcher.start());
            System.out.println("Ends At : " + matcher.end());
            System.out.println("------------------");
        }
    }
}
