package practice.employeeController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import practice.commonView.ResponseView;
import practice.employeeView.EmployeeInView;
import practice.employeeView.EmployeeView;

/**
 * Created by sergi on 14.03.2018.
 */
public interface EmployeeController {
    /**
     * Get employees by params
     *  @param employeeInView
     * @return JSON employees value
     */
    ResponseView getEmployees(@RequestBody EmployeeInView employeeInView);

    /**
     * Get employee by ID
     * @param id
     * @return JSON employee value
     */
    ResponseView getEmp(@PathVariable("id") int id);

    /**
     * Update employee
     * @param employeeView
     * @return JSON success check
     */
    ResponseView update(@RequestBody EmployeeView employeeView);

    /**
     * Save employee
     * @param employeeView
     * @return JSON success check
     */
    ResponseView save(@RequestBody EmployeeView employeeView);

    /**
     * Delete employee
     * @param id
     * @return JSON success check
     */
    ResponseView delete(@PathVariable("id") int id);
}
