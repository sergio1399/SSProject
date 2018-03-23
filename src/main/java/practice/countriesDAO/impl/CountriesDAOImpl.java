package practice.countriesDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.countriesDAO.CountriesDAO;
import practice.countriesModel.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Country> getCountries() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();
    }
}
