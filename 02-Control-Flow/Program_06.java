class Program_06{
    public static void main(String [] args){
        int student = 1;
        do{
            System.out.println("Student " + student + " is present guyzz");
            student++; 
        }
        while(student >= 5);
    }
}
/* A do-while loop executes its body before evaluating the loop condition.
 Since the condition is checked only after
  the first execution, the loop body is guaranteed to run at least once,
   even if the condition is initially false. In contrast, a while loop 
evaluates the condition first and may not execute the body at all. */