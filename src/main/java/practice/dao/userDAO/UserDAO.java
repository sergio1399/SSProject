package practice.dao.userDAO;

import practice.model.userModel.User;

/**
 * Created by sergi on 15.03.2018.
 */
public interface UserDAO {

    boolean save(User user);

    boolean activation(String code);

    boolean login(String login, String password);
}
