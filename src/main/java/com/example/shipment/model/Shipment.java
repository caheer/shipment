package com.example.shipment.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "shipment_id")
    private UUID shipmentId;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;


    public Shipment(UUID shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Shipment() {
    }
}
