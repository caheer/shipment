package com.example.playground;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class DeliveryItem {

    protected UUID id;
    protected BigDecimal weight;

    public DeliveryItem(UUID id, BigDecimal weight) {
        this.id = id;
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public abstract BigDecimal calculatePrice();
}