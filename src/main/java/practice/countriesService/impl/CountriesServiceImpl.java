package practice.countriesService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import practice.countriesDAO.CountriesDAO;
import practice.countriesModel.Country;
import practice.countriesService.CountriesService;
import practice.countriesView.CountriesView;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        Function<Country, CountriesView> mapCountry = c -> {
            CountriesView view = new CountriesView();
            view.name = c.getName();
            view.code = c.getCode();

            return view;
        };

        return countries.stream()
                .map(mapCountry)
                .collect(Collectors.toList());
    }
}
