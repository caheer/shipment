package com.example.shipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class ShipmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipmentApplication.class, args);
    }

}
