// this question was asked in readiness test on friday -> 12/06/26

import java.util.Scanner;

public class numeric_pasword_generation {

    static int[][] moves = {
        {0, 8}, // 0
        {1, 2, 4}, // 1
        {1, 2, 3, 5}, // 2
        {2, 3, 6}, // 3
        {1, 4, 5, 7}, // 4
        {2, 4, 5, 6, 8}, // 5
        {3, 5, 6, 9}, // 6
        {4, 7, 8}, // 7
        {0, 5, 7, 8, 9}, // 8
        {6, 8, 9} // 9
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        for(int digit = 0;digit < n;digit++){
            total += countPasswords(digit, 9);
        }
        System.out.println(total);
    }
    private static int countPasswords(int digit, int length){
        if(length == 1){
            return 1;
        }
        int count =0;
        for(int next : moves[digit]){
            count += countPasswords(next , length - 1);
        }
        return count;
    }

}


