package com.key_stones.Service;

import java.util.List;

import com.key_stones.DTO.SiteDTO;

public interface SiteService {
	
	public SiteDTO createSite(SiteDTO site);
	
	public SiteDTO updateSite(Long siteId,SiteDTO sites);
	
	public SiteDTO getSite(Long id);
	
	public List<SiteDTO>getAllSite(Long customerId);
	
	public void deleteSite(Long id);
	

}
