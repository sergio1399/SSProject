package orgController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import orgController.OrgController;
import practice.commonView.ResponseView;
import practice.orgService.OrgService;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

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


        return null;
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView getOrg(@PathVariable("id") int id) {

        return null;
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResponseView update(@RequestBody OrgView orgView) {


        return null;
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView save(@RequestBody OrgView orgView) {


        return null;
    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public ResponseView delete(@RequestParam(value="id", required=true) int id) {


        return null;
    }
}
