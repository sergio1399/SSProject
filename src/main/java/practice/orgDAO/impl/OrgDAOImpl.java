package practice.orgDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.officeModel.Office;
import practice.orgDAO.OrgDAO;
import practice.orgModel.Organization;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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


    @Override
    public List<Organization> getOrganizations(Organization fltOrg) {
        List<Organization> result = new ArrayList<>();
        try {
            CriteriaBuilder qb = em.getCriteriaBuilder();
            CriteriaQuery<Organization> cq = qb.createQuery(Organization.class);
            Root<Organization> orgRoot = cq.from(Organization.class);

            //Constructing list of parameters
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(
                    qb.like(orgRoot.<String>get("name"),"%" + fltOrg.getName() + "%"));
            //Adding predicates in case of parameter not being null
            if (fltOrg.getInn() != null) {
                predicates.add(
                        qb.equal(orgRoot.get("inn"), fltOrg.getInn()));
            }
            if (fltOrg.isActive() != null) {
                predicates.add(
                        qb.equal(orgRoot.get("isActive"), fltOrg.isActive()));
            }

            //query itself
            cq.select(orgRoot)
                    .where(predicates.toArray(new Predicate[]{}));
            //execute query and do something with result
            result = em.createQuery(cq).getResultList();
        }
        catch (Exception e)
        {

        }
        return result;
    }

    @Override
    public Organization getOrg(long id) {
        Organization org = em.find(Organization.class, id);
        if(org == null){
            //throw new
        }
        return org;
    }

    @Override
    public boolean update(Organization org) {
        try {
            Organization orgToUpdate = em.find(Organization.class, org.getId());
            orgToUpdate.setName(org.getName());
            orgToUpdate.setFullName(org.getFullName());
            orgToUpdate.setInn(org.getInn());
            orgToUpdate.setKpp(org.getKpp());
            orgToUpdate.setAddress(org.getAddress());
            orgToUpdate.setPhone(org.getPhone());
            orgToUpdate.setActive(org.isActive());
            em.merge(orgToUpdate);
        }
        catch (Exception e)
        {
            //throw new Exception();
        }
        return true;
    }

    @Override
    public boolean save(Organization org) {
        try {
            em.persist(org);
        }
        catch (Exception e)
        {
            //throw new Exception();
        }
        return true;

    }

    @Override
    public boolean delete(long id) {
        try {
            Organization org = em.find(Organization.class, id);
            em.remove(org);
        }
        catch (Exception e)
        {
            //throw new Exception();
        }
        return true;
    }
}
