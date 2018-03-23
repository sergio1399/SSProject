package practice.employeeService;

import practice.employeeModel.Employee;
import practice.employeeView.EmployeeInView;
import practice.employeeView.EmployeeView;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface EmployeeService {
    List<EmployeeView> getEmployees(EmployeeInView employeeInView);

    EmployeeView getEmp(long id);

    boolean update(EmployeeView employeeView);

    boolean save(EmployeeView employeeView);

    boolean delete(long id);
}
