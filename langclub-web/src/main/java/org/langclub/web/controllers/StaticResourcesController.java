package org.langclub.web.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
public class StaticResourcesController {

    @RequestMapping(value = {"/css/*.css", "/js/*.js"})
    public String process(HttpServletRequest httpServletRequest) {
        String contextPath = httpServletRequest.getContextPath();
        String uriPath = httpServletRequest.getRequestURI();
        int contextStartedPos = uriPath.indexOf(contextPath);
        if (contextStartedPos != -1) {
            return uriPath.substring(contextStartedPos + contextPath.length());
        } else {
            return uriPath;
        }
    }

}
