package com.example.shipment.repository;

import com.example.shipment.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByEventCode(Long eventCode);

    Event findByEventName(String eventName);
}
