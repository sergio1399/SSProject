package practice.employeeModel;

import practice.officeModel.Office;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sergi on 14.03.2018.
 */
@Entity(name = "Address")
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees;

    public void addEmployee(Employee employee)
    {
        getEmployees().add(employee);
        employee.setAddress(this);
    }

    public void removeEmployee(Employee employee)
    {
        getEmployees().remove(employee);
        employee.setAddress(null);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Column(name = "address",
            nullable = false)
    private String address;

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
