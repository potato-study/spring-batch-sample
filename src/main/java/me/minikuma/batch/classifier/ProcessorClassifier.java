package me.minikuma.batch.classifier;

import me.minikuma.batch.domain.ApiRequestVO;
import me.minikuma.batch.domain.ProductVO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import java.util.HashMap;
import java.util.Map;

public class ProcessorClassifier<C, T> implements Classifier<C, T> {

    private Map<String, ItemProcessor<ProductVO, ApiRequestVO>> processorMap = new HashMap<>();

    @Override
    public T classify(C classifiable) {
        return (T) processorMap.get(((ProductVO) classifiable).getType()); // 1, 2, 3 값이 들어 올수 있음
    }

    public void setProcessorMap(Map<String, ItemProcessor<ProductVO, ApiRequestVO>> processorMap) {
        this.processorMap = processorMap;
    }
}
