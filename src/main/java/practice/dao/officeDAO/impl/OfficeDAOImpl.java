package practice.dao.officeDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.dao.officeDAO.OfficeDAO;
import practice.model.officeModel.Office;
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

@Repository
public class OfficeDAOImpl implements OfficeDAO {
    private final EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Office> getOffices(long orgId, Office fltOffice) {

        List<Office> result = new ArrayList<>();

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Office> cq = qb.createQuery(Office.class);
        Root<Office> officeRoot = cq.from(Office.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(
                qb.equal(officeRoot.get("organization").get("id"), orgId));
        //Adding predicates in case of parameter not being null
        if (fltOffice.getName() != null) {
            predicates.add(
                    qb.equal(officeRoot.get("name"), fltOffice.getName()));
        }
        if (fltOffice.getPhone() != null) {
            predicates.add(
                    qb.equal(officeRoot.get("phone"), fltOffice.getPhone()));
        }
        if (fltOffice.isActive() != null) {
            predicates.add(
                    qb.equal(officeRoot.get("isActive"), fltOffice.isActive()));
        }
        //query itself
        cq.select(officeRoot)
                .where(predicates.toArray(new Predicate[]{}));
        //execute query and do something with result
        result = em.createQuery(cq).getResultList();

        return result;
    }

    @Override
    public Office getOffice(long id) throws MyAppException {

        Office office = em.find(Office.class, id);
        if(office == null){
            throw new MyAppException(String.format("Офис с id %d не найден в базе", id), ErrorCode.WRONG_ID);
        }
        return office;
    }

    @Override
    public boolean update(Office office) {
        Office officeToUpdate = em.find(Office.class, office.getId());
        officeToUpdate.setName(office.getName());
        officeToUpdate.setAddress(office.getAddress());
        officeToUpdate.setPhone(office.getPhone());
        officeToUpdate.setActive(office.isActive());
        em.merge(officeToUpdate);

        return true;
    }

    @Override
    public boolean save(Office office) {
        Organization org = em.find(Organization.class, office.getOrganization().getId());
        office.setOrganization(org);
        org.addOffice(office);
        em.persist(office);

        return true;
    }

    @Override
    public boolean delete(long id) {
        Office office = em.find(Office.class, id);
        office.setOrganization(null);
        em.remove(office);
        return true;
    }
}
