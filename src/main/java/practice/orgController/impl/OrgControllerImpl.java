package practice.orgController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.orgController.OrgController;
import practice.commonView.ResponseView;
import practice.orgService.OrgService;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "api/organization", produces = APPLICATION_JSON_VALUE)
public class OrgControllerImpl implements OrgController {

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
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(null, null, list);
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView getOrg(@PathVariable("id") int id) {
        OrgView orgView = new OrgView();
        try {
            orgView = orgService.getOrg(id);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(null, null, orgView);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResponseView update(@RequestBody OrgView orgView) {
        Boolean success = false;
        try {
            success = orgService.update(orgView);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(success, null, null);
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView save(@RequestBody OrgView orgView) {
        Boolean success = false;
        try {
            success = orgService.save(orgView);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(success, null, null);
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = {POST})
    public ResponseView delete(@PathVariable("id") int id) {
        Boolean success = false;
        try {
            success = orgService.delete(id);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(orgService.delete(id), null, null);
    }
}
