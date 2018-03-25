package practice.dao.orgDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.dao.orgDAO.OrgDAO;
import practice.model.orgModel.Organization;
import practice.utils.ErrorCode;
import practice.utils.MyAppException;

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

        return result;
    }

    @Override
    public Organization getOrg(long id) throws MyAppException {
        Organization org = em.find(Organization.class, id);
        if(org == null){
            throw new MyAppException(String.format("Организация с id %d не найдена в базе", id), ErrorCode.WRONG_ID);
        }
        return org;
    }

    @Override
    public boolean update(Organization org) {
        Organization orgToUpdate = em.find(Organization.class, org.getId());
        orgToUpdate.setName(org.getName());
        orgToUpdate.setFullName(org.getFullName());
        orgToUpdate.setInn(org.getInn());
        orgToUpdate.setKpp(org.getKpp());
        orgToUpdate.setAddress(org.getAddress());
        orgToUpdate.setPhone(org.getPhone());
        orgToUpdate.setActive(org.isActive());
        em.merge(orgToUpdate);
        return true;
    }

    @Override
    public boolean save(Organization org) {
        em.persist(org);
        return true;
    }

    @Override
    public boolean delete(long id) {
        Organization org = em.find(Organization.class, id);
        em.remove(org);
        return true;
    }
}
