package practice.controller.docsController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import practice.view.commonView.ResponseView;
import practice.controller.docsController.DocsController;
import practice.service.docsService.DocsService;
import practice.view.docsView.DocsView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by sergi on 15.03.2018.
 */
@RestController
@RequestMapping(value = "api/docs", produces = APPLICATION_JSON_VALUE, method = {RequestMethod.GET})
public class DocsControllerImpl implements DocsController {
    private final DocsService docsService;

    @Autowired
    public DocsControllerImpl(DocsService docsService) {
        this.docsService = docsService;
    }
    @Override
    public ResponseView getDocs() {
        List<DocsView> list = new ArrayList<>();
        try {
            list = docsService.getDocs();
        }
        catch (Exception e) {
            String message = "";
            return new ResponseView(message);
        }
        return new ResponseView(list);
    }
}