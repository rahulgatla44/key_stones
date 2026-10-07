package com.key_stones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key_stones.Entity.EmailLogs;

@Repository
public interface EmailLogRepository extends JpaRepository<EmailLogs,Long> {
	

}
