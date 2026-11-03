package com.key_stones.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key_stones.Entity.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site,Long> {
	
	List<Site>findByCustomerId(Long customerId);
	

}
