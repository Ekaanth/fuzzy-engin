package com.squapl.sa.web.api;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.squapl.sa.domain.Appointment;
import com.squapl.sa.domain.Article;
import com.squapl.sa.service.ArticleService;

@Controller
@RequestMapping("/article")
public class Articlecontroller {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String createArticle(Model model) {
		return null;
       
	}
}