package com.example.shipment.controller;

import com.example.shipment.model.Customer;
import com.example.shipment.model.Shipment;
import com.example.shipment.model.ShipmentStatus;
import com.example.shipment.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/create")
    public String createShipment(@RequestBody Shipment shipment) {
        Shipment newShipment = shipmentService.createShipment(shipment);
        return "shipment/created, no: " + newShipment.getShipmentId();
    }

    @PostMapping("/createEmpty")
    public String createEmptyShipment() {
        Shipment shipment = shipmentService.createEmptyShipment();
/*
        shipment.setShipmentId(UUID.randomUUID());
*/
        return "shipment/created, no: " + shipment.getShipmentId();
    }

    @GetMapping("/get/{shipmentId}")
    public Shipment getShipmentByShipmentId(@PathVariable UUID shipmentId) {
        Shipment shipment = shipmentService.getShipmentByShipmentId(shipmentId);
        //shipment.setCustomer(new Customer(UUID.randomUUID()));

        return shipment;
    }

    @GetMapping("/getWithCustomer/{shipmentId}")
    public Shipment getShipmentByShipmentIdWithCustomerData(@PathVariable UUID shipmentId) {
        Shipment shipment = shipmentService.getShipmentByShipmentIdWithCustomerData(shipmentId);
        return shipment;
    }

    @GetMapping("/getAll")
    public List<Shipment> getAllShipments() {
        List<Shipment> shipments = shipmentService.getAllShipments();
        return shipments;
    }

    @GetMapping("/getAllTest")
    public String getAllShipmentsTest() {
        List<Shipment> shipments = shipmentService.getAllShipments();
        return "SHIPMENTS";
    }

    @PatchMapping("/update/{shipmentId}")
    public String updateShipmentStatus(
            @PathVariable UUID shipmentId,
            @RequestBody ShipmentStatus shipmentStatus) {

        String statusUpdateResult =
                shipmentService.updateShipmentStatus(shipmentId, shipmentStatus);

        return statusUpdateResult;
    }
}