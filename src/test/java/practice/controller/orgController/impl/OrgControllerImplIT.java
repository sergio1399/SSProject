package practice.controller.orgController.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import practice.Application;
import practice.dao.orgDAO.OrgDAO;
import practice.model.orgModel.Organization;
import practice.view.commonView.ResponseView;
import practice.view.orgView.OrgInView;
import practice.view.orgView.OrgView;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrgControllerImplIT {

    @LocalServerPort
    private int port = 8888;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();


    @Test
    public void testSave() {
        OrgView orgView = new OrgView("Gillette", "Gillette and brothers Co.", "2343323", "23332",
                              "1313 Peteboro ave Williamsburg VA", "(123)43-234-21", true);
        HttpEntity<OrgView> entity = new HttpEntity<OrgView>(orgView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/organization/save"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }

    @Test
    public void testGetOrg() throws JSONException {
        testSave();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<ResponseView> response = restTemplate.exchange(createURLWithPort("/api/organization/2"),
                HttpMethod.GET, entity, ResponseView.class);

        ResponseView view = response.getBody();
        HashMap<String, String> map = (HashMap<String, String>) view.data;
        JSONObject json = new JSONObject(map);
        Assert.assertEquals("Gillette", json.get("name"));
        Assert.assertEquals("2343323", json.get("inn"));
        Assert.assertEquals("1313 Peteboro ave Williamsburg VA", json.get("address"));

    }

    @Test
    public void testUpdate(){
        testSave();
        OrgView orgView = new OrgView(2L,"Gillette", "Gillette and brothers Co.", "2343323", "111111",
                "1313 Peteboro ave Williamsburg VA", "(123)43-234-21", true);
        HttpEntity<OrgView> entity = new HttpEntity<OrgView>(orgView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/organization/update"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }

    @Test
    public void testList(){
        testSave();
        OrgInView orgInView = new OrgInView();
        orgInView.name = "%";
        HttpEntity<OrgInView> entity = new HttpEntity<OrgInView>(orgInView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/organization/list"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        List<OrgInView> list = (List<OrgInView>) view.data;
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testDelete(){
        testSave();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/organization/delete/2"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }




    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

}