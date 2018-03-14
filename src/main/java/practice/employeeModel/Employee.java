package practice.employeeModel;

import practice.countriesModel.Country;
import practice.docsModel.Document;
import practice.officeModel.Office;

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

    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "second_name",
            nullable = false)
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "address")
    private String address;

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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
