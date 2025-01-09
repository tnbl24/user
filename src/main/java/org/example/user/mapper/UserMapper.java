package org.example.user.mapper;

import org.example.user.dto.request.UserCreationRequest;
import org.example.user.dto.request.UserUpdateRequest;
import org.example.user.dto.respone.UserRespone;
import org.example.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
   User toUser(UserCreationRequest request);
   void updateUser(@MappingTarget User user, UserUpdateRequest request);
   UserRespone toUserRespone(User user);
}
