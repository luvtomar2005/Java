import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Program_10_DataOutputStream
 */
public class Program_10_DataOutputStream {

    public static void main(String[] args) {
        
        // ----------------------------
        // Writing Data
        // ----------------------------
        try (DataOutputStream out =
                     new DataOutputStream(
                             new FileOutputStream("employee.dat"))) {

            out.writeInt(101);
            out.writeUTF("Luv");
            out.writeDouble(85000.50);
            out.writeBoolean(true);

            System.out.println("✅ Data Written Successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        // ----------------------------
        // Reading Data
        // ----------------------------
        try (DataInputStream in =
                     new DataInputStream(
                             new FileInputStream("employee.dat"))) {

            int id = in.readInt();
            String name = in.readUTF();
            double salary = in.readDouble();
            boolean active = in.readBoolean();

            System.out.println("Employee Details");
            System.out.println("----------------");
            System.out.println("ID      : " + id);
            System.out.println("Name    : " + name);
            System.out.println("Salary  : " + salary);
            System.out.println("Active  : " + active);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
