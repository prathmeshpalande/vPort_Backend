package com.virtual.portable.server.controller;

import com.virtual.portable.server.model.GeneralResponseObject;
import com.virtual.portable.server.model.TouchCoordinates;
import com.virtual.portable.server.service.TouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.vidstige.jadb.JadbException;

import java.io.IOException;

@RestController
public class InputController {

    @Autowired
    TouchService touchService;

    @PostMapping("/post_coordinates")
    public GeneralResponseObject acceptCoordinates(@RequestBody TouchCoordinates touchCoordinates) throws IOException, JadbException {

        System.out.println("Received Coos:" + touchCoordinates.getX_coor() + ", " + touchCoordinates.getY_coor());
        GeneralResponseObject generalResponseObject = touchService.processCoordinates(touchCoordinates);

        System.out.println("Touch Simulated Successfully!");
        return generalResponseObject;

    }

    @PostMapping("register_resolution")
    public GeneralResponseObject acceptResolution(@RequestBody TouchCoordinates resolutionCoordinates) {

        GeneralResponseObject generalResponseObject = touchService.registerResolution(resolutionCoordinates);

        return generalResponseObject;
    }
}
