package practice.officeController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.commonView.ResponseView;
import practice.officeController.OfficeController;
import practice.officeService.OfficeService;
import practice.officeView.OfficeView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public ResponseView getOffices(@RequestBody OfficeView officeView) {
        List<OfficeView> list = new ArrayList<>();
        try {
            list = officeService.getOffices(officeView);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(null, null, list);
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView getOffice(@PathVariable("id") int id) {
        OfficeView officeView = new OfficeView();
        try {
            officeView = officeService.getOffice(id);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(null, null, officeView);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResponseView update(@RequestBody OfficeView officeView) {
        Boolean success = false;
        try {
            success = officeService.update(officeView);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(success, null, null);
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView save(@RequestBody OfficeView officeView) {
        Boolean success = false;
        try {
            success = officeService.save(officeView);
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
            success = officeService.delete(id);
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(null, message , null);
        }
        return new ResponseView(success, null, null);
    }
}
