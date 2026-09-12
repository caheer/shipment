package com.example.shipment.repository;

import com.example.shipment.dto.ShipmentListDto;
import com.example.shipment.model.Shipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {

    Shipment findByShipmentId(UUID shipmentId);

    @EntityGraph(attributePaths = {
            "insurance",
            "insurance.provider",
            "customer",
            "assignedCourier"
    })
    @Query("select s from Shipment s")
    List<Shipment> findAllWithDetails();

    @Query("""
                select new com.example.shipment.dto.ShipmentListDto(
                    s.shipmentId,
                    c.customerId,
                    c.customerName,
                    s.shipmentName,
                    s.shipmentStatus
                )
                from Shipment s
                left join s.customer c
            """)
    Page<ShipmentListDto> findShipmentList(Pageable pageable);


    @EntityGraph(attributePaths = {
            "customer",
            "insurance",
            "insurance.provider",
            "assignedCourier"
    })
    Optional<Shipment> findWithDetailsByShipmentId(UUID shipmentId);


}
