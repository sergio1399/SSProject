package practice.employeeService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import practice.employeeDAO.EmployeeDAO;
import practice.employeeService.EmployeeService;
import practice.employeeView.EmployeeInView;
import practice.employeeView.EmployeeView;
import practice.orgDAO.OrgDAO;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<EmployeeView> getEmployees(EmployeeInView employeeInView) {
        return null;
    }

    @Override
    public EmployeeView getEmp(int id) {
        return null;
    }

    @Override
    public boolean update(EmployeeView employeeView) {
        return false;
    }

    @Override
    public boolean save(EmployeeView employeeView) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
