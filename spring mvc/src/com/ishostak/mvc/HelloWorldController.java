package com.ishostak.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() { return "hello-form"; }

    @RequestMapping("/processForm")
    public String processForm() {
        return "processForm";
    }

    @RequestMapping("processFormTwo")
    public String letsShout(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "YO! " + theName;

        model.addAttribute("message", result);

        return "processForm";
    }

    @RequestMapping("processFormThree")
    public String three(@RequestParam("studentName") String theName,
                        Model model) {

        theName = theName.toUpperCase();

        String result = "Hey, my friend! " + theName;

        model.addAttribute("message", result);

        return "processForm";
    }
}
