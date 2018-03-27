package practice.model.countriesModel;

import practice.model.employeeModel.Address;
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
    private Set<Address> addresses;

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address)
    {
        getAddresses().add(address);
        address.setCountry(this);
    }

    public void removeAddress(Address address)
    {
        getAddresses().remove(address);
        address.setCountry(null);
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
