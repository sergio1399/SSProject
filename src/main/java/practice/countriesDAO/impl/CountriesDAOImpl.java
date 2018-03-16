package practice.countriesDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.countriesDAO.CountriesDAO;

import javax.persistence.EntityManager;

/**
 * Created by sergi on 15.03.2018.
 */
@Repository
public class CountriesDAOImpl implements CountriesDAO {
    private final EntityManager em;

    @Autowired
    public CountriesDAOImpl(EntityManager em) {
        this.em = em;
    }
}
