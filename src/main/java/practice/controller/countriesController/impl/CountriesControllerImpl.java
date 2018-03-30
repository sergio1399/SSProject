package practice.controller.countriesController.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import practice.service.employeeService.impl.EmployeeServiceImpl;
import practice.utils.MyAppException;
import practice.view.commonView.ResponseView;
import practice.controller.countriesController.CountriesController;
import practice.service.countriesService.CountriesService;
import practice.view.countriesView.CountriesView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by sergi on 15.03.2018.
 */
@RestController
@RequestMapping(value = "api/countries", produces = APPLICATION_JSON_VALUE)
public class CountriesControllerImpl implements CountriesController {
    private final Logger log = LoggerFactory.getLogger(CountriesControllerImpl.class);

    private final CountriesService countriesService;

    @Autowired
    public CountriesControllerImpl(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @Override
    @RequestMapping(value = "", method = {GET})
    public ResponseView getCountries() {
        List<CountriesView> list = new ArrayList<>();
        try {
            list = countriesService.getCountries();
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            log.error(e.getMessage());
            return new ResponseView(message);
        }
        return new ResponseView(list);
    }
}
