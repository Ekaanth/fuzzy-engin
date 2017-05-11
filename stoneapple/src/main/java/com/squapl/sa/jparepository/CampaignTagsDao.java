package com.squapl.sa.jparepository;

import org.springframework.data.repository.CrudRepository;

import com.squapl.sa.domain.CampaignTags;


public interface CampaignTagsDao extends CrudRepository<CampaignTags, Long>{

	 Iterable<CampaignTags> findAll();
}
