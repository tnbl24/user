package org.example.user.controller;

import jakarta.validation.Valid;
import org.example.user.service.UserService;
import org.example.user.dto.request.UserCreationRequest;
import org.example.user.dto.request.UserUpdateRequest;
import org.example.user.dto.respone.ApiRespone;
import org.example.user.dto.respone.UserRespone;
import org.example.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiRespone<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiRespone apiRespone = new ApiRespone<>();
        apiRespone.setResult(userService.creatUser(request));
        return apiRespone;
    }

//    @PostMapping("/new")
//    public UserOutput show(@RequestParam("page") int page,@RequestParam("limit") int limit) {
//        UserOutput result = new UserOutput();
//        return result;

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserRespone getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserRespone updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User deleted";
    }

}
