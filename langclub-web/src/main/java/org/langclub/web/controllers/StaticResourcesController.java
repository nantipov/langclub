package org.langclub.web.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    @ResponseBody
    public String process(HttpServletRequest httpServletRequest) throws IOException {
        String contextPath = httpServletRequest.getContextPath();
        String uriPath = httpServletRequest.getRequestURI();
        int contextStartedPos = uriPath.indexOf(contextPath);
        if (contextStartedPos != -1) {
        	
        	StringBuilder sb = new StringBuilder();
			String resoursePath = httpServletRequest.getServletContext().getRealPath(uriPath.substring(contextStartedPos + contextPath.length()));
        	
        	try (
        			BufferedReader reader = Files.newBufferedReader(Paths.get(resoursePath));
        			)
        	{
        		int t;
        		char[] buf = new char[1024];
        		while ((t = reader.read(buf, 0, buf.length)) > -1) {
        			sb.append(buf, 0, t);
        		}
        	}

        	return sb.toString();
        } else {
        	notFound();
        	return null;
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void notFound() {
    	
    }

}
