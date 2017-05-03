package com.squapl.sa.web.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;


@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

//	@RequestMapping("/")
//	public String welcome(Map<String, Object> model) {
//		model.put("message", this.message);
//		return "welcome";
//	}
//	
//	@RequestMapping("/addcategory")
//	public String addcategory(Map<String, Object> model) {
//	//	model.put("message", this.message);
//		return "addcategory";
//	}
	

//	@RequestMapping("/article")
//	public String articleForm( Model model) {
//		System.out.println("TESTe..");
//		model.addAttribute("article", new Article());
//		model.addAttribute("datetime", new Date());
//		model.addAttribute("username", "Squapl Admin");
//		model.addAttribute("mode","prod");
//		return "article";
//	}
//	
//	@RequestMapping(
//            value = "/article",
//            method = RequestMethod.POST)
//    public String articleSubmit(@ModelAttribute Article article) {
//		return "result";
//    }	    
	
	
}