package practice.controller.countriesController.impl;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import practice.Application;
import practice.view.commonView.ResponseView;
import practice.view.countriesView.CountriesView;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CountriesControllerImplIT {

    @LocalServerPort
    private int port = 8888;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testGetCountries() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<ResponseView> response = restTemplate.exchange(createURLWithPort("/api/countries"),
                HttpMethod.GET, entity, ResponseView.class);

        ResponseView view = response.getBody();
        List<CountriesView> list = (List<CountriesView>) view.data;
        Assert.assertEquals(5, list.size());
    }

    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

}