package practice.view.userView;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sergi on 15.03.2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserView {

    public String login;

    public String password;

    public String name;

    //для jackson
    public UserView() {

    }
}
