package com.squapl.sa.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.squapl.sa.domain.Campaign;


public interface CampaignRep extends CrudRepository<Campaign, Long>{

	  List<Campaign> findAll();

	void deleteByName(String campaignName);
	
	Campaign findByName(String campaignName);
	
	
}
