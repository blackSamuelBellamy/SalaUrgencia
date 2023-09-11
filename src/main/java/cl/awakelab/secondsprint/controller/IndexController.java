package cl.awakelab.secondsprint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String controladorInicio(){
        return "index";
    }
}
