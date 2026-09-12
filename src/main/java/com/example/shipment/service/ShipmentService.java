package com.example.shipment.service;

import com.example.shipment.dto.ShipmentListDto;
import com.example.shipment.model.Event;
import com.example.shipment.model.Shipment;
import com.example.shipment.model.ShipmentEvent;
import com.example.shipment.model.ShipmentStatus;
import com.example.shipment.repository.EventRepository;
import com.example.shipment.repository.ShipmentEventRepository;
import com.example.shipment.repository.ShipmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final EventRepository eventRepository;
    private final ShipmentEventRepository shipmentEventRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, EventRepository eventRepository, ShipmentEventRepository shipmentEventRepository) {
        this.shipmentRepository = shipmentRepository;
        this.eventRepository = eventRepository;
        this.shipmentEventRepository = shipmentEventRepository;
    }

    @Transactional
    public Shipment createNewShipment(Shipment shipment) {

        Event event = eventRepository.findByEventCode(4000000001L);
        Shipment newShipment = new Shipment(UUID.randomUUID(), null, ShipmentStatus.CREATED, null,
                null, shipment.getShipmentName(), null, null, null);
        shipmentRepository.save(newShipment);
        ShipmentEvent shipmentEvent = new ShipmentEvent(UUID.randomUUID(), newShipment, event, LocalDateTime.now());
        shipmentEventRepository.save(shipmentEvent);

        return newShipment;
    }


    @Transactional
    public String updateShipmentStatus(
            UUID shipmentId,
            ShipmentStatus shipmentStatus) {

        Shipment shipment = shipmentRepository.findByShipmentId(shipmentId);
        shipment.setShipmentStatus(shipmentStatus);
/*
        shipmentRepository.save(shipment); - not needed, entity is already managed, dirty checking will do the save
*/
        Event event = eventRepository.findByEventName(shipmentStatus.name());
        ShipmentEvent shipmentEvent = new ShipmentEvent(UUID.randomUUID(), shipment, event, LocalDateTime.now());
        shipmentEventRepository.save(shipmentEvent);

        return "Shipment " + shipmentId + "status updated to: " + shipmentStatus.getLabel();
    }

    @Transactional
    public List<Shipment> getAllShipmentsWithDetails() {
        List<Shipment> shipments = shipmentRepository.findAllWithDetails();
        return shipments;
    }

    @Transactional
    public Shipment findWithDetailsByShipmentId(UUID shipmentId) {
        Optional<Shipment> shipment = shipmentRepository.findWithDetailsByShipmentId(shipmentId);

/*        if(shipment.isPresent()){
            return shipment.get();
        } else {
            return null;
        }*/

        return shipment.orElse(null);
    }

    @Transactional
    public Page<ShipmentListDto> getShipmentList(int page, int size) {
        return shipmentRepository.findShipmentList(PageRequest.of(page, size));
    }


}