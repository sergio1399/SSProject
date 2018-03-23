package practice.model.countriesModel;

import practice.model.employeeModel.Employee;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sergi on 04.03.2018.
 */
@Entity(name = "Countries")
public class Country {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {

        this.employees = employees;
    }

    public void addEmployee(Employee employee)
    {
        getEmployees().add(employee);
        employee.setCountry(this);
    }

    public void removeEmployee(Employee employee)
    {
        getEmployees().remove(employee);
        employee.setCountry(null);
    }

    public Long getId() {
        return id;
    }

    @Column(name = "code",
            nullable = false)
    private String code;

    @Column(name = "name",
            nullable = false)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country()
    {

    }
}
