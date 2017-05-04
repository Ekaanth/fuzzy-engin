package com.squapl.sa.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.squapl.sa.domain.Appointment;
import com.squapl.sa.domain.Campaign;
import com.squapl.sa.domain.CampaignTags;

public interface CampaignTagsDao extends CrudRepository<CampaignTags, Long>{

	 List<CampaignTags> findAll();
}
