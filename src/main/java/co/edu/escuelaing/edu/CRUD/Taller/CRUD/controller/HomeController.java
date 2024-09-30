package co.edu.escuelaing.edu.CRUD.Taller.CRUD.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/properties")
    public String listProperty(){
        return "properties";
    }
}
