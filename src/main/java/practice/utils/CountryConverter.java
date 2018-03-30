package practice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practice.model.countriesModel.Country;
import practice.service.employeeService.impl.EmployeeServiceImpl;
import practice.view.countriesView.CountriesView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergi on 23.03.2018.
 */
public class CountryConverter {
    private static final Logger log = LoggerFactory.getLogger(CountryConverter.class);
    public static List<CountriesView> toViewList(List<Country> countries)
    {
        Function<Country, CountriesView> mapCountry = c -> {
            CountriesView view = new CountriesView();
            view.name = c.getName();
            view.code = c.getCode();
            log.debug(view.toString());
            return view;
        };

        return countries.stream()
                .map(mapCountry)
                .collect(Collectors.toList());
    }
}
