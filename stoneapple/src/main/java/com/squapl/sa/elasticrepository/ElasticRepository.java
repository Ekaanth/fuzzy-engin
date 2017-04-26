package com.squapl.sa.elasticrepository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.squapl.sa.domain.YoutubeElasticsearch;

@Repository
public interface ElasticRepository extends ElasticsearchRepository<YoutubeElasticsearch, String> {
    
}
