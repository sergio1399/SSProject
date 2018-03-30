package practice.dao.userDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.dao.userDAO.UserDAO;
import practice.model.userModel.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean save(User user) {
        em.persist(user);
        return true;
    }

    @Override
    public boolean activation(String code) {
        List<User> result = new ArrayList<>();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot).where(builder.equal(userRoot.get("code"), code));
        TypedQuery<User> query = em.createQuery(criteria);
        result = query.getResultList();
        if(!result.isEmpty() && !result.get(0).getActive())
        {
            result.get(0).setActive(true);
            em.merge(result.get(0));
            return true;
        }

        return false;
    }

    @Override
    public boolean login(String login, String password) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot).where(builder.and(builder.equal(userRoot.get("login"), login),
                       builder.equal(userRoot.get("password"), password), builder.equal(userRoot.get("isActive"), true)) );
        TypedQuery<User> query = em.createQuery(criteria);
        List<User> result = query.getResultList();
        if (!result.isEmpty())
            return true;

        return false;
    }

    @Override
    public String getActivationCode(String login) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);

        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot.get("code")).where(builder.equal(userRoot.get("login"), login));
        TypedQuery<String> query = em.createQuery(criteria);
        List<String> result = query.getResultList();
        if (!result.isEmpty())
            return result.get(0);
        return "";
    }


}
