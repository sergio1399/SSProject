package practice.employeeView;

import com.fasterxml.jackson.annotation.JsonInclude;
import practice.employeeModel.Employee;

import java.util.Date;

/**
 * Employee data view
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeView {
    public Long id;

    public Long officeId;

    public String firstName;

    public String middleName;

    public String lastName;

    public String position;

    public String phone;

    public String docCode;

    public String docName;

    public String docNumber;

    public Date docDate;

    public String citizenshipName;

    public String citizenshipCode;

    public Boolean isIdentified;

    //для jackson
    public EmployeeView() {

    }

}
