/* Command Line arguments in java */

public class program_09_cla {

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
    }
}



/* That String[] args isn't just boilerplate code you're forced to 
type—it is a literal array of Strings.

When you execute your program from the terminal, the Java Virtual Machine (JVM) takes anything you typed after the
 class name, chops it up based on spaces, and stuffs those pieces into that args array. */