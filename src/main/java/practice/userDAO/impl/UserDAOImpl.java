package practice.userDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import practice.userDAO.UserDAO;
import practice.userModel.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by sergi on 15.03.2018.
 */
public class UserDAOImpl implements UserDAO {
    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean save(User user) {
        try {
            em.persist(user);
        }
        catch (Exception e)
        {
            //throw new Exception();
        }
        return true;
    }

    @Override
    public boolean activation(String code) {

        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);

            Root<User> userRoot = criteria.from(User.class);
            criteria.select(userRoot).where(builder.equal(userRoot.get("code"), code));
            TypedQuery<User> query = em.createQuery(criteria);
            User user = query.getSingleResult();
            if(user != null && !user.getActive())
            {
                user.setActive(true);
                em.merge(user);
                return true;
            }
        }
        catch (Exception e)
        {

        }

        return false;
    }

    @Override
    public boolean login(String login, String password) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);

            Root<User> userRoot = criteria.from(User.class);
            criteria.select(userRoot).where(builder.and(builder.equal(userRoot.get("login"), login),
                           builder.equal(userRoot.get("password"), password)));
            TypedQuery<User> query = em.createQuery(criteria);
            User user = query.getSingleResult();
            if (user != null)
                return true;
        }
        catch (Exception e)
        {

        }
        return false;
    }
}
