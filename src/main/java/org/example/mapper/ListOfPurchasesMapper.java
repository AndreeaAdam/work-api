package org.example.mapper;

import org.example.dto.ListOfPurchasesDto;
import org.example.model.ListOfPurchases;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")

public interface ListOfPurchasesMapper {
    @Mappings({
            @Mapping(source = "productId", target = "product.id"),
    })
    ListOfPurchases listOfPurchasesDtoToModel(ListOfPurchasesDto dto);
    @Mappings({
            @Mapping(source = "product.id", target = "productId"),
    })
    ListOfPurchasesDto listOfPurchasesToDto(ListOfPurchases model);
}


