package com.mortymaroon.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalcController {

    @GetMapping("/calc_form")
    public String showForm(){
        return "calc_form";
    }

    @GetMapping("calc_result")
    @ResponseBody
    public Integer sum(@RequestParam(name = "varA") Integer a,
            @RequestParam(name = "varB") Integer b
    ) {
        return a + b;
    }
}
