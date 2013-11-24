package org.aperator.spontan.controller;

import org.aperator.spontan.controller.data.LoginRequestData;
import org.aperator.spontan.controller.data.UserError;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 24/11/13
 * Time: 15:25
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/spontan/login")
public class LoginController {

    @Autowired
    private UserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayLoginPage() {
        return new ModelAndView("login", "loginUser", new LoginRequestData());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView doLogin(@ModelAttribute("loginUser") LoginRequestData loginUser, HttpSession session, HttpServletResponse response) {
        ModelAndView modelAndView;
        User realUser = this.userManager.getUserByUsername(loginUser.getUsername());
        if (realUser != null) {
            session.setAttribute("user", realUser);
            modelAndView = new ModelAndView();
            modelAndView.setViewName("profile");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            modelAndView = new ModelAndView("login", "error", new UserError("Invalid username password combination"));
        }
        return modelAndView;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

}
