package practice.view.officeView;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sergi on 17.03.2018.
 */
public class OfficeInView {
    public Long orgId;

    public String name;

    public String phone;

    public Boolean isActive;

    //для jackson
    public OfficeInView() {

    }
}
