package practice.controller.userController.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import practice.dao.userDAO.UserDAO;
import practice.view.commonView.ResponseView;
import practice.view.officeView.OfficeView;
import practice.view.userView.UserView;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerImplIT {

    @Autowired
    private UserDAO userDAO;

    @LocalServerPort
    private int port = 8888;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRegister(){

        UserView userView = new UserView("Terrano17", "as34re", "Pasha");
        HttpEntity<UserView> entity = new HttpEntity<UserView>(userView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/register"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }

    @Test
    public void testActivation(){
        testRegister();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        String code = userDAO.getActivationCode("Terrano17");
        ResponseEntity<ResponseView> response = restTemplate.exchange(createURLWithPort("/api/activation?code=" + code),
                HttpMethod.GET, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }

    @Test
    public void testLogin(){
        testActivation();
        UserView userView = new UserView();
        userView.login = "Terrano17";
        userView.password = "as34re";
        HttpEntity<UserView> entity = new HttpEntity<UserView>(userView, headers);

        ResponseEntity<ResponseView> response = restTemplate.exchange(
                createURLWithPort("/api/login"),
                HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = response.getBody();
        Assert.assertEquals(true, view.result);
    }


    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }
}