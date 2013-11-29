package org.aperator.spontan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: ced
 * Date: 11/24/13
 * Time: 12:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class ConfigurationConfirmationController {

    @RequestMapping(method = RequestMethod.GET)
    public String confirmCorrectConfiguration() {
        return "spontan";
    }
}
