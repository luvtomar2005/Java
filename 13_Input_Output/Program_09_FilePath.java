import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
public class Program_09_FilePath {

    public static void main(String[] args) {
        try {
            Path filePath = Path.of("student.txt");

            if(!Files.exists(filePath)){
                Files.createFile(filePath);
                System.out.println("File Created");
            }
            else{
                System.out.println("File Already Exists");
            }
            Files.writeString(filePath ,"Name  : Luv\nAge : 21\nCourse : Java");
            System.out.println("Data Written Successfully ");

            String data = Files.readString(filePath);
            System.out.println(data);
            // Copy file
            Path backupPath = Path.of("student_backup.txt");
            Files.copy(filePath , backupPath , StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup file created  ");
            // MOve or rename
            Path renamePath = Path.of("student_new.txt");
            Files.move(filePath , renamePath , StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File Renamed");
            Files.delete(backupPath);
            System.out.println("Backup file removed : ");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



