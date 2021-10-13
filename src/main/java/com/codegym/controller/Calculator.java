package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {
    @GetMapping("/cal")
    public ModelAndView modelAndView(@RequestParam("first") String first,
                                     @RequestParam("second") String second,
                                     @RequestParam("operator") char operator) {
        ModelAndView modelAndView = new ModelAndView("/index");
        double firstNumber = Double.parseDouble(first);
        double secondNumber = Double.parseDouble(second);
        double result = 0;
        switch (operator){
            case '+':{
                result = firstNumber + secondNumber;
                break;
            }
            case '-':{
                result = firstNumber - secondNumber;
                break;
            }
            case '*':{
                result = firstNumber * secondNumber;
                break;
            }
            case '/':{
                result = firstNumber / secondNumber;
                break;
            }
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }
    @GetMapping
    public String show(){
        return "index";
    }
}
