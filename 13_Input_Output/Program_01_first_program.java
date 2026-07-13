import java.io.FileWriter;
import java.io.IOException;
public class Program_01_first_program {
    public static void main(String [] args){
        try(FileWriter writer = new FileWriter("message.txt")){
            writer.write("Hello Java I/O! ");
            System.out.println("File Written Successfully");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
