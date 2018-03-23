package practice.dao.employeeDAO;

import practice.model.employeeModel.Employee;
import practice.view.employeeView.EmployeeInView;
import practice.view.employeeView.EmployeeView;

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
