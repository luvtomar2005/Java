public class Program_06_abbreviating_operator {

    public static void main(String[] args) {

        // ==========================================================
        // Compound (Abbreviating) Assignment Operators
        // Syntax:
        // variable operator= value;
        //
        // Example:
        // x += 5;  ==>  x = x + 5;
        // ==========================================================

        int x = 10;

        // Addition Assignment
        x += 5;          // x = x + 5
        System.out.println("x += 5  : " + x);   // 15

        // Subtraction Assignment
        x -= 3;          // x = x - 3
        System.out.println("x -= 3  : " + x);   // 12

        // Multiplication Assignment
        x *= 2;          // x = x * 2
        System.out.println("x *= 2  : " + x);   // 24

        // Division Assignment
        x /= 4;          // x = x / 4
        System.out.println("x /= 4  : " + x);   // 6

        // Modulus Assignment
        x %= 4;          // x = x % 4
        System.out.println("x %= 4  : " + x);   // 2

        // ==========================================================
        // Bitwise Compound Operators
        // ==========================================================

        int a = 6;       // Binary: 110

        a &= 3;          // 110 & 011 = 010
        System.out.println("a &= 3  : " + a);   // 2

        a |= 4;          // 010 | 100 = 110
        System.out.println("a |= 4  : " + a);   // 6

        a ^= 2;          // 110 ^ 010 = 100
        System.out.println("a ^= 2  : " + a);   // 4

        // ==========================================================
        // Shift Compound Operators
        // ==========================================================

        int n = 8;       // Binary: 1000

        n <<= 1;         // Left Shift (multiply by 2)
        System.out.println("n <<= 1 : " + n);   // 16

        n >>= 2;         // Right Shift (divide by 4)
        System.out.println("n >>= 2 : " + n);   // 4

        // ==========================================================
        // Important Interview Question
        // ==========================================================

        byte b = 10;

        // Valid because += performs an implicit cast
        b += 5;
        System.out.println("b += 5  : " + b);   // 15

        // Invalid:
        // b = b + 5;
        // Compile-time Error

        /*
         * Reason:
         *
         * byte + int -> int
         *
         * So Java sees:
         *
         * b = (int)(b + 5);
         *
         * Cannot assign int to byte without explicit casting.
         */

        // Correct way:
        b = (byte) (b + 5);
        System.out.println("Explicit Cast : " + b);   // 20

        // ==========================================================
        // Compound Assignment with String
        // ==========================================================

        String name = "Luv";

        name += " Tomar";
        System.out.println(name);      // Luv Tomar

        // Same as:
        // name = name + " Tomar";

        // ==========================================================
        // Summary
        // ==========================================================

        /*
         * +=   Addition Assignment
         * -=   Subtraction Assignment
         * *=   Multiplication Assignment
         * /=   Division Assignment
         * %=   Modulus Assignment
         * &=   Bitwise AND Assignment
         * |=   Bitwise OR Assignment
         * ^=   Bitwise XOR Assignment
         * <<=  Left Shift Assignment
         * >>=  Right Shift Assignment
         * >>>= Unsigned Right Shift Assignment
         */
    }
}