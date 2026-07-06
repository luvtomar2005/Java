public class Program_02_reference {
    public static void main(String[] args) {
        int [] arr = new int[]{1 , 2,  3, 4};
        int [] again = arr;
        arr[0] = 100;
        System.out.println(again[0]);
    }
}
/* They are pointing to the same refrence ... that's why we got the value as 100 */


