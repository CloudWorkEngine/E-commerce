package com.ecommerce.salesforce_ingestion.service;

import com.ecommerce.salesforce_ingestion.dto.DataCloudTokenResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class DataCloudTokenService {

    private final WebClient webClient;

    @Value("${salesforce.auth.base-url}")
    private String authBaseUrl;

    @Value("${salesforce.data-cloud.token-path}")
    private String tokenPath;

    private String cachedToken;
    private Instant expiry;

    public String getDataCloudToken(String salesforceAccessToken) {

        if (cachedToken != null && expiry != null && Instant.now().isBefore(expiry)) {
            return cachedToken;
        }

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "urn:salesforce:grant-type:external:cdp");
        form.add("subject_token", salesforceAccessToken);
        form.add("subject_token_type", "urn:ietf:params:oauth:token-type:access_token");

        DataCloudTokenResponse response =
                webClient.post()
                        .uri(authBaseUrl + tokenPath)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .bodyValue(form)
                        .retrieve()
                        .bodyToMono(DataCloudTokenResponse.class)
                        .block();

        cachedToken = response.getAccessToken();
        expiry = Instant.now().plusSeconds(response.getExpiresIn() - 60);

        return cachedToken;
    }
}

