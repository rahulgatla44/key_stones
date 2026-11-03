package com.key_stones.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.key_stones.DTO.SiteDTO;
import com.key_stones.Service.SiteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sites")
@RequiredArgsConstructor
public class SiteController {
	
	@Autowired
	private SiteService siteService;
	
	
	@PostMapping("/create")
	public ResponseEntity<SiteDTO> createSite(@RequestBody SiteDTO site) {
	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(siteService.createSite(site));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<SiteDTO>updateSite(@PathVariable Long id,@RequestBody SiteDTO dtos) {
		return ResponseEntity.ok(siteService.updateSite(id, dtos));
	}
	
	@GetMapping("/getSite/{id}")
	public ResponseEntity<SiteDTO>getSite(@PathVariable Long id) {
		return ResponseEntity.ok(siteService.getSite(id));
	}
	
	@GetMapping("/all/{customerId}")
	public ResponseEntity<List<SiteDTO>>getAllSite(@PathVariable Long customerId) {
		return ResponseEntity.ok(siteService.getAllSite(customerId));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteSite(@PathVariable Long id) {
		siteService.deleteSite(id);
		return ResponseEntity.ok("Site deleted Successfully");
	}

}
