package practice.service.countriesService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import practice.dao.countriesDAO.CountriesDAO;
import practice.model.countriesModel.Country;
import practice.service.countriesService.CountriesService;
import practice.utils.CountryConverter;
import practice.view.countriesView.CountriesView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class CountriesServiceImpl implements CountriesService {
    private final CountriesDAO countriesDAO;

    @Autowired
    public CountriesServiceImpl(CountriesDAO countriesDAO) {
        this.countriesDAO = countriesDAO;
    }

    @Override
    public List<CountriesView> getCountries() {
        List<Country> countries = countriesDAO.getCountries();

        return CountryConverter.toViewList(countries);
    }
}
