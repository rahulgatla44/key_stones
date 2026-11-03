package com.key_stones.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.key_stones.Entity.Technician;
import com.key_stones.Repository.TechnicianRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechnicianServiceImpl implements TechnicianService {
	
	@Autowired
	private TechnicianRepository techinicianRepo;
	
	@Override
	@Transactional
	public Technician createTechnician(Technician technician) {
		
		
		if(techinicianRepo.existsByEmpcode(technician.getEmpcode())) {
			throw new RuntimeException("Employee code already exist");
		}
		
		if(techinicianRepo.existsByEmail(technician.getEmail())) {
			throw new RuntimeException("Employee email already exist");
		}
		
		technician.setId(null);
		technician.setActive(true);
		
		return techinicianRepo.save(technician);
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Technician getTechnician(Long id) {
		
		return techinicianRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Technician not found:"+id));
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Technician>getAllTechnician() { 
		return techinicianRepo.findAll();
	}
	
	@Override
	@Transactional
	public Technician updateTechnician (Long id,Technician technicians) {
		Technician existing= getTechnician(id);
		
		//if(!existing.getEmail().equalsIgnoreCase(technicians.getEmail() && techinicianRepo.existByEmail(technicians.getEmail()))) {
			//throw new RuntimeException("Email already exist");
		//}
		existing.setName(technicians.getName());
		existing.setEmail(technicians.getEmail());
		existing.setPhone(technicians.getPhone());
		existing.setSpecialization(technicians.getSpecialization());
		existing.setAvailable(technicians.getAvailable());
		existing.setCity(technicians.getCity());
		existing.setState(technicians.getState());
		existing.setZipCode(technicians.getZipCode());
		
		return techinicianRepo.save(existing);
		
	}
	
	@Override
	public void deleteTechnician (Long id) {
		
		Technician technician= getTechnician(id);
		technician.setActive(false);
		
		techinicianRepo.save(technician);
		
		
		
	}

	

}
