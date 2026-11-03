package com.key_stones.Service;

import java.util.List;

import com.key_stones.DTO.CustomerDTO;

public interface CustomerService {
	
	public CustomerDTO createCustomer(CustomerDTO cus);
	
	public CustomerDTO updateCustomer(Long id,CustomerDTO cust);
	
	public CustomerDTO getCustomer(Long id);
	
	public List<CustomerDTO> getAlCustomer();
	
	public void deleteCustomer(Long id);

	
	

}