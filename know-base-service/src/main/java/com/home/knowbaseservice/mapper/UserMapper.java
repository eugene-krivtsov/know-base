package com.home.knowbaseservice.mapper;

import com.home.knowbaseservice.dto.UserDTO;
import com.home.knowbaseservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {

    UserDTO toDTO(User entity);
}
