package org.example.user.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.example.user.dto.request.RoleUserCreationRequest;
import org.example.user.dto.request.UserCreationRequest;
import org.example.user.dto.respone.ApiRespone;
import org.example.user.entity.RoleUser;
import org.example.user.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roleuser")
public class RoleUserController {
    @Autowired
    private RoleUserService roleUserService;

    @PostMapping
    public ResponseEntity<RoleUser> createRoleUser(@RequestBody @Valid  RoleUserCreationRequest roleUserCreationRequest) {
        System.out.println(roleUserCreationRequest + "controller");
        RoleUser roleUser = roleUserService.createRoleUser(roleUserCreationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleUser);
    }

    @GetMapping
    List<RoleUser> getRoleUsers() {
        return roleUserService.getRoleUser();
    }

    @DeleteMapping("/{roleuserid}")
    String deleteRoleUser(@PathVariable Long roleuserid){
        roleUserService.deleteRoleUser(roleuserid);
        return "RoleUser deleted";
    }
}
