package me.minikuma.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private int status;
    private String message;

    @Builder
    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
