package practice.orgModel;

import practice.officeModel.Office;

import javax.persistence.*;
import java.util.Set;
/**
 * Created by sergi on 03.03.2018.
 */

/**
 * Организация
 */
@Entity(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "inn")
    private String inn;

    @Column(name = "kpp")
    private String kpp;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Office> offices;

    public void addOffice(Office office)
    {
        getOffices().add(office);
        office.setOrganization(this);
    }

    public void removeOffice(Office office)
    {
        getOffices().remove(office);
        office.setOrganization(null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setPersons(Set<Office> offices) {
        this.offices = offices;
    }




}
