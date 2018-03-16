package practice.userController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import practice.commonView.ResponseView;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;
import practice.userView.UserView;

/**
 * Created by sergi on 15.03.2018.
 */
public interface UserController {
    /**
     * Register in a system
     *  @param userView
     * @return JSON success check
     */
    ResponseView register(@RequestBody UserView userView);

    /**
     * Activation a new user
     * @param code
     * @return JSON success check
     */
    ResponseView activation(@RequestParam(value="code", required=true) String code);

    /**
     * Login in a system
     * @param userView
     * @return JSON success check
     */
    ResponseView login(@RequestBody UserView userView);

}
