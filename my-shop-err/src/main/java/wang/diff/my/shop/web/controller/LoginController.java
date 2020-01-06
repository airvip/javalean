package wang.diff.my.shop.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wang.diff.my.shop.commons.constant.ConstantUtils;
import wang.diff.my.shop.entity.User;
import wang.diff.my.shop.service.UserService;

import javax.servlet.http.HttpServletRequest;

// all ok
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return  "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest) {
        User user = userService.login(email, password);
        if(null == user){
            return login();
        }else{
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            return "redirect:/main";
        }
    }

}
