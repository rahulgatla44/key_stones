package com.key_stones.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key_stones.DTO.CustomerDTO;
import com.key_stones.Entity.Customer;
import com.key_stones.Repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private  CustomerRepository customerRepo;
	@Override
	public CustomerDTO createCustomer(CustomerDTO cus) {

	    if (customerRepo.existsByUserEmail(cus.getCustomerEmail())) {
	        throw new RuntimeException("Customer email already exists");
	    }

	    if (customerRepo.existsByPhone(cus.getCustomerPhone())) {
	        throw new RuntimeException("Customer phone already exists");
	    }

	    Customer customer = new Customer();

	    customer.setUserEmail(cus.getCustomerEmail());
	    customer.setPhone(cus.getCustomerPhone());
	    customer.setAddress(cus.getAddress());
	    customer.setContactPerson(cus.getContactPerson());
	    customer.setActive(true);
	    customer.setCreatedAt(LocalDateTime.now());

	    // Save and get the generated database ID
	    Customer savedCustomer = customerRepo.save(customer);

	    return mapDTO(savedCustomer);
	}
	
	@Override
	public CustomerDTO updateCustomer(Long id,CustomerDTO cust) {
		
		Customer customer = customerRepo.findById(id)
				     .orElseThrow(()-> new RuntimeException("Customer not found"));
		
		customer.setContactPerson(cust.contactPerson);
		customer.setPhone(cust.customerPhone);
		customer.setAddress(cust.address);
		customerRepo.save(customer);
		
		return mapDTO(customer);
		
	}
	@Override
    public CustomerDTO getCustomer(Long id) {
		
		Customer customer = customerRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Customer not found"));
		return mapDTO(customer);
	}
	@Override
	public List<CustomerDTO> getAlCustomer() {
	    return customerRepo.findAll()
	            .stream()
	            .map(this::mapDTO)
	            .collect(Collectors.toList());
	}
	@Override
	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);
	}
	
	private CustomerDTO mapDTO(Customer customers) {

	    CustomerDTO dto = new CustomerDTO();

	    dto.setId(customers.getId());
	    dto.setCustomerEmail(customers.getUserEmail());
	    dto.setCustomerPhone(customers.getPhone());
	    dto.setAddress(customers.getAddress());
	    dto.setContactPerson(customers.getContactPerson());
	    dto.setActive(customers.isActive());

	    return dto;
	}


}
