package practice.service.userService;

import practice.view.userView.UserView;

/**
 * Created by sergi on 15.03.2018.
 */
public interface UserService {

    boolean register(UserView userView);

    boolean activation(String code);

    boolean login(UserView userView);
}
