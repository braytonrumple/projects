

import java.util.*;

public class Employees {
    private List<Employee> employeeList;

    public List<Employee> getEmployees() {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployees(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
