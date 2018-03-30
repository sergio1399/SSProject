package practice.dao.docsDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.dao.docsDAO.DocsDAO;
import practice.model.docsModel.Doc_types;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        /*TypedQuery<Doc_types> query = em.createQuery("SELECT dt FROM Doc_types dt", Doc_types.class);
        return query.getResultList();*/
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Doc_types> dtCriteria = cb.createQuery(Doc_types.class);
        Root<Doc_types> dtRoot = dtCriteria.from(Doc_types.class);
        dtCriteria.select(dtRoot);
        return em.createQuery(dtCriteria)
                .getResultList();

    }
}
