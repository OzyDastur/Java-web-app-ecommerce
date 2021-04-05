package com.concordia.crud.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController  {



    @Override
    public String getErrorPath() {
        return null;
    }
    

    
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            
            //System.out.print(statusCode);
            if(statusCode == 400) {
                return "error-400";
            }
            else if(statusCode == 500) {
                return "error-500";
            }
        }
        return "error";
    }
    
    
    
}
