package me.minikuma.batch.chuck.processor;

import me.minikuma.batch.domain.ApiRequestVO;
import me.minikuma.batch.domain.ProductVO;
import org.springframework.batch.item.ItemProcessor;

public class ApiItemProcessor1 implements ItemProcessor<ProductVO, ApiRequestVO> {
    @Override
    public ApiRequestVO process(ProductVO item) throws Exception {
        return ApiRequestVO.builder()
                .id(item.getId())
                .productVO(item)
                .build();
    }
}
