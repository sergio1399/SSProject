package practice.officeDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.officeDAO.OfficeDAO;

import javax.persistence.EntityManager;

@Repository
public class OfficeDAOImpl implements OfficeDAO {
    private final EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager em) {
        this.em = em;
    }
}
