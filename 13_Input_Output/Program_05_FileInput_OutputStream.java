
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Program_05_FileInput_OutputStream {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("output.txt")){
            String text = "Hello Java";
            fos.write(text.getBytes(StandardCharsets.UTF_8));
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
