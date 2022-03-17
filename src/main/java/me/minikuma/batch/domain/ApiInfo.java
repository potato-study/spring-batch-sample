package me.minikuma.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ApiInfo {
    private String url;
    private List<? extends ApiRequestVO> apiRequestList;
}
