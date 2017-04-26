package com.squapl.sa.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CategoryController {

	
	@RequestMapping("/addcategory")
    public String addCategory() {
        return "addcategory";
    }	
	
}
