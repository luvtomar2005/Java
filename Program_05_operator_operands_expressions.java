
public class Program_05_operator_operands_expressions {

    public static void main(String[] args) {
        int a = 5 + 10;
        // Operators in java are to perform specific operation on oe or two and then return result a result
        // Operand is a term are used to describe any object that is manipulated by an operator

        char firstChar = 'A';
        char secondChar = 'B';
        System.out.println(firstChar + secondChar);
        /* There is no + operator defined for concatenating two chars.

Instead, Java performs numeric promotion.

Both chars are automatically converted to int. */

        System.out.println("" + firstChar + secondChar); // The output will be AB
        /* When Java sees

String + anything

it performs String concatenation instead of arithmetic. */
    }
}
