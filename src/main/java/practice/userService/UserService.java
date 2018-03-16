package practice.userService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import practice.commonView.ResponseView;
import practice.userView.UserView;

/**
 * Created by sergi on 15.03.2018.
 */
public interface UserService {

    boolean register(UserView userView);

    boolean activation(String code);

    boolean login(UserView userView);
}
