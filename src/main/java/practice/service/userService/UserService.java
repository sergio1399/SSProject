package practice.service.userService;

import practice.view.userView.UserView;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by sergi on 15.03.2018.
 */
public interface UserService {

    boolean register(UserView userView) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    boolean activation(String code);

    boolean login(UserView userView) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
