package practice.controller.countriesController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import practice.view.commonView.ResponseView;
import practice.controller.countriesController.CountriesController;
import practice.service.countriesService.CountriesService;
import practice.view.countriesView.CountriesView;

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
            return new ResponseView(message);
        }
        return new ResponseView(list);
    }
}
