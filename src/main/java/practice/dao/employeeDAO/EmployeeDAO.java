package practice.dao.employeeDAO;

import practice.model.employeeModel.Employee;
import practice.utils.MyAppException;
import practice.view.employeeView.EmployeeInView;
import practice.view.employeeView.EmployeeView;

import java.util.List;

/**
 * Created by sergi on 14.03.2018.
 */
public interface EmployeeDAO {
    List<Employee> getEmployees(EmployeeInView employeeInView);

    Employee getEmp(long id) throws MyAppException;

    boolean update(EmployeeView employeeView) throws MyAppException;

    boolean save(EmployeeView employeeView) throws MyAppException;

    boolean delete(long id) throws MyAppException;
}
