package com.example.playground;


import java.math.BigDecimal;
import java.util.UUID;

public class BasicShipment extends DeliveryItem {

    private UUID id;
    private BigDecimal weight;

    public BasicShipment(UUID id, BigDecimal weight) {
        super(id, weight);
    }

    @Override
    public BigDecimal calculatePrice() {

        return weight.multiply(BigDecimal.TEN);
    }
}

