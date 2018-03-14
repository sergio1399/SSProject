package practice.orgDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.orgDAO.OrgDAO;

import javax.persistence.EntityManager;

/**
 * Created by sergi on 13.03.2018.
 */
@Repository
public class OrgDAOImpl implements OrgDAO {
    private final EntityManager em;

    @Autowired
    public OrgDAOImpl(EntityManager em) {
        this.em = em;
    }
}
