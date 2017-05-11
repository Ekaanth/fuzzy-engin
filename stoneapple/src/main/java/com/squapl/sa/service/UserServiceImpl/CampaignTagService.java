package com.squapl.sa.service.UserServiceImpl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Campaign;
import com.squapl.sa.domain.CampaignTags;
import com.squapl.sa.jparepository.CampaignRep;
import com.squapl.sa.jparepository.CampaignTagsDao;

@Service
public class CampaignTagService {

	@Autowired
	CampaignTagsDao campaigntagsdao;

	public List<CampaignTags> findall() {
		// TODO Auto-generated method stub
		return (List<CampaignTags>) campaigntagsdao.findAll();
	}

	public List<CampaignTags> findCampaignTagList(Principal principal) {
		 List<CampaignTags> tagsList = (List<CampaignTags>) campaigntagsdao.findAll();
		return tagsList;
	}
	
	
}
