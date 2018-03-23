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
}
