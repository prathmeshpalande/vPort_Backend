package com.virtual.portable.server.service;

import com.virtual.portable.server.model.GeneralResponseObject;
import com.virtual.portable.server.model.TouchCoordinates;
import org.springframework.stereotype.Service;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;

import java.io.IOException;
import java.util.List;

@Service
public class TouchService {

    TouchCoordinates resolutionCoordinates;

    public GeneralResponseObject processCoordinates(TouchCoordinates touchCoordinates) throws IOException, JadbException {

        //TODO: Send touches to virtual device through ADB

        System.out.println("Touch Received: " + touchCoordinates.getX_coor() + ", " + touchCoordinates.getY_coor());

        JadbConnection jadbConnection = new JadbConnection();
        List<JadbDevice> devices = jadbConnection.getDevices();

        JadbDevice device = devices.get(0);

        device.executeShell("input tap " + touchCoordinates.getX_coor() + " " + touchCoordinates.getY_coor());

        return new GeneralResponseObject(1, "Success");

    }

    public GeneralResponseObject registerResolution(TouchCoordinates resolutionCoordinates) {


        this.resolutionCoordinates = resolutionCoordinates;
        System.out.println("Registered Resolution: " + resolutionCoordinates.getX_coor() + ", " + resolutionCoordinates.getY_coor());

        return new GeneralResponseObject(1, "Resolution Coordinates Registered Successfully!");
    }
}
