package practice.view.countriesView;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Countries data view
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountriesView {

    public String code;

    public String name;

    //для jackson
    public CountriesView() {

    }
}
