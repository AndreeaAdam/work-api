package org.example.mapper;

import org.example.dto.ProductDto;
import org.example.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ProductMapper {
    Product productDtoToModel(ProductDto dto);

    ProductDto productToDto(Product model);
}
