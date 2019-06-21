package com.usa.federal.gov.ssa.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyErrorController implements ErrorController  {
 
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
    	Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		String url = new String();
		Integer statusCode = Integer.valueOf(status.toString());

		if (statusCode == HttpStatus.NOT_FOUND.value())
			url = "error404";
		else
			url = "error";
		return url;
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
