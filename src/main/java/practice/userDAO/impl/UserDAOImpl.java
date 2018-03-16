package practice.userDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import practice.userDAO.UserDAO;

import javax.persistence.EntityManager;

/**
 * Created by sergi on 15.03.2018.
 */
public class UserDAOImpl implements UserDAO {
    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }
}
