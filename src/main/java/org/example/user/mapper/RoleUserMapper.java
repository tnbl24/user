package org.example.user.mapper;

import org.example.user.dto.request.RoleUserCreationRequest;
import org.example.user.entity.RoleUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleUserMapper {
    RoleUser roleUserToRoleUser(RoleUserCreationRequest request);
}
