package com.truefmartin.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/query")
    public String query() {
        return "query.html";
    }

}