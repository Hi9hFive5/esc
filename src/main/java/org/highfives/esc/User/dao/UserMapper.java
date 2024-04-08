package org.highfives.esc.User.dao;

import org.highfives.esc.User.dto.UserDTO;
import org.highfives.esc.User.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", source = "id")
    UserDTO userToUserDTO(User user);




    @Mapping(target = "id", source = "id")
    List<UserDTO> userListToUserListDTO(List<User> userList);

    User userDTOToUser(UserDTO userDTO);
}
