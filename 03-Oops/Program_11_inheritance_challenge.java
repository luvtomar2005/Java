class Worker {

    private String name;
    private String birthDate;
    protected String endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {

        int currentYear = 2025;
        int birthYear = Integer.parseInt(birthDate.substring(6));

        return currentYear - birthYear;
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void displayWorker() {

        System.out.println("----- Worker Details -----");
        System.out.println("Name       : " + name);
        System.out.println("Birth Date : " + birthDate);
        System.out.println("Age        : " + getAge());

        if (endDate == null) {
            System.out.println("Status     : Currently Working");
        } else {
            System.out.println("End Date   : " + endDate);
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
class Employee extends Worker {

    private long employeeId;
    private String hireDate;

    public Employee(String name,
                    String birthDate,
                    long employeeId,
                    String hireDate) {

        super(name, birthDate);

        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getHireDate() {
        return hireDate;
    }

    @Override
    public double collectPay() {

        System.out.println("Employee collected base pay.");

        return super.collectPay();
    }

    public void displayEmployee() {

        displayWorker();

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Hire Date  : " + hireDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
public class Program_11_inheritance_challenge {

    public static void main(String[] args) {

         Employee employee = new Employee(
                "Luv",
                "14/02/2005",
                1001,
                "01/07/2025"
        );

        System.out.println("===== Employee Information =====");
        employee.displayEmployee();

        System.out.println();

        System.out.println("Collecting Salary...");
        System.out.println("Amount Paid : " + employee.collectPay());

        System.out.println();

        System.out.println("Using toString()");
        System.out.println(employee);

        System.out.println();

        System.out.println("Terminating Employee...");
        employee.terminate("31/12/2035");

        System.out.println();

        employee.displayEmployee();
    }
}