
package com.key_stones.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key_stones.ENUM.AvailableStatus;
import com.key_stones.Entity.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {

    Optional<Technician> findByEmpcode(String empcode);

    Optional<Technician> findByEmail(String email);

    List<Technician> findByActiveTrue();

    List<Technician> findByAvailable(AvailableStatus available);

    boolean existsByEmpcode(String empcode);

    boolean existsByEmail(String email);
}
