package org.example.user.service;

import org.example.user.dto.request.RoleUserCreationRequest;
import org.example.user.entity.RoleUser;
import org.example.user.mapper.RoleUserMapper;
import org.example.user.mapper.UserMapper;
import org.example.user.repository.RoleUserRepository;
import org.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleUserService {
    @Autowired
    private RoleUserRepository roleUserRepository;

    @Autowired
    private RoleUserMapper roleUserMapper;

    public RoleUser createRoleUser(RoleUserCreationRequest request) {
        if(roleUserRepository.existsByRole(request.getRole()))
            throw new RuntimeException();

        System.out.println("request " + request);

        RoleUser roleUser = roleUserMapper.roleUserToRoleUser(request);

        return roleUserRepository.save(roleUser);
    }

    public List<RoleUser> getRoleUser() {
        return roleUserRepository.findAll();
    }

    public void deleteRoleUser(Long roleUserId) {
        roleUserRepository.deleteById(roleUserId);
    }
}
