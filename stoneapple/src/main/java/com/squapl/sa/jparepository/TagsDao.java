package com.squapl.sa.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squapl.sa.domain.Tags;

public interface TagsDao extends JpaRepository<Tags, Long>{

}
