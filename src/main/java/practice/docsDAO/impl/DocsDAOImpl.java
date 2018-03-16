package practice.docsDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.docsDAO.DocsDAO;

import javax.persistence.EntityManager;

/**
 * Created by sergi on 15.03.2018.
 */
@Repository
public class DocsDAOImpl implements DocsDAO {
    private final EntityManager em;

    @Autowired
    public DocsDAOImpl(EntityManager em) {
        this.em = em;
    }
}
