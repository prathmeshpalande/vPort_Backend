package com.virtual.portable.server.controller;

import com.virtual.portable.server.model.Credentials;
import com.virtual.portable.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.vidstige.jadb.JadbException;

import java.io.IOException;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public boolean getCredentials(@RequestBody Credentials credentials) throws IOException, JadbException {
        return loginService.processCredentials(credentials);
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
