class Student<T , U> {
    private T rollNumber;
    private U name;
    public Student(T rollNumber , U name){
        this.rollNumber = rollNumber;
        this.name = name;
    }
    public T getRollNumber() {
        return rollNumber;
    }
    public U getName(){
        return name;
    }
    public void display() {
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name : " + name);
    }

}   

public class Program_04_multiple_generics_method {

    public static void main(String[] args) {
        Student<Integer,String> student = new Student<>(101 , "LUV");
        student.display();
    }    

}