package practice.dao.countriesDAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import practice.dao.countriesDAO.CountriesDAO;
import practice.model.countriesModel.Country;
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
public class CountriesDAOImpl implements CountriesDAO {
    private final EntityManager em;

    @Autowired
    public CountriesDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Country> getCountries() {
        /*TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();*/
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Country> countryCriteria = cb.createQuery(Country.class);
        Root<Country> countryRoot = countryCriteria.from(Country.class);
        countryCriteria.select(countryRoot);
        return em.createQuery(countryCriteria)
                .getResultList();
    }
}
