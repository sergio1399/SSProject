package practice.controller.employeeController.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import practice.Application;
import practice.model.employeeModel.Employee;
import practice.view.commonView.ResponseView;
import practice.view.employeeView.EmployeeInView;
import practice.view.employeeView.EmployeeView;
import practice.view.officeView.OfficeInView;
import practice.view.officeView.OfficeView;
import practice.view.orgView.OrgInView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeControllerImplIT {
    @LocalServerPort
    private int port = 8888;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testSave() {
        EmployeeView employeeView = new EmployeeView("Tom", null, "Hanks", "technical supporter", "234-1122",
                "10", "Паспорт иностранного гражданина", "2343 465764", new GregorianCalendar(2003,
                Calendar.JULY, 31).getTime(), "Австралия", "020", false );
        employeeView.officeId = 1L;
        HttpEntity<EmployeeView> entity = new HttpEntity<EmployeeView>(employeeView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/user/save"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }

    @Test
    public void testGetEmployee() throws JSONException {
        testSave();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<ResponseView> response = restTemplate.exchange(createURLWithPort("/api/user/2"),
                HttpMethod.GET, entity, ResponseView.class);

        ResponseView view = response.getBody();
        HashMap<String, String> map = (HashMap<String, String>) view.data;
        JSONObject json = new JSONObject(map);
        Assert.assertEquals("Tom", json.get("firstName"));
        Assert.assertEquals("Hanks", json.get("lastName"));
        Assert.assertEquals("technical supporter", json.get("position"));

    }

    @Test
    public void testUpdate(){
        testSave();
        EmployeeView employeeView = new EmployeeView("Tom", "Ivanovich", "Hanks", "financial director", "234-1122",
                "Паспорт иностранного гражданина", "2343 465764", new GregorianCalendar(2003,
                Calendar.JULY, 31).getTime(), "Австралия", "020", false );
        employeeView.id = 2L;
        HttpEntity<EmployeeView> entity = new HttpEntity<EmployeeView>(employeeView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/user/update"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }

    @Test
    public void testList(){
        testSave();
        EmployeeInView employeeInView = new EmployeeInView();
        employeeInView.officeId = 1L;
        HttpEntity<EmployeeInView> entity = new HttpEntity<EmployeeInView>(employeeInView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/user/list"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        List<EmployeeView> list = (List< EmployeeView>) view.data;
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testDelete(){
        testSave();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/user/delete/2"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }




    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

}