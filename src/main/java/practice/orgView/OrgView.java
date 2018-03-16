package practice.orgView;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

/**
 * Organization data view
 *
 */
public class OrgView {
    public int id;

    public String name;

    public String fullName;

    public String inn;

    public String kpp;

    public String address;

    public String phone;

    public boolean isActive;


    //для jackson
    public OrgView() {

    }

}
