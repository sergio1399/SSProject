package practice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practice.model.countriesModel.Country;
import practice.model.docsModel.Doc_types;
import practice.model.docsModel.Document;
import practice.model.employeeModel.Address;
import practice.model.employeeModel.Employee;
import practice.view.countriesView.CountriesView;
import practice.view.employeeView.EmployeeView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 23.03.2018.
 */
public class EmployeeConverter {
    private static final Logger log = LoggerFactory.getLogger(EmployeeConverter.class);
    public static List<EmployeeView> toViewList(List<Employee> employees)
    {
        Function<Employee, EmployeeView> mapEmp = e -> {
            EmployeeView view = new EmployeeView();
            view.id = e.getId();
            view.firstName = e.getFirstName();
            view.lastName = e.getLastName();
            view.middleName = e.getMiddleName();
            view.position = e.getPosition();
            log.debug(view.toString());
            return view;
        };

        return employees.stream()
                .map(mapEmp)
                .collect(Collectors.toList());
    }

    public static EmployeeView toView(Employee employee){
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
        log.debug(view.toString());
        return view;
    }

    public static Employee toModel(EmployeeView employeeView){
        return new Employee(employeeView.firstName, employeeView.lastName, employeeView.middleName,
                employeeView.position, employeeView.phone);
    }

}
