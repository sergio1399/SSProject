package practice.service.employeeService;

import practice.utils.MyAppException;
import practice.view.employeeView.EmployeeInView;
import practice.view.employeeView.EmployeeView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface EmployeeService {
    List<EmployeeView> getEmployees(EmployeeInView employeeInView);

    EmployeeView getEmp(long id) throws MyAppException;

    boolean update(EmployeeView employeeView) throws MyAppException;

    boolean save(EmployeeView employeeView) throws MyAppException;

    boolean delete(long id);
}
