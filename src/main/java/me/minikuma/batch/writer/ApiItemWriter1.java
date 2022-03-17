package me.minikuma.batch.writer;

import me.minikuma.batch.domain.ApiRequestVO;
import me.minikuma.batch.domain.ApiResponse;
import me.minikuma.batch.service.ApiService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ApiItemWriter1 implements ItemWriter<ApiRequestVO> {

    private final ApiService apiService;

    public ApiItemWriter1(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void write(List<? extends ApiRequestVO> items) throws Exception {
        ApiResponse service = apiService.service(items);
        System.out.println("service = " + service);
    }
}
