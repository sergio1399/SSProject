package practice.controller.orgController.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.controller.orgController.OrgController;
import practice.service.employeeService.impl.EmployeeServiceImpl;
import practice.utils.MyAppException;
import practice.view.commonView.ResponseView;
import practice.service.orgService.OrgService;
import practice.view.orgView.OrgInView;
import practice.view.orgView.OrgView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "api/organization", produces = APPLICATION_JSON_VALUE)
public class OrgControllerImpl implements OrgController {
    private final Logger log = LoggerFactory.getLogger(OrgControllerImpl.class);

    private final OrgService orgService;

    @Autowired
    public OrgControllerImpl(OrgService orgService) {
        this.orgService = orgService;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public ResponseView getOrganizations(@RequestBody OrgInView orgInView) {
        List<OrgView> list = new ArrayList<>();
        try {
            list = orgService.getOrganizations(orgInView);
        }
        catch (MyAppException mae){
            String message = mae.getMessage();
            log.error(message);
            return new ResponseView(message);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            log.error(e.getMessage());
            return new ResponseView(message);
        }
        return new ResponseView(list);
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView getOrg(@PathVariable("id") long id) {
        OrgView orgView = new OrgView();
        try {
            orgView = orgService.getOrg(id);
        }
        catch (MyAppException mae){
            String message = mae.getMessage();
            log.error(message);
            return new ResponseView(message);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            log.error(e.getMessage());
            return new ResponseView(message);
        }
        return new ResponseView(orgView);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResponseView update(@RequestBody OrgView orgView) {
        Boolean success = false;
        try {
            success = orgService.update(orgView);
        }
        catch (MyAppException mae){
            String message = mae.getMessage();
            log.error(message);
            return new ResponseView(message);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            log.error(e.getMessage());
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView save(@RequestBody OrgView orgView) {
        Boolean success = false;
        try {
            success = orgService.save(orgView);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            log.error(e.getMessage());
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = {POST})
    public ResponseView delete(@PathVariable("id") int id) {
        Boolean success = false;
        try {
            success = orgService.delete(id);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            log.error(e.getMessage());
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }
}
