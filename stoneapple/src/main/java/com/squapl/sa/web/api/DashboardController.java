package com.squapl.sa.web.api;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.squapl.sa.domain.Article;
import com.squapl.sa.domain.Campaign;
import com.squapl.sa.domain.Category;
import com.squapl.sa.domain.Tags;
import com.squapl.sa.jparepository.TagsDao;
import com.squapl.sa.service.ArticleService;
import com.squapl.sa.service.UserServiceImpl.CategoryServiceImp;
import com.squapl.sa.service.UserServiceImpl.TagsServiceImp;
import com.squapl.sa.service.UserServiceImpl.TransactionServiceImp;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
   private TransactionServiceImp transactionServiceImp;
	
	@Autowired
	CategoryServiceImp categoryServiceImp;
	
	
	@Autowired
	TagsServiceImp tagsServiceImp;
	
	@RequestMapping(value="/articledetails",method = RequestMethod.GET)
	public String articledetails(Model model, Principal principal){
	
		List<Article> totalpending = articleService.findByStatus("Pending");
		model.addAttribute("totalPendingArticle", totalpending.size());
		
		List<Article> totalapproved = articleService.findByStatus("approved");
		model.addAttribute("totalApprovedArticle", totalapproved.size());
		
//		
//		List<Article> pendingTamil = articleService.findbystatuslanguage("Pending" , "Tamil");
//		List<Article> pendingEnglsih = articleService.findbystatuslanguage("Pending" , "Englsih");
//		List<Article> approvedEnglsih = articleService.findbystatuslanguage("approved" , "Englsih");
//		List<Article> approvedTamil = articleService.findbystatuslanguage("approved" , "Tamil");
//		model.addAttribute("pendingTamil",pendingTamil.size());
//		model.addAttribute("pendingEnglsih",pendingEnglsih.size());
//		model.addAttribute("approvedEnglsih",approvedEnglsih.size());
//		model.addAttribute("approvedTamil",approvedTamil.size());
//		
		return "articleDetails";
        
        
    }
	
	@RequestMapping(value="/campaign",method = RequestMethod.GET)
	public String campaigndetails(Model model, Principal principal){
		
		 List<Campaign> totalcampaign =  transactionServiceImp.findCampaignList(principal);
		 model.addAttribute("totalcampaign", totalcampaign.size());
		 
		 List<Campaign> activecampaign =  transactionServiceImp.findstatus("Active");
		 model.addAttribute("activecampaign", activecampaign.size());
		 
		 List<Campaign> pendingcampaign =  transactionServiceImp.findstatus("Pending");
		 model.addAttribute("pendingcampaign", pendingcampaign.size());
		 
		 List<Campaign> onholdcampaign =  transactionServiceImp.findstatus("Onhold");
		 model.addAttribute("onholdcampaign", onholdcampaign.size());
		 
		return "campaigndetails";
	
	}
	
	@RequestMapping(value="/misc",method = RequestMethod.GET)
	public String miscdetails(Model model, Principal principal){
		
		List<Category> totalcat =  categoryServiceImp.findAll();
		 model.addAttribute("totalcategory", totalcat.size());
		 
		 List<Tags> totaltags =  tagsServiceImp.findAll();
		 model.addAttribute("totaltags", totaltags.size());
		return "miscdetails";
		
	}
}

		
	