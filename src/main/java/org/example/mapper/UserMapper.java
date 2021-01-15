package org.example.mapper;

import org.example.dto.UserDto;
import org.example.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface UserMapper {
    @Mappings({
            @Mapping(source = "listOfPurchasesId", target = "listOfPurchases.id"),
    })
    User userDtoToModel(UserDto dto);

    @Mappings({
            @Mapping(source = "listOfPurchases.id", target = "listOfPurchasesId"),
    })
    UserDto userToDto(User model);
}
