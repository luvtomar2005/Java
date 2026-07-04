public class Program_05_digitSum{
    public static void main(String [] args){
        int n = 5897;
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        System.out.println("The sum of the digits is: " + sum);
    }
}