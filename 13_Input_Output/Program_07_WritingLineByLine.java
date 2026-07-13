import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program_07_WritingLineByLine {

    public static void main(String[] args) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter("student.txt"))) {

            bw.write("Hello");
            bw.newLine();
            bw.write("Java");

        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }

}