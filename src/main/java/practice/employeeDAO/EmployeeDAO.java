package practice.employeeDAO;

import practice.employeeModel.Employee;
import practice.employeeView.EmployeeInView;
import practice.employeeView.EmployeeView;
import practice.officeModel.Office;
import practice.officeView.OfficeInView;
import practice.officeView.OfficeView;

import java.util.List;

/**
 * Created by sergi on 14.03.2018.
 */
public interface EmployeeDAO {
    List<Employee> getEmployees(EmployeeInView employeeInView);

    Employee getEmp(long id);

    boolean update(EmployeeView employeeView);

    boolean save(EmployeeView employeeView);

    boolean delete(long id);
}
