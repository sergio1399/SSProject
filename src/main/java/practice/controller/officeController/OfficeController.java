package practice.controller.officeController;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import practice.view.commonView.ResponseView;
import practice.view.officeView.OfficeInView;
import practice.view.officeView.OfficeView;

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
