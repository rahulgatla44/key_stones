package com.key_stones.Service;

import java.util.List;

import com.key_stones.Entity.Technician;

public interface TechnicianService {
	
	public Technician createTechnician(Technician technician);
	public Technician getTechnician(Long id);
	public List<Technician>getAllTechnician();
    public Technician updateTechnician (Long id,Technician technicians);
	public void deleteTechnician (Long id);
	

}
