package practice.officeController;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import practice.commonView.ResponseView;
import practice.officeView.OfficeInView;
import practice.officeView.OfficeView;
import practice.orgView.OrgInView;
import practice.orgView.OrgView;

public interface OfficeController {
    /**
     * Get offices by params
     *  @param officeInView
     * @return JSON offices value
     */
    ResponseView getOffices(@RequestBody OfficeInView officeInView);

    /**
     * Get office by ID
     * @param orgId
     * @return JSON offices value
     */
    ResponseView getOffice(@PathVariable("orgId") long orgId);

    /**
     * Update office
     * @param officeView
     * @return JSON success check
     */
    ResponseView update(@RequestBody OfficeView officeView);

    /**
     * Save office
     * @param officeView
     * @return JSON success check
     */
    ResponseView save(@RequestBody OfficeView officeView);

    /**
     * Delete office
     * @param id
     * @return JSON success check
     */
    ResponseView delete(@PathVariable("id") long id);
}
