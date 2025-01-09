package org.example.user.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.user.service.AuthenticationService;
import org.example.user.dto.request.AuthenticationRequest;
import org.example.user.dto.respone.ApiRespone;
import org.example.user.dto.respone.AuthenticationRespone;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;
    @PostMapping("/login")
    ApiRespone<AuthenticationRespone> authenticate(@RequestBody AuthenticationRequest request) {

        System.out.println("controller " + request);

        boolean result = authenticationService.authenticate(request);

        return ApiRespone.<AuthenticationRespone>builder()
                .result(AuthenticationRespone.builder()
                        .authenticated(result)
                        .build())
                .build();

    }
}
