package practice.employeeView;

import practice.employeeModel.Employee;

import java.util.Date;

/**
 * Employee data view
 *
 */
public class EmployeeView {
    public int id;

    public int officeId;

    public String firstName;

    public String middleName;

    public String secondName;

    public String position;

    public String phone;

    public String docName;

    public String docNumber;

    public Date docDate;

    public String citizenshipName;

    public String citizenshipCode;

    public boolean isIdentified;

    //для jackson
    public EmployeeView() {

    }

}
