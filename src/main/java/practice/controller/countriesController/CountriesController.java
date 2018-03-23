package practice.controller.countriesController;

import practice.view.commonView.ResponseView;

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
