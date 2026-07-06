import java.util.*;
public class Program_01_BinarySearch{

    public static void main(String [] args){
       
        int [] employeeId = {100 , 111 , 223};
        int index = Arrays.binarySearch(employeeId , 111);
        if(index > -1){
            System.out.println("Employee exists");
        }
        else{
            System.out.println("Employee not exists");
        }
    }
}
