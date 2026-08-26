package com.example.shipment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name = "tags")
@Entity
@Getter
@Setter
public class Tag {

    protected Tag() {
    }

    @Id
    @Column(name = "tag_code")
    private Long tagCode;

    @Column(name = "tag_name", length = 100, unique = true, nullable = false)
    private String tagName;

    /* version1 - shipment_tags is not represented as an entity, so we are making
    direct linke between Shipment and Tag,
    @ManyToMany(mappedBy = "tags")
    private Set<Shipment> shipments = new HashSet<>(); */

    // version 2: ShipmentTag is modeled as an entity with a composite primary key
    @OneToMany(mappedBy = "tag")
    private Set<ShipmentTag> shipmentTags = new HashSet<>();

    /* version 3: ShipmentTag is modeled as an entity with its own surrogate primary key
    @OneToMany(mappedBy = "tag")
    private Set<ShipmentTag> shipmentTags = new HashSet<>();*/

}