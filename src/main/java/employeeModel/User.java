package employeeModel;

import javax.persistence.*;

/**
 * Created by sergi on 04.03.2018.
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Employee employee;

    @Column(name = "name",
            nullable = false)
    private String name;

    @Column(name = "login",
            nullable = false)
    private String login;

    @Column(name = "password",
            nullable = false)
    private String password;

    @Column(name = "role")
    private String role;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public User() {

    }
}