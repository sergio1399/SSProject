package practice.employeeController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.commonView.ResponseView;
import practice.employeeController.EmployeeController;
import practice.employeeModel.Employee;
import practice.employeeService.EmployeeService;
import practice.employeeView.EmployeeInView;
import practice.employeeView.EmployeeView;
import practice.orgService.OrgService;
import practice.orgView.OrgView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by sergi on 14.03.2018.
 */
@RestController
@RequestMapping(value = "api/user", produces = APPLICATION_JSON_VALUE)
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeControllerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public ResponseView getEmployees(@RequestBody EmployeeInView employeeInView) {
        List<EmployeeView> list = new ArrayList<>();
        try {
            list = employeeService.getEmployees(employeeInView);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(null, null, list);
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView getEmp(@PathVariable("id") int id) {
        EmployeeView employeeView = new EmployeeView();
        try {
            employeeView = employeeService.getEmp(id);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(null, null, employeeView);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResponseView update(@RequestBody EmployeeView employeeView) {
        Boolean success = false;
        try {
            success = employeeService.update(employeeView);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(success, null, null);
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView save(EmployeeView employeeView) {
        Boolean success = false;
        try {
            success = employeeService.save(employeeView);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(success, null, null);
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = {POST})
    public ResponseView delete(int id) {
        Boolean success = false;
        try {
            success = employeeService.delete(id);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(success, null, null);
    }
}
