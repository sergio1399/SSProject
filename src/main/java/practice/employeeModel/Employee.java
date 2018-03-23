package practice.employeeModel;

import practice.countriesModel.Country;
import practice.docsModel.Document;
import practice.officeModel.Office;
import practice.userModel.User;

import javax.persistence.*;

/**
 * Created by sergi on 03.03.2018.
 */
@Entity(name = "Employee")
public class Employee {
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
    @JoinColumn(name = "office_id")
    private Office office;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countries_id")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {

        this.document = document;

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToOne( mappedBy = "employee",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {

        this.user = user;
        user.setEmployee(this);
    }

    @Basic(optional = false)
    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private String phone;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee()
    {

    }

    public Employee(Long id, String firstName, String lastName, String middleName, String position, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
    }

    public Employee(String firstName, String lastName, String middleName, String position, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
    }
}
