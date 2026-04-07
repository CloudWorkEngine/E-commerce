package com.ecommerce.salesforce_ingestion.controller;

import com.ecommerce.salesforce_ingestion.service.DataCloudIngestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/ingest")
public class IngestionController {

    private final DataCloudIngestionService ingestionService;

    @PostMapping("/{objectName}")
    public ResponseEntity<Void> ingest(
            @RequestHeader("Salesforce-Access-Token") String sfToken,
            @PathVariable String objectName,
            @RequestBody List<Map<String, Object>> records
    ) {
        ingestionService.ingest(sfToken, objectName, records);
        return ResponseEntity.ok().build();
    }
}