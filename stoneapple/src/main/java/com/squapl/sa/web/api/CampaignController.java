package com.squapl.sa.web.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.squapl.sa.domain.Appointment;
import com.squapl.sa.domain.Campaign;
import com.squapl.sa.domain.Category;
import com.squapl.sa.jparepository.CampaignRep;
import com.squapl.sa.service.Categoryservice;
import com.squapl.sa.service.TransactionService;

@Controller
@RequestMapping("/api")
public class CampaignController {

	
	@Autowired
	CampaignRep campaignRep;
	
	
	
	@Autowired
	Categoryservice categoryservice;
	
	@Autowired
    private TransactionService transactionService;	

	// private static String UPLOADED_FOLDER = "E://temp//";
	 //private static String UPLOADED_FOLDER = "C://Users//abhishek//Documents//GitHub//stoneapple//src//main//resources//static//images//";
	 // C:\Users\abhishek\Documents\GitHub\stoneapple\src\main\resources\static\images\
	private static String UPLOADED_FOLDER ="C://Apache24//htdocs//img";
	
	@RequestMapping(value = "/campaign", method = RequestMethod.GET)
    public String recipient(Model model, Principal principal) {
        List<Campaign> campaignList = transactionService.findCampaignList(principal);
        model.addAttribute("startDate", "");
        model.addAttribute("endDate", "");
      
        List<Category> categoryList = categoryservice.findCategoryList(principal);
        Campaign campaign = new Campaign();

//        CampaignTags tags = new CampaignTags();
//        List<CampaignTags> tagsList = campaignTagService.findCampaignTagList(principal);
        model.addAttribute("campaignList", campaignList);
        model.addAttribute("campaign", campaign);
        model.addAttribute("image", "");
//        model.addAttribute("tags", tags);
//        model.addAttribute("$tagsList", tagsList);
        
        model.addAttribute("category", categoryList);

        return "campaign";
    }

    @RequestMapping(value = "/campaign/save", method = RequestMethod.POST)
    public String campaignPost(@ModelAttribute("campaign") Campaign campaign, @ModelAttribute("startDate") String startdate, 
    		@ModelAttribute("endDate") String enddate,@RequestParam("tags") String tags,@RequestParam("file") MultipartFile image,Principal principal) throws ParseException {
    	
    File file = new File(UPLOADED_FOLDER+"//"+campaign.getName());
    String UPLOAD = file.toString();
    	Path imagePath = null;
    	Path videoPath = null;
          try {

              // Get the file and save it somewhere
              byte[] imagebytes = image.getBytes();
//               path = Paths.get(UPLOADED_FOLDER +"//"+campaign.getName()+"//"+ file.getOriginalFilename());
               imagePath = Paths.get(UPLOAD +"//"+ image.getOriginalFilename());
               file.mkdir();
               System.out.println(imagePath.toString());
              Files.write(imagePath, imagebytes);
              
//              byte[] videobytes = video.getBytes();
////               path = Paths.get(UPLOADED_FOLDER +"//"+campaign.getName()+"//"+ file.getOriginalFilename());
//              videoPath = Paths.get(UPLOADED_FOLDER + video.getOriginalFilename());
//              Files.write(videoPath, videobytes);

          } catch (IOException e) {
              e.printStackTrace();
          }

          String finalImagePath = imagePath.toString();
         // String finalvideoPath = videoPath.toString();
          
          String uploadImagePath = finalImagePath.replace('\\', '/').substring(18,finalImagePath.length());
    	campaign.setImage(uploadImagePath);
System.out.println(">>>>>>>>>>>");
   	System.out.println(tags);
    	//campaign.setVideo(finalvideoPath);
//    	campaign.setTags(tags.toString());
    	 SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
         Date d1 = format1.parse( startdate );
         campaign.setStartdate(d1);
         
         SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
         Date d2 = format2.parse( enddate );
         campaign.setEnddate(d2);
         
         int i = d1.compareTo(d2);
        
         if(i<0){
        transactionService.saveCampaign(campaign);

        return "redirect:/api/campaign";
         }
         else
         {
        	 return "redirect:/api/campaign?error"; 
         }
    }

    @RequestMapping(value = "/campaign/edit", method = RequestMethod.GET)
    public String recipientEdit(@RequestParam(value = "campaignName") String campaignName, Model model, Principal principal){

        Campaign campaign = transactionService.findCampaignByName(campaignName);
        List<Campaign> campaignList = transactionService.findCampaignList(principal);

        model.addAttribute("campaignList", campaignList);
        model.addAttribute("campaign", campaign);
        model.addAttribute("startDate", campaign.getStartdate());
        model.addAttribute("endDate", campaign.getEnddate());
        model.addAttribute("image", campaign.getImage());
        model.addAttribute("video", campaign.getVideo());

        return "campaign";
    }

    @RequestMapping(value = "/campaign/delete", method = RequestMethod.GET)
    @Transactional
    public String campaignDelete(@RequestParam(value = "campaignName") String campaignName, Model model, Principal principal){

        transactionService.deleteCampaignByName(campaignName);

        List<Campaign> campaignList = transactionService.findCampaignList(principal);

        Campaign campaign = new Campaign();
        model.addAttribute("campaignList", campaignList);
        model.addAttribute("campaign", campaign);



        return "campaign";
    }
	
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String showAppointment(Model model, Principal principal) {
    	
    	List<Campaign> campaignList = transactionService.findCampaignList(principal);
    	
    	model.addAttribute("campaignList", campaignList);


        return "showcampaign";
    }
	
	
}
