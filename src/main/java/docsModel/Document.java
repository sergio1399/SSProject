package docsModel;

import employeeModel.Employee;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by sergi on 04.03.2018.
 */
@Entity(name = "Document")
public class Document {
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "document", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Employee> employees;

    public void setEmployees(Set<Employee> employees) {

        this.employees = employees;
        for (Employee employee: employees) {
            employee.setDocument(this);
        }
    }

    public void addEmployee(Employee employee)
    {
        getEmployees().add(employee);
        employee.setDocument(this);
    }

    public void removeEmployee(Employee employee)
    {
        getEmployees().remove(employee);
        employee.setDocument(null);
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_types_id")
    private Doc_types docType;

    public Doc_types getDocType() {
        return docType;
    }

    public void setDocType(Doc_types docType) {
        this.docType = docType;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Long getId() {
        return id;
    }

    @Column(name = "doc_number")
    private String docNumber;

    @Column(name = "doc_date")
    private Date docDate;

    @Column(name = "is_identified")
    private boolean isIdentified;

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    public Document()
    {

    }
}
