package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class MyController {

    @RequestMapping("/")
    public String showFirstView()
    {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmpDetailsView(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }


    @RequestMapping("showDetails")
    public String showEmpDetailsView(@ModelAttribute("employee") Employee emp ) {
        // мы говорим что вью за который отв метод шоу может использовать аттрибут модели имплоии
        return "show-emp-details-view";
    }
}
