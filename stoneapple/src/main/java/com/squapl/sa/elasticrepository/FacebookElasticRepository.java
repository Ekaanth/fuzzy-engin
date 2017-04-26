package com.squapl.sa.elasticrepository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.squapl.sa.domain.Facebook;

@Repository
public interface FacebookElasticRepository extends ElasticsearchRepository<Facebook, String> {

}
