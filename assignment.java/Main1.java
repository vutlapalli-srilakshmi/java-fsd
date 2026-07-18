import java.util.*;
import java.util.stream.Collectors;

class Main1 {
    private String name;
    private int salary;

    // Constructor
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}

public class Main1 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Ravi", 45000),
                new Employee("Anu", 60000),
                new Employee("Kiran", 75000),
                new Employee("Neha", 40000),
                new Employee("Priya", 55000)
        );

        List<String> result = employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("Employees with salary greater than 50000:");
        System.out.println(result);
    }
}