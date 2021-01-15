package org.example.service;

import org.example.dto.ProductDto;
import org.example.exception.ProductNotFoundException;
import org.example.mapper.ProductMapper;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper mapper;

    public List<ProductDto> getProductList() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(product -> mapper.productToDto(product))
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElse(null);
        ProductDto result = null;
        if (product != null) {
            result = mapper.productToDto(product);
        } else {
            throw new ProductNotFoundException();
        }
        return result;
    }

    public ProductDto saveProduct(ProductDto productDto) throws ProductNotFoundException {
        if (productDto.getId() != null && productDto.getId() > 0
                && !productRepository.existsById(productDto.getId())) {
            throw new ProductNotFoundException();
        }
        Product product = mapper.productDtoToModel(productDto);
        product = productRepository.save(product);
        return mapper.productToDto(product);
    }

    public ProductDto deleteProduct(Long id) throws ProductNotFoundException {
        ProductDto productDto = getProductById(id);
        productRepository.delete(mapper.productDtoToModel(productDto));
        return productDto;
    }
//    public ProductDto buyProduct(){
//
//    }
}
