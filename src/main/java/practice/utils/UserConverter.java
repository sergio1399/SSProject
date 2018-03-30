package practice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practice.model.userModel.User;
import practice.view.userView.UserView;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by admin on 27.03.2018.
 */
public class UserConverter {
    public static User toModelReg(UserView userView) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = new User();
        user.setLogin(userView.login);
        user.setPassword(Crypto.generateHash(userView.password));
        user.setCode(Crypto.generateHash(Crypto.genRandonStr()));
        user.setActive(false);
        return user;
    }

}
