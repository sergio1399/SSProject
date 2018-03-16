package practice.countriesController;

import org.springframework.web.bind.annotation.RequestBody;
import practice.commonView.ResponseView;
import practice.orgView.OrgInView;

/**
 * Created by sergi on 15.03.2018.
 */
public interface CountriesController {
    /**
     * Get all countries
     * @return JSON countries values
     */
    ResponseView getCountries();
}
