package com.key_stones.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.key_stones.Entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
	
	Optional<Notification>findByEventType(String eventType);

}
