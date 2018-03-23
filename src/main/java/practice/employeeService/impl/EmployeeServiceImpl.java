package practice.employeeService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.countriesModel.Country;
import practice.docsModel.Doc_types;
import practice.docsModel.Document;
import practice.employeeDAO.EmployeeDAO;
import practice.employeeModel.Address;
import practice.employeeModel.Employee;
import practice.employeeService.EmployeeService;
import practice.employeeView.EmployeeInView;
import practice.employeeView.EmployeeView;

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
        List<Employee> employeeList = employeeDAO.getEmployees(employeeInView);

        Function<Employee, EmployeeView> mapEmp = e -> {
            EmployeeView view = new EmployeeView();
            view.id = e.getId();
            view.firstName = e.getFirstName();
            view.lastName = e.getLastName();
            view.middleName = e.getMiddleName();
            view.position = e.getPosition();

            return view;
        };

        return employeeList.stream()
                .map(mapEmp)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeView getEmp(long id) {
        Employee employee = employeeDAO.getEmp(id);
        Document document = employee.getDocument();
        Doc_types dt = document.getDocType();
        Address address = employee.getAddress();
        Country country = address.getCountry();

        EmployeeView view = new EmployeeView();
        view.id = employee.getId();
        view.firstName = employee.getFirstName();
        view.middleName = employee.getMiddleName();
        view.lastName = employee.getLastName();
        view.position = employee.getPosition();
        view.phone = employee.getPhone();
        view.docNumber = document.getDocNumber();
        view.docDate = document.getDocDate();
        view.docName = dt.getName();
        view.isIdentified = document.isIdentified();
        view.citizenshipCode = country.getCode();
        view.citizenshipName = country.getName();

        return view;
    }

    @Override
    @Transactional
    public boolean update(EmployeeView employeeView) {

        return employeeDAO.update(employeeView);
    }

    @Override
    @Transactional
    public boolean save(EmployeeView employeeView) {

        return employeeDAO.save(employeeView);
    }

    @Override
    @Transactional
    public boolean delete(long id) {

        return employeeDAO.delete(id);
    }
}
