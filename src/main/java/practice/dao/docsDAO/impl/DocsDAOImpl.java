package practice.dao.docsDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.dao.docsDAO.DocsDAO;
import practice.model.docsModel.Doc_types;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Doc_types> getDocs() {
        TypedQuery<Doc_types> query = em.createQuery("SELECT dt FROM Doc_types dt", Doc_types.class);
        return query.getResultList();
    }
}
