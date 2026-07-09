import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private boolean active;

    public Employee(int id , String name, String department , double salary , boolean active){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary () { return salary; }
    public boolean isActive () { return active; }

    @Override
    public String toString(){
        // FIXED: Corrected the format string placeholders and alignment variables
        return String.format("Employee {id = %d, name = '%s', dept = '%s', salary = %.0f, active = %b}", 
                             id, name, department, salary, active);
    }
}

public class Program_09_Terminal_Operators {
    public static void main(String[] args) {
        
        List<Employee> employees = List.of(
            new Employee(101, "Rahul", "IT", 60000, true),
            new Employee(102, "Amit", "HR", 45000, true),
            new Employee(103, "Neha", "IT", 80000, false),
            new Employee(104, "Priya", "Finance", 70000, true),
            new Employee(105, "Vikas", "IT", 60000, true),
            new Employee(106, "Rahul", "IT", 60000, true) // duplicate name
        );

        // 1. filter
        System.out.println("\n========== filter() ===========");
        employees.stream().filter(Employee::isActive).forEach(System.out::println);

        // 2. map
        System.out.println("\n ========= map() ==========");
        employees.stream().map(Employee::getName).forEach(System.out::println);

        // 3. distinct
        System.out.println("\n ============ distinct() ========");
        employees.stream().map(Employee::getName).distinct().forEach(System.out::println);

        // 4. Sorted
        System.out.println("\n ========= sorted() ==========");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        System.out.println("\n ====== sorted(descending) =========");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

        // 5 & 6. peek()
        System.out.println("\n ========= peek() ==========");
        employees.stream()
                .filter(Employee::isActive)
                .peek(emp -> System.out.println("After Filter : " + emp.getName()))
                .map(Employee::getName)
                .forEach(System.out::println);

        // 7. limit()
        System.out.println("\n========== limit() ==========");
        employees.stream().limit(3).forEach(System.out::println);

        // 8. skip()
        System.out.println("\n========== skip() ==========");
        employees.stream().skip(2).forEach(System.out::println);

        // 9. Pagination (skip + limit)
        System.out.println("\n========== Pagination ==========");
        employees.stream().skip(2).limit(2).forEach(System.out::println);

        // 10. collect() / toList()
        System.out.println("\n========== collect() ==========");
        List<String> activeEmployees = employees.stream()
                .filter(Employee::isActive)
                .map(Employee::getName)
                .toList();
        System.out.println(activeEmployees);

        // 11. count()
        System.out.println("\n========== count() ==========");
        long count = employees.stream().filter(Employee::isActive).count();
        System.out.println("Active Employees = " + count);

        // 12. reduce()
        System.out.println("\n========== reduce() ==========");
        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("Total Salary = " + totalSalary);

        // 13. min()
        System.out.println("\n========== min() ==========");
        employees.stream().min(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

        // 14. max()
        System.out.println("\n========== max() ==========");
        employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

        // 15. findFirst()
        System.out.println("\n========== findFirst() ==========");
        employees.stream().filter(Employee::isActive).findFirst().ifPresent(System.out::println);

        // 16. findAny()
        System.out.println("\n========== findAny() ==========");
        employees.stream().filter(Employee::isActive).findAny().ifPresent(System.out::println);

        // 17. anyMatch()
        System.out.println("\n========== anyMatch() ==========");
        boolean anyHighSalary = employees.stream().anyMatch(emp -> emp.getSalary() > 75000);
        System.out.println(anyHighSalary);

        // 18. allMatch()
        System.out.println("\n========== allMatch() ==========");
        boolean allActive = employees.stream().allMatch(Employee::isActive);
        System.out.println(allActive);

        // 19. noneMatch()
        System.out.println("\n========== noneMatch() ==========");
        boolean noneNegativeSalary = employees.stream().noneMatch(emp -> emp.getSalary() < 0);
        System.out.println(noneNegativeSalary);

        // 20. groupingBy()
        System.out.println("\n========== groupingBy() ==========");
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        grouped.forEach((department, employeeList) -> {
            System.out.println(department + " -> " + employeeList);
        });

        // 21. joining()
        System.out.println("\n========== joining() ==========");
        String namesCombined = employees.stream()
                .map(Employee::getName)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(namesCombined);
    }
}