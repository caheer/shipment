package com.example.shipment.repository;

import com.example.shipment.model.Shipment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {

    List<Shipment> getShipmentByShipmentId(UUID shipmentId);

    Shipment findByShipmentId(UUID shipmentId);

    @EntityGraph(attributePaths = {
            "insurance",
            "insurance.provider",
            "customer"
    })
    @Query("select s from Shipment s")
    List<Shipment> findAllWithDetails();


    @Query("""
                select s
                from Shipment s
                left join fetch s.insurance
            """)
    List<Shipment> findAllWithInsurance();

    @Query("""
                select s
                from Shipment s
                left join fetch s.customer
                where s.shipmentId = :shipmentId
            """)
    Shipment findByShipmentIdWithCustomerData(UUID shipmentId);

}
