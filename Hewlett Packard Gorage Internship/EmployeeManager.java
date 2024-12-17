
import org.springframework
        .stereotype
        .Repository;

@Repository
public class EmployeeManager {
    private static Employees list = new Employees();

    static {
        list.getEmployees().add(
                new Employee(
                        "1",
                        "Prem",
                        "Tiwari",
                        "chapradreams@gmail.com",
                        "CEO"
                ));
        list.getEmployees().add(
                new Employee(
                     "two",
                     "Vikash",
                     "Kumar",
                        "abc@gmail.com",
                        "CFO"
                ));
        list.getEmployees().add(
                new Employee(
                        "three",
                        "Ritesh",
                        "Ojha",
                        "asdjf@gmail.com",
                        "Treasurer"
                ));
    }
    public Employees getAllEmployees() {
        return list;
    }
    public void addEmployee(Employee employee) {
        list.getEmployees().add(employee);
    }
}
