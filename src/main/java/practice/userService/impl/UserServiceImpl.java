package practice.userService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import practice.orgDAO.OrgDAO;
import practice.userDAO.UserDAO;
import practice.userModel.User;
import practice.userService.UserService;
import practice.userView.UserView;

/**
 * Created by sergi on 15.03.2018.
 */
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public boolean register(UserView userView) {
        return false;
    }

    @Override
    public boolean activation(String code) {
        return false;
    }

    @Override
    public boolean login(UserView userView) {
        return false;
    }
}
