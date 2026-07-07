
class DataStore<T>{
    private T data;
    public DataStore(T data){
        this.data = data;
    }
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return data;
    }
    public void displayType(){
        System.out.println("Stored Value " + data);
        System.out.println(" Type : " + data.getClass().getSimpleName());
        System.out.println("----------------------");
    }

}
class Student {
    private int id;
    private String name;
    public Student(int id , String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString(){
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class Program_01_generics {
    public static void main(String [] args){
        DataStore<String> nameStore = new DataStore<>("Luv");
        DataStore<Integer> ageStore = new DataStore<>(21);
        DataStore<Student> studentStore = new DataStore<>(new Student(101 , "Rahul"));

        nameStore.displayType();
        ageStore.displayType();
       
        studentStore.displayType();

        String name = nameStore.getData();

        Integer age = ageStore.getData();

        Student student = studentStore.getData();

        System.out.println(name);
        System.out.println(age);
        System.out.println(student);
    }
    
}
