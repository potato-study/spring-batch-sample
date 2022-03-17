package me.minikuma.batch.service;

import me.minikuma.batch.domain.ApiInfo;
import me.minikuma.batch.domain.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public final class ApiService2 extends ApiService {
    @Override
    protected ApiResponse doApiService(RestTemplate restTemplate, ApiInfo apiInfo) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8082/product/2", apiInfo, String.class);
        int statusCode = responseEntity.getStatusCodeValue();
        return ApiResponse.builder()
                .status(statusCode)
                .message(responseEntity.getBody())
                .build();
    }
}
