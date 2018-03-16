package practice.employeeDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by sergi on 14.03.2018.
 */
public class EmployeeDAOImpl {
    private final EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager em) {
        this.em = em;
    }
}
