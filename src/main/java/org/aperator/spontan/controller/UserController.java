package org.aperator.spontan.controller;

import org.apache.commons.lang.StringUtils;
import org.aperator.spontan.controller.data.LoginRequestData;
import org.aperator.spontan.controller.data.UserError;
import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.PasswordManager;
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
 * User: cedster
 * Date: 24/11/13
 * Time: 15:25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordManager passwordManager;

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLoginPage() {
        return new ModelAndView("login", "loginUser", new LoginRequestData());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLogin(@ModelAttribute("loginUser") LoginRequestData loginUser, HttpSession session, HttpServletResponse response) {
        ModelAndView modelAndView;
        if (this.passwordManager.isValidPassword(loginUser.getUsername(), loginUser.getPassword())) {
            session.setAttribute("user", this.userManager.findByUsername(loginUser.getUsername()));
            modelAndView = new ModelAndView();
            modelAndView.setViewName("profile");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            modelAndView = new ModelAndView("login", "error", new UserError("Invalid username password combination"));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("newUser") RegisterUserRequestData registerData, HttpSession session, HttpServletResponse response) {
        String username = registerData.getUsername();
        if (this.userManager.findByUsername(username) != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return "register";
        }

        if(!isValidPassword(registerData.getPassword(), registerData.getPasswordConfirmation())) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "register";
        }

        User user = new User();
        user.setNickName(registerData.getNickname());
        Password password = new Password();
        password.setPasswordHash(registerData.getPassword());
        user.setPassword(password);
        user.setPhoneNumber(registerData.getPhonenumber());
        user.setUsername(registerData.getUsername());
        this.userManager.create(user);
        session.setAttribute("user", user);
        return "profile";
    }

    private boolean isValidPassword(String password, String passwordConfirmation) {
        return (StringUtils.isNotEmpty(password)
                && StringUtils.isNotEmpty(passwordConfirmation)
                && password.equals(passwordConfirmation));
    }
}
