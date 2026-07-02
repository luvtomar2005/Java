
public class Program_04_sum_3_5_challenge {

    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        for(int i = 1;i<=1000;i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("Found Number" + i);

                sum += i;
                count++;
                if(count == 5){
                    break;
                }
            }
        }
        System.out.println("Sum : " + sum);
    }
    
}
/* Find speical id , print them , add them up printing 5 such id's */