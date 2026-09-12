package com.example.shipment.controller;

import com.example.shipment.dto.ShipmentListDto;
import com.example.shipment.model.Shipment;
import com.example.shipment.model.ShipmentStatus;
import com.example.shipment.service.ShipmentService;
import org.springframework.data.domain.Page;
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

    @PostMapping("/createNewShipment")
    public String createNewShipment(@RequestBody Shipment shipment) {

        if (shipment.getShipmentName() == null) {
            return "Shipment name can't be empty";
        }
        Shipment newShipment = shipmentService.createNewShipment(shipment);
        return "shipment/created, no: " + newShipment.getShipmentId();
    }

    @PatchMapping("/updateShipmentStatus/{shipmentId}")
    public String updateShipmentStatus(
            @PathVariable UUID shipmentId,
            @RequestBody ShipmentStatus shipmentStatus) {

        String statusUpdateResult =
                shipmentService.updateShipmentStatus(shipmentId, shipmentStatus);

        return statusUpdateResult;
    }

    @GetMapping("/getShipmentById/{shipmentId}")
    public Shipment getShipmentByShipmentId(@PathVariable UUID shipmentId) {
        Shipment shipment = shipmentService.findWithDetailsByShipmentId(shipmentId);
        return shipment;
    }

    @GetMapping("/getAll")
    public List<Shipment> getAllShipments() {
        List<Shipment> shipments = shipmentService.getAllShipmentsWithDetails();
        return shipments;
    }

    @GetMapping("/shipmentsList")
    public Page<ShipmentListDto> getShipments(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return shipmentService.getShipmentList(page, size);
    }

}