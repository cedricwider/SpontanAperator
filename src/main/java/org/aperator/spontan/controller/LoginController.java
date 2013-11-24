package org.aperator.spontan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.GET)
    public String displayLoginPage() {
        return "login";
    }

}
