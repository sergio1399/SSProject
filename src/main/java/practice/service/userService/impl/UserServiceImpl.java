package practice.service.userService.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.dao.userDAO.UserDAO;
import practice.model.userModel.User;
import practice.service.employeeService.impl.EmployeeServiceImpl;
import practice.service.userService.UserService;
import practice.utils.UserConverter;
import practice.view.userView.UserView;
import practice.utils.Crypto;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by sergi on 15.03.2018.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public boolean register(UserView userView) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        log.debug(userView.toString());
        User user = UserConverter.toModelReg(userView);
        return  userDAO.save(user);
    }

    @Override
    @Transactional
    public boolean activation(String code) {

        return userDAO.activation(code);
    }

    @Override
    public boolean login(UserView userView) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        log.debug(userView.toString());
        String login = userView.login;
        String password = Crypto.generateHash(userView.password);
        return userDAO.login(login, password);
    }
}
