package com.example.shipment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

// Used only when we use composite key for shipment_tags, and want it as entity
@Embeddable
public class ShipmentTagId implements Serializable {

    @Column(name = "shipment_id")
    private UUID shipmentId;

    @Column(name = "tag_code")
    private Long tagCode;

    protected ShipmentTagId() {
    }

    public ShipmentTagId(UUID shipmentId, Long tagCode) {
        this.shipmentId = shipmentId;
        this.tagCode = tagCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipmentTagId that)) return false;

        return Objects.equals(shipmentId, that.shipmentId)
                && Objects.equals(tagCode, that.tagCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipmentId, tagCode);
    }
}