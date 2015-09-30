package org.langclub.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nikolay Antipov
 * @version $Id$
 *          $LastChangedDate$
 *          $Author$
 *          $Date$
 *          $Rev$
 *          $URL$
 */

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/app")
    public String mainApp() {
        return "app/index";
    }

//    @RequestMapping("/partials/{viewName}")
//    public String appPartials(@PathVariable("viewName") String viewName) {
//        return "app/partials/" + viewName;
//    }

}
