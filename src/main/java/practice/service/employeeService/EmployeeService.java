package practice.service.employeeService;

import practice.view.employeeView.EmployeeInView;
import practice.view.employeeView.EmployeeView;

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
