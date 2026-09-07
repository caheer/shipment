package com.example.shipment.service;

import com.example.shipment.model.Customer;
import com.example.shipment.model.Shipment;
import com.example.shipment.model.ShipmentStatus;
import com.example.shipment.repository.ShipmentRepository;
import com.fasterxml.uuid.Generators;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(Shipment shipment) {
        // SAVE SHIPMENT TO DB
        // exception handling
        return shipment;
    }

    public Shipment createEmptyShipment() {

        //UUID uuid = Generators.timeBasedEpochGenerator().generate(); // Version 7
        Shipment shipment = new Shipment(UUID.randomUUID());

        Customer customer = new Customer(UUID.randomUUID());

        // SAVE SHIPMENT TO DB
        // exception handling

        return shipment;
    }

    public String updateShipmentStatus(
            UUID shipmentId,
            ShipmentStatus shipmentStatus) {

        // get shipment from DB by its shipmentId
        // UPDATE SHIPMENT STATUS IN DB
        // IF SUCCESSFUL RETURN SUCCESS MESSAGE, ELSE RETURN FAILURE MESSAGE
        // handle exceptions

        return "Result of status update...";
    }

    @Transactional
    public List<Shipment> getAllShipments() {

        System.out.println("############################ LOADING ALL SHIPMENTS FROM DB...");
        List<Shipment> shipments = shipmentRepository.findAll();
        System.out.println("############################FINISHED LOADING ALL SHIPMENTS FROM DB...");

        for (Shipment shipment : shipments) {
            System.out.println(
                    shipment.getCustomer().getCustomerName()
            );
        }

        // GET ALL SHIPMENTS FROM DB
        // handle exceptions

        return shipments;
    }

    @Transactional
    public Shipment getShipmentByShipmentId(UUID shipmentId) {

        Shipment someShipment = shipmentRepository.findByShipmentId(shipmentId);
        //Customer customer = someShipment.getCustomer();
        someShipment.setCustomer(new Customer(UUID.randomUUID()));
        //String email = someShipment.getCustomer().getCustomerEmail();
/*        Customer customer = someShipment.getCustomer();

        String customerName = customer.getCustomerName();

        String email = customer.getCustomerEmail();*/


        // GET SHIPMENT FROM DB BY shipmentId
        // more than one shipment with the same id?
        // constraints on db should prevent this
        // no shipment found? - return null?
        // Or throw exception?
        // maybe use Optional?

        return someShipment;
    }

    @Transactional
    public Shipment getShipmentByShipmentIdWithCustomerData(UUID shipmentId) {

        Shipment someShipment = shipmentRepository.findByShipmentIdWithCustomerData(shipmentId);
        return someShipment;
    }
}