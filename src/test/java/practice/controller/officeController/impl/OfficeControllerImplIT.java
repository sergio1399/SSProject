package practice.controller.officeController.impl;

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
import practice.view.commonView.ResponseView;
import practice.view.employeeView.EmployeeView;
import practice.view.officeView.OfficeInView;
import practice.view.officeView.OfficeView;
import practice.view.orgView.OrgInView;
import practice.view.orgView.OrgView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OfficeControllerImplIT {

    @LocalServerPort
    private int port = 8888;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testSave() {
        OfficeView officeView = new OfficeView(1L, "Florida branch", "1323 Sun blvd Miami FL",
                "(233)45-2354", true);
        HttpEntity<OfficeView> entity = new HttpEntity<OfficeView>(officeView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/office/save"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }

    @Test
    public void testGetOffice() throws JSONException {
        testSave();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<ResponseView> response = restTemplate.exchange(createURLWithPort("/api/office/3"),
                HttpMethod.GET, entity, ResponseView.class);

        ResponseView view = response.getBody();
        HashMap<String, String> map = (HashMap<String, String>) view.data;
        JSONObject json = new JSONObject(map);
        Assert.assertEquals("Florida branch", json.get("name"));
        Assert.assertEquals("(233)45-2354", json.get("phone"));
        Assert.assertEquals("1323 Sun blvd Miami FL", json.get("address"));

    }

    @Test
    public void testUpdate(){
        testSave();
        OfficeView officeView = new OfficeView();
        officeView.id = 3L;
        officeView.address = "1323 Sun blvd Orlando FL";
        officeView.name = "Florida branch";
        officeView.phone = "(233)45-2354";
        officeView.isActive = false;
        HttpEntity<OfficeView> entity = new HttpEntity<OfficeView>(officeView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/office/update"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }

    @Test
    public void testList(){
        testSave();
        OfficeInView officeInView = new OfficeInView();
        officeInView.orgId = 1L;
        HttpEntity<OfficeInView> entity = new HttpEntity<OfficeInView>(officeInView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/office/list"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        List<OfficeView> list = (List<OfficeView>) view.data;
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testDelete(){
        testSave();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/office/delete/3"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }




    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }


}