
package com.key_stones.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.key_stones.DTO.SiteDTO;
import com.key_stones.Entity.Customer;
import com.key_stones.Entity.Site;
import com.key_stones.Repository.CustomerRepository;
import com.key_stones.Repository.SiteRepository;

@Service
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepo;
    private final CustomerRepository customerRepo;

    public SiteServiceImpl(SiteRepository siteRepo,
                           CustomerRepository customerRepo) {
        this.siteRepo = siteRepo;
        this.customerRepo = customerRepo;
    }

    // CREATE SITE
    @Override
    public SiteDTO createSite(SiteDTO site) {

        Customer customer = customerRepo.findById(site.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Site sites = new Site();

        sites.setSiteName(site.getSiteName());
        sites.setLanNo(site.getLanNo());
        sites.setBuildingName(site.getBuildingName());
        sites.setBuildingNo(site.getBuildingNo());
        sites.setFloorNo(site.getFloorNo());
        sites.setRoomNo(site.getRoomNo());
        sites.setCityName(site.getCityName());
        sites.setStateName(site.getStateName());
        sites.setLandMark(site.getLandMark());
        sites.setCountryName(site.getCountryName());
        sites.setZipCode(site.getZipCode());
        sites.setCustomer(customer);

        // Save and capture the generated ID
        Site savedSite = siteRepo.save(sites);

        return mapToDTO(savedSite);
    }

    // UPDATE SITE
    @Override
    public SiteDTO updateSite(Long id, SiteDTO dtos) {

        Site site = siteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Site not found"));

        site.setSiteName(dtos.getSiteName());
        site.setLanNo(dtos.getLanNo());
        site.setBuildingName(dtos.getBuildingName());
        site.setBuildingNo(dtos.getBuildingNo());
        site.setFloorNo(dtos.getFloorNo());
        site.setRoomNo(dtos.getRoomNo());
        site.setCityName(dtos.getCityName());
        site.setStateName(dtos.getStateName());
        site.setLandMark(dtos.getLandMark());
        site.setCountryName(dtos.getCountryName());
        site.setZipCode(dtos.getZipCode());

        if (dtos.getCustomerId() != null) {
            Customer customer = customerRepo.findById(dtos.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            site.setCustomer(customer);
        }

        Site updatedSite = siteRepo.save(site);

        return mapToDTO(updatedSite);
    }

    // GET SITE BY ID
    @Override
    public SiteDTO getSite(Long id) {

        Site site = siteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Site not found"));

        return mapToDTO(site);
    }

    // GET ALL SITES BY CUSTOMER ID
    @Override
    public List<SiteDTO> getAllSite(Long customerId) {

        return siteRepo.findByCustomerId(customerId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // DELETE SITE
    @Override
    public void deleteSite(Long id) {

        Site site = siteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Site not found"));

        siteRepo.delete(site);
    }

    // ENTITY TO DTO MAPPING
    private SiteDTO mapToDTO(Site site) {

        SiteDTO dto = new SiteDTO();

        dto.setId(site.getId());
        dto.setSiteName(site.getSiteName());
        dto.setLanNo(site.getLanNo());
        dto.setBuildingName(site.getBuildingName());
        dto.setBuildingNo(site.getBuildingNo());
        dto.setFloorNo(site.getFloorNo());
        dto.setRoomNo(site.getRoomNo());
        dto.setCityName(site.getCityName());
        dto.setStateName(site.getStateName());
        dto.setLandMark(site.getLandMark());
        dto.setCountryName(site.getCountryName());
        dto.setZipCode(site.getZipCode());

        if (site.getCustomer() != null) {
            dto.setCustomerId(site.getCustomer().getId());
        }

        return dto;
    }
}
