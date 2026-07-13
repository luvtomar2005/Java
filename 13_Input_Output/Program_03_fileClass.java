import java.io.File;
public class Program_03_fileClass {
    public static void main(String[] args) {
        File file = new File("write.txt");
        // System.out.println(file);
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
    }
}
