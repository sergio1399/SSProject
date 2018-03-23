package practice.countriesController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import practice.commonView.ResponseView;
import practice.countriesController.CountriesController;
import practice.countriesService.CountriesService;
import practice.countriesView.CountriesView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by sergi on 15.03.2018.
 */
@RestController
@RequestMapping(value = "api/countries", produces = APPLICATION_JSON_VALUE, method = {RequestMethod.GET})
public class CountriesControllerImpl implements CountriesController {
    private final CountriesService countriesService;

    @Autowired
    public CountriesControllerImpl(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @Override
    public ResponseView getCountries() {
        List<CountriesView> list = new ArrayList<>();
        try {
            list = countriesService.getCountries();
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(null, null, list);
    }
}
