package practice.view.orgView;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Created by sergi on 13.03.2018.
 */

public class OrgInView {
    public  String name;

    public String inn;

    public Boolean isActive;

    //для jackson
    public OrgInView() {

    }

    @Override
    public String toString() {
        return "OrgInView{" +
                "name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
