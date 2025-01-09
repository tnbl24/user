package org.example.user.service;

import lombok.extern.slf4j.Slf4j;
import org.example.user.dto.request.UserCreationRequest;
import org.example.user.dto.request.UserUpdateRequest;
import org.example.user.dto.respone.UserRespone;
import org.example.user.entity.User;
import org.example.user.exception.AppException;
import org.example.user.exception.ErrorCode;
import org.example.user.mapper.UserMapper;
import org.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User creatUser(UserCreationRequest request) {

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    @Cacheable(cacheNames = "cache1",key = "'listUser'")
    public List<User> getUsers() {
        log.info("get all users");
        return userRepository.findAll();
    }


    public UserRespone getUser(String id) {
        log.info("get by id users id : ",id);
        if (id == null || id.isEmpty()) {
            log.warn("ID is null or empty");
        } else {
            log.info("Fetching user with ID: {}", id);
        }
        return userRepository.findById(id)
                .map(userMapper ::toUserRespone)
                .orElseThrow(() -> new RuntimeException("User not found"))
                ;
    }

    @CachePut(cacheNames = "cache2",key="'user' + #id ")
    public UserRespone updateUser(String userId,UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUser(user,request);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

       return userMapper.toUserRespone(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
