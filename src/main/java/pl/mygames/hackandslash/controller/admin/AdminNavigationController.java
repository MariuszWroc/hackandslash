/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mygames.hackandslash.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mariusz
 */
@Controller
public class AdminNavigationController {
    private static final Logger logger = LoggerFactory.getLogger(AdminNavigationController.class);
    
    /* This method will list all existing tests.
     */
    @RequestMapping(value = {"/tests"}, method = RequestMethod.GET)
    public String getTests() {
        return "test/testlist";
    }
}
