package practice.service.employeeService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.model.countriesModel.Country;
import practice.model.docsModel.Doc_types;
import practice.model.docsModel.Document;
import practice.dao.employeeDAO.EmployeeDAO;
import practice.model.employeeModel.Address;
import practice.model.employeeModel.Employee;
import practice.service.employeeService.EmployeeService;
import practice.utils.EmployeeConverter;
import practice.utils.MyAppException;
import practice.view.employeeView.EmployeeInView;
import practice.view.employeeView.EmployeeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 15.03.2018.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<EmployeeView> getEmployees(EmployeeInView employeeInView) {
        return EmployeeConverter.toViewList(employeeDAO.getEmployees(employeeInView));
    }

    @Override
    public EmployeeView getEmp(long id) throws MyAppException {
        Employee employee = employeeDAO.getEmp(id);
        Document document = employee.getDocument();
        Doc_types dt = document.getDocType();
        Address address = employee.getAddress();
        Country country = address.getCountry();

        return EmployeeConverter.toView(employee, document, dt, country);
    }

    @Override
    @Transactional
    public boolean update(EmployeeView employeeView) throws MyAppException {

        return employeeDAO.update(employeeView);
    }

    @Override
    @Transactional
    public boolean save(EmployeeView employeeView) throws MyAppException {

        return employeeDAO.save(employeeView);
    }

    @Override
    @Transactional
    public boolean delete(long id) {

        return employeeDAO.delete(id);
    }
}
