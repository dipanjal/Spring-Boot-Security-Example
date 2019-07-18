package com.example.oauth.test.controller.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
//    @ResponseBody
    public String handleError(HttpServletRequest request, Model model) {
        String status = String.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        String errorMessage = String.valueOf(request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
//        int statusCode = status!=null?Integer.valueOf(status):500;
        errorMessage = errorMessage.isEmpty()?"Page Not Found":errorMessage;

        String displayMessage = "Error "+status+" : "+errorMessage;
//        model.addAttribute("code",statusCode);
        model.addAttribute("message",displayMessage);
        return "error/error_page_new";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
