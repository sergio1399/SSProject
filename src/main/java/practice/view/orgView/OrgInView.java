package practice.view.orgView;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sergi on 13.03.2018.
 */
public class OrgInView {
    public  String name;

    public  String inn;

    public boolean isActive;

    //для jackson
    public OrgInView() {

    }
}