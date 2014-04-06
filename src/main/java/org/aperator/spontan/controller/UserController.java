package org.aperator.spontan.controller;

import org.apache.commons.lang.StringUtils;
import org.aperator.spontan.controller.data.LoginRequestData;
import org.aperator.spontan.controller.data.UserError;
import org.aperator.spontan.controller.util.UserDataConverter;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.aperator.spontan.model.data.manager.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

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
    UserDataConverter userDataConverter;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if ( user == null ) {
            return displayLoginPage();
        }
        return new ModelAndView("profile", "userData", userDataConverter.toUserData(user));
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLoginPage() {
        return new ModelAndView("login", "loginUser", new LoginRequestData());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLogin(@ModelAttribute("loginUser") LoginRequestData loginUser, HttpSession session, HttpServletResponse response) throws NoSuchAlgorithmException {
        ModelAndView modelAndView;
        if (this.passwordManager.isValidPassword(loginUser.getUsername(), loginUser.getPassword())) {
            User user = this.userDao.findByUsername(loginUser.getUsername());
            session.setAttribute("user", user);
            modelAndView = new ModelAndView("profile", "userData", userDataConverter.toUserData(user));
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            modelAndView = new ModelAndView("login", "error", new UserError("Invalid username password combination"));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView registerUser() {
        return new ModelAndView("register", "newUser", new RegisterUserRequestData());
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView doRegisterUser(@ModelAttribute("newUser") RegisterUserRequestData registerData, HttpSession session, HttpServletResponse response) throws NoSuchAlgorithmException {
        ModelAndView modelAndView = new ModelAndView();
        String username = registerData.getUsername();
        if (this.userDao.findByUsername(username) != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            modelAndView.setViewName("register");
            return modelAndView;
        }

        if(!isValidPasswordRequest(registerData.getPassword(), registerData.getPasswordConfirmation())) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            modelAndView.setViewName("register");
            return modelAndView;
        }

        User user = userDataConverter.fromRegisterUserRequestData(registerData);
        this.userDao.save(user);
        session.setAttribute("user", user);

        modelAndView.setViewName("profile");
        modelAndView.addObject("userData", userDataConverter.toUserData(user));
        return modelAndView;
    }

    private boolean isValidPasswordRequest(String password, String passwordConfirmation) {
        return (StringUtils.isNotEmpty(password)
                && StringUtils.isNotEmpty(passwordConfirmation)
                && password.equals(passwordConfirmation));
    }
}
