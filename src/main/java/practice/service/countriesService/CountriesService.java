package practice.service.countriesService;

import practice.view.countriesView.CountriesView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface CountriesService {

    List<CountriesView> getCountries();
}
