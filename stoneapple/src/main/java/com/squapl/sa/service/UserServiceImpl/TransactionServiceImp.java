package com.squapl.sa.service.UserServiceImpl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Campaign;
import com.squapl.sa.jparepository.CampaignRep;
import com.squapl.sa.service.TransactionService;


@Service
public  class TransactionServiceImp implements TransactionService {
	

	@Autowired
    CampaignRep campaignRep;
	
	
	
	
    public List<Campaign> findCampaignList(Principal principal) {
        List<Campaign> campaignList = campaignRep.findAll();
        
        return campaignList;
    }

    
    public Campaign saveCampaign(Campaign campaign) {
    	
        return campaignRep.save(campaign);
    }

    
    public Campaign findCampaignByName(String campaignName) {
        return campaignRep.findByName(campaignName);
    }

    
    public void deleteCampaignByName(String campaignName) {
    	campaignRep.deleteByName(campaignName);
    }

	

}

