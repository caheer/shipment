package com.example.playground;

import com.example.shipment.dto.ShipmentListDto;
import com.example.shipment.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

// ONLY FOR STREAM PRACTICE
@Service
public class ShipmentStreamingService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentStreamingService(ShipmentRepository shipmentRepository, EventRepository eventRepository, ShipmentEventRepository shipmentEventRepository, ShipmentSearchByCriteriaRepository shipmentSearchByCriteriaRepository, EntityManager entityManager) {
        this.shipmentRepository = shipmentRepository;
    }


    @Transactional
    public void processShipmentsData(String textToFind) {

/*
        List<ShipmentComment> shipmentCommentList = shipmentRepository.findAllShipmentsWithComments()
                .stream()
                .flatMap(shipment -> shipment.getShipmentComments()
                        .stream())
                .filter(c -> c.getCommentText()
                        .contains(textToFind)).toList();
*/


/*        List<String> shipmentListDtos = shipmentRepository.findShipmentList(PageRequest.of(0, 10)).stream().map(a -> a.shipmentName()).toList();

        List<ShipmentListDto> shipmentListDtos1 = shipmentRepository.getShipmentsWithComments()
                .stream().map(shipment -> new ShipmentListDto(shipment.getShipmentId(),
                        shipment.getCustomer().getCustomerId(), shipment.getCustomer().getCustomerName(),
                        shipment.getShipmentName(), shipment.getShipmentStatus())).toList();


    }*/

/*    @Transactional
    public List<Shipment> getAllShipmentsWithDetails() {
        List<Shipment> shipments = shipmentRepository.findAllWithDetails();
        return shipments;
    }

    @Transactional
    public Shipment getShipmentByShipmentId(UUID shipmentId) {
        Optional<Shipment> shipment = shipmentRepository.findWithDetailsByShipmentId(shipmentId);

*//*        if(shipment.isPresent()){
            return shipment.get();
        } else {
            return null;
        }*//*

        return shipment.orElse(null);
    }*/


    }
}