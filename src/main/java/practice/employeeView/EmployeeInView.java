package practice.employeeView;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by sergi on 15.03.2018.
 */
public class EmployeeInView {
    public Long officeId;

    public String firstName;

    public String middleName;

    public String lastName;

    public String position;

    public String docCode;

    public String citizenshipCode;

    //для jackson
    public EmployeeInView() {

    }
}
