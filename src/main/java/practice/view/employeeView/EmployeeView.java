package practice.view.employeeView;

import com.fasterxml.jackson.annotation.JsonInclude;

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

    public EmployeeView(String firstName, String middleName, String lastName, String position, String phone, String docCode, String docName, String docNumber, Date docDate, String citizenshipName, String citizenshipCode, Boolean isIdentified) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    public EmployeeView(String firstName, String middleName, String lastName, String position, String phone, String docName, String docNumber, Date docDate, String citizenshipName, String citizenshipCode, Boolean isIdentified) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    @Override
    public String toString() {
        return "EmployeeView{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", docCode='" + docCode + '\'' +
                ", docName='" + docName + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate=" + docDate +
                ", citizenshipName='" + citizenshipName + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", isIdentified=" + isIdentified +
                '}';
    }
}
