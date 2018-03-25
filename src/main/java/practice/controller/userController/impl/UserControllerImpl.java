package practice.controller.userController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practice.view.commonView.ResponseView;
import practice.controller.userController.UserController;
import practice.service.userService.UserService;
import practice.view.userView.UserView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by sergi on 15.03.2018.
 */
@RestController
@RequestMapping(value = "api", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @RequestMapping(value = "/register", method = {POST})
    public ResponseView register(@RequestBody UserView userView) {
        Boolean success = false;
        try {
            success = userService.register(userView);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }

    @Override
    @RequestMapping(value = "/activation", method = {GET})
    public ResponseView activation(@RequestParam(value="code", required=true) String code) {
        Boolean success = false;
        try {
            success = userService.activation(code);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }

    @Override
    @RequestMapping(value = "/login", method = {POST})
    public ResponseView login(@RequestBody UserView userView) {
        Boolean success = false;
        try {
            success = userService.login(userView);
        }
        catch (Exception e) {
            String message = "Внутренняя ошибка сервера";
            return new ResponseView(message);
        }
        return new ResponseView(success);
    }
}
