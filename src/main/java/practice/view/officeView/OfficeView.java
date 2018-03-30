package practice.view.officeView;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Office data view
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeView {
    public Long id;

    public Long orgId;

    public String name;

    public String address;

    public String phone;

    public Boolean isActive;

    //для jackson
    public OfficeView() {

    }

    public OfficeView(Long orgId, String name, String address, String phone, Boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "OfficeView{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
