
import javax.sound.sampled.SourceDataLine;

public class Program_04_casting {
    public static void main(String[] args) {
        short myMinShortValue = Short.MIN_VALUE; int myMinIntValue = Integer.MIN_VALUE;
        // If we have put the comma above then it would have give the error
        int myIntShortValue = Integer.MIN_VALUE  , myMaxIntValue = Integer.MAX_VALUE;

        System.err.println((myIntShortValue)  + (myMaxIntValue));
    }
}

/* If you declare multiple variables of same data types in a single statement  , you must
specify the data type only once before any variable names.

*/
