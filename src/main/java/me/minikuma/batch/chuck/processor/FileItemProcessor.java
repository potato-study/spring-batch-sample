package me.minikuma.batch.chuck.processor;

import me.minikuma.batch.domain.Product;
import me.minikuma.batch.domain.ProductVO;
import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;

public class FileItemProcessor implements ItemProcessor<ProductVO, Product> {
    @Override
    public Product process(ProductVO item) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(item, Product.class);
    }
}
