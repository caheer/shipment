package com.example.shipment.model;

import jakarta.persistence.*;

/*pure join table
→ direct @ManyToMany

join table modeled as entity + composite PK
→ ShipmentTag + @EmbeddedId/@IdClass

join table modeled as entity + surrogate PK
→ ShipmentTag + normal @Id*/

/*
Whether ShipmentTag is an entity determines whether the Java relationship
is direct or indirect.

The type of PK only determines how ShipmentTag itself is identified.
*/

@Entity
@Table(name = "shipment_tags")
public class ShipmentTag {

    public ShipmentTag() {
    }

    public ShipmentTag(Shipment shipment, Tag tag) {
        this.shipment = shipment;
        this.tag = tag;

        this.id = new ShipmentTagId(
                shipment.getShipmentId(),
                tag.getTagCode()
        );
    }

    // version 1 : N/A in this case, we're not modeling ShipmentTag as entity

    // version 2: ShipmentTag is modeled as an entity with a composite primary key
    @EmbeddedId
    private ShipmentTagId id;

    @ManyToOne
    @MapsId("shipmentId")
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @ManyToOne
    @MapsId("tagCode")
    @JoinColumn(name = "tag_code")
    private Tag tag;

    /* version 3: ShipmentTag is modeled as an entity with its own surrogate primary key
    @Id
    @Column(name="shipment_tag_id")
    private UUID shipmentTagId;

    @ManyToOne
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

    @ManyToOne
    @JoinColumn(name = "tag_code", nullable = false)
    private Tag tag;*/
}



