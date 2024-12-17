

import java.net.URI;
import org.springframework.beans
        .factory.annotation.Autowired;
import org.springframework.http
        .ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet
        .support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping(
            path = "/",
            produces = "employee"
    )

    public Employees getEmployees(){
        return employeeManager.getAllEmployees();
    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json"
    )

    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        // Creating an employee_id as a String, based on the number of employees
        String employeeId = "EMP" + (employeeManager.getAllEmployees().getEmployees().size() + 1);

        // Set the employee_id as a String
        employee.setEmployee_id(employeeId);

        // Add the employee to the DAO
        employeeManager.addEmployee(employee);

        // Build the URI for the newly created resource
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{employee_id}")
                .buildAndExpand(employee.getEmployee_id())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

}
