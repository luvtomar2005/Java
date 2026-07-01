/**
 * Program_02_if_then
 */
public class Program_02_if_then {

        public static void main(String[] args) {

        // 1. Simple if statement
        int age = 20;

        if (age >= 18) {
            System.out.println("Eligible to vote");
        }

        // 2. if-else statement
        int marks = 45;

        if (marks >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // 3. else-if ladder
        int score = 82;

        if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 75) {
            System.out.println("Grade B");
        } else if (score >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade D");
        }

        // 4. Nested if
        boolean hasID = true;
        int personAge = 22;

        if (personAge >= 18) {
            if (hasID) {
                System.out.println("Entry Allowed");
            }
        }

        // 5. Logical AND (&&)
        int health = 25;
        int highScore = 500;

        if (health > 20 && highScore > 300) {
            System.out.println("Bonus Awarded");
        }

        // 6. Logical OR (||)
        boolean holiday = false;
        boolean weekend = true;

        if (holiday || weekend) {
            System.out.println("You can relax.");
        }

        // 7. Logical NOT (!)
        boolean raining = false;

        if (!raining) {
            System.out.println("Go for a walk.");
        }

        // 8. Comparison operators
        int x = 10;
        int y = 20;

        if (x < y) {
            System.out.println("x is smaller");
        }

        if (x <= y) {
            System.out.println("x is smaller or equal");
        }

        if (y > x) {
            System.out.println("y is greater");
        }

        if (y >= x) {
            System.out.println("y is greater or equal");
        }

        if (x != y) {
            System.out.println("Numbers are different");
        }

        // 9. Equality check for primitives
        int a = 100;
        int b = 100;

        if (a == b) {
            System.out.println("Equal");
        }

        // 10. Multiple conditions
        int salary = 60000;
        int experience = 3;

        if (salary > 50000 && experience >= 2) {
            System.out.println("Eligible for promotion");
        }

        // 11. Short-circuit evaluation
        int num = 10;

        if (num != 0 && (100 / num) > 5) {
            System.out.println("Safe division");
        }

        // 12. if with method call
        if (isEven(8)) {
            System.out.println("Even Number");
        }

        // 13. Empty if (legal but rarely useful)
        if (age > 10) {
        }

        // 14. Single-line if (without braces)
        if (age > 18)
            System.out.println("Adult");
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

}
