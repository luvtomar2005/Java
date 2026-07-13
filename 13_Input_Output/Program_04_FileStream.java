import java.io.FileInputStream;
import java.io.IOException;
public class Program_04_FileStream {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("message.txt")){
            int data;
            while((data = fis.read()) != -1){
                System.out.println((char)data);
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
