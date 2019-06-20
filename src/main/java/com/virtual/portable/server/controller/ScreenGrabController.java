package com.virtual.portable.server.controller;

import com.virtual.portable.server.model.GeneralResponseObject;
import com.virtual.portable.server.service.ScreenGrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.vidstige.jadb.JadbException;

import java.io.File;
import java.io.IOException;

@RestController
public class ScreenGrabController {

    @Autowired
    ScreenGrabService screenGrabService;

    @GetMapping("/grab_screen")
    public @ResponseBody byte[] grabScreen() throws IOException, JadbException {

        System.out.println("Received Screen Grab Request");
        byte[] imageByteArray = screenGrabService.grabScreen();

        return imageByteArray;
    }
}
