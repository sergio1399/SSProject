package practice.officeModel;

import practice.employeeModel.Employee;
import practice.orgModel.Organization;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sergi on 03.03.2018.
 */
@Entity(name = "Office")
public class Office {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees;

    public void addEmployee(Employee employee)
    {
        getEmployees().add(employee);
        employee.setOffice(this);
    }

    public void removeEmployee(Employee employee)
    {
        getEmployees().remove(employee);
        employee.setOffice(null);
    }


    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Office()
    {

    }
}
