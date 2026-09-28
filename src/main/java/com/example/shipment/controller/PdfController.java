package com.example.shipment.controller;

import com.example.shipment.service.FakePdfGenerationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/pdf")
public class PdfController {

    private final FakePdfGenerationService fakePdfGenerationService;

    public PdfController(FakePdfGenerationService fakePdfGenerationService) {
        this.fakePdfGenerationService = fakePdfGenerationService;
    }

    @GetMapping("/generatePdf/{shipmentId}")
    public String generatePdf(@PathVariable UUID shipmentId) {

        Thread thread = new Thread(
                () -> fakePdfGenerationService.generateShipmentPdf(shipmentId)
        );

        thread.start();

        return "PDF generation started";
    }

}
