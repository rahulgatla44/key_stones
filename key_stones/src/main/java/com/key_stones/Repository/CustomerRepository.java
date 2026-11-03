
package com.key_stones.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key_stones.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUserEmail(String userEmail);

    boolean existsByUserEmail(String userEmail);

    Optional<Customer> findByPhone(String phone);

    boolean existsByPhone(String phone);
}

