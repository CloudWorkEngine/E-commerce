package com.ecommerce.salesforce_ingestion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DataCloudIngestionService {

    private final WebClient webClient;
    private final DataCloudTokenService tokenService;

    @Value("${salesforce.data-cloud.ingest-base-url}")
    private String ingestBaseUrl;

    @Value("${salesforce.data-cloud.source-name}")
    private String sourceName;

    public void ingest(
            String salesforceAccessToken,
            String objectName,
            List<?> records
    ) {

        String dataCloudToken = tokenService.getDataCloudToken(salesforceAccessToken);

        Map<String, Object> payload = Map.of("data", records);

        webClient.post()
                .uri(ingestBaseUrl + "/api/v1/ingest/sources/{source}/{object}",
                        sourceName, objectName)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + dataCloudToken)
                .bodyValue(payload)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}