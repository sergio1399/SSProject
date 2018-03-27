package practice.controller.officeController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.utils.MyAppException;
import practice.view.commonView.ResponseView;
import practice.controller.officeController.OfficeController;
import practice.service.officeService.OfficeService;
import practice.view.officeView.OfficeInView;
import practice.view.officeView.OfficeView;

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
    public ResponseView getOffices(@RequestBody OfficeInView officeInView) {
        List<OfficeView> list = new ArrayList<>();
        try {
            list = officeService.getOffices(officeInView);
        }
        catch (MyAppException mae){
            String message = mae.getMessage();
            return new ResponseView(message);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            return new ResponseView(message);
        }
        return new ResponseView(list);
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView getOffice(@PathVariable("id") long id) {
        OfficeView officeView = new OfficeView();
        try {
            officeView = officeService.getOffice(id);
        }
        catch (MyAppException mae){
            String message = mae.getMessage();
            return new ResponseView(message);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            return new ResponseView(message);
        }
        return new ResponseView(officeView);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResponseView update(@RequestBody OfficeView officeView) {
        Boolean success = false;
        try {
            success = officeService.update(officeView);
        }
        catch (MyAppException mae){
            String message = mae.getMessage();
            return new ResponseView(message);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }

    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView save(@RequestBody OfficeView officeView) {
        Boolean success = false;
        try {
            success = officeService.save(officeView);
        }
        catch (MyAppException mae){
            String message = mae.getMessage();
            return new ResponseView(message);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }

    @Override
    @RequestMapping(value = "/delete/{id}", method = {POST})
    public ResponseView delete(@PathVariable("id") long id) {
        Boolean success = false;
        try {
            success = officeService.delete(id);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }
}
