import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Employee {
    String name;
    int age;
    Boolean isManager;

    Employee(String name, int age, Boolean isManager) {
        this.name = name;
        this.age = age;
        this.isManager=isManager;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(isManager, employee.isManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, isManager);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isManager=" + isManager +
                '}';
    }
}

class Manager {
    String name;
    int age;

    Manager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return age == manager.age && Objects.equals(name, manager.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Manager{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("John", 25, false),
                new Employee("Alice", 30,false),
                new Employee("Bob", 35, false)
        );

        List<Manager> managerList = Arrays.asList(
                new Manager("Alice", 30),
                new Manager("Charlie", 45),
                new Manager("John", 25)
        );

        // Checking if any employee is also a manager and has the same age
        employeeList.forEach(employee -> {
            boolean isManager = managerList.stream()
                    .anyMatch(manager -> manager.name.equals(employee.name) && manager.age == employee.age);

            employee.setManager(isManager);
            System.out.println(employee.name + " is manager: " + isManager);
        });

        System.out.println(employeeList);
    }
}

