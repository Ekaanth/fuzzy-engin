package com.squapl.sa.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.squapl.sa.domain.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

//	@Autowired
//	CatagoryDao catagoryDao;
	
	 @RequestMapping(value = "/create",method = RequestMethod.GET)
	    public String createAppointment(Model model) {
	       
		 Category cat = new Category();
	        model.addAttribute("addcategory", cat);
	        
	        return "addcategory";
	    }
	
}
