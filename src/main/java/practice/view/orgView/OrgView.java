package practice.view.orgView;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

/**
 * Organization data view
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrgView {
    public Long id;

    public String name;

    public String fullName;

    public String inn;

    public String kpp;

    public String address;

    public String phone;

    public Boolean isActive;


    //для jackson
    public OrgView() {

    }

}
