package me.minikuma.batch.chuck.processor;

import me.minikuma.domain.Product;
import me.minikuma.domain.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;

public class FileItemProcessor implements ItemProcessor<ProductDto, Product> {
    @Override
    public Product process(ProductDto item) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(item, Product.class);
    }
}
