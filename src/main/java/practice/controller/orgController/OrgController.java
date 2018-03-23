package practice.controller.orgController;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import practice.view.commonView.ResponseView;
import practice.view.orgView.OrgInView;
import practice.view.orgView.OrgView;

public interface OrgController {

    /**
     * Get organizations by params
     *  @param orgInView
     * @return JSON organizations value
     */
    ResponseView getOrganizations(@RequestBody OrgInView orgInView);

    /**
     * Get organization by ID
     * @param id
     * @return JSON organization value
     */
    ResponseView getOrg(@PathVariable("id") long id);

    /**
     * Update organization
     * @param orgView
     * @return JSON success check
     */
    ResponseView update(@RequestBody OrgView orgView);

    /**
     * Save organization
     * @param orgView
     * @return JSON success check
     */
    ResponseView save(@RequestBody OrgView orgView);

    /**
     * Delete organization
     * @param id
     * @return JSON success check
     */
    ResponseView delete(@PathVariable("id") int id);

}
