
package com.key_stones.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.key_stones.DTO.CustomerDTO;
import com.key_stones.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create Customer
    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(
            @RequestBody CustomerDTO cus) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.createCustomer(cus));
    }

    // Update Customer
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(
            @PathVariable("id") Long id,
            @RequestBody CustomerDTO cust) {

        return ResponseEntity.ok(
                customerService.updateCustomer(id, cust));
    }

    // Get Customer by ID
    @GetMapping("/getCus/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    // Get All Customers
    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {

        return ResponseEntity.ok(customerService.getAlCustomer());
    }

    // Delete Customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(
            @PathVariable("id") Long id) {

        customerService.deleteCustomer(id);

        return ResponseEntity.ok("Customer deleted successfully");
    }
}
