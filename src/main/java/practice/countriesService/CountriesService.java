package practice.countriesService;

import practice.countriesView.CountriesView;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.List;

/**
 * Created by sergi on 15.03.2018.
 */
public interface CountriesService {

    List<CountriesView> getCountries();
}
