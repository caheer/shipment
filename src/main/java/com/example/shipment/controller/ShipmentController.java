package com.example.shipment.controller;

import com.example.shipment.model.Shipment;
import com.example.shipment.model.ShipmentStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


// @Controller or @RestController?
@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    //@PathVariable @RequestBody annotations?

    @PostMapping("/create")
    public String createShipment() {
        Shipment shipment = new Shipment(UUID.randomUUID());
        return "shipment/create";
    }

    @GetMapping("/get/{id}")
    public String getShipmentById(@PathVariable UUID id) {
        return "shipment/get";
    }

    @GetMapping("/getAll")
    public String getAllShipments() {
        return "shipment/getAll";
    }

    //{"status": "IN_TRANSIT"} - for typical JSON the RequestBody TYPE will have to be modified
    @PatchMapping("/update/{id}")
    public String updateShipmentStatus(@PathVariable UUID id, @RequestBody ShipmentStatus shipmentStatus) {
        return "shipment/update";
    }
}
