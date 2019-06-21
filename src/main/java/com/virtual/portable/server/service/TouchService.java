package com.virtual.portable.server.service;

import com.virtual.portable.server.model.GeneralResponseObject;
import com.virtual.portable.server.model.TouchCoordinates;
import com.virtual.portable.server.task.ADBExecutor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;

import java.io.IOException;
import java.util.List;

@Service
public class TouchService implements InitializingBean {

    TouchCoordinates resolutionCoordinatesClient;
    TouchCoordinates resolutionCoordinatesVirtual;
    Double xMultiplier;
    Double yMultiplier;

    public GeneralResponseObject processCoordinates(TouchCoordinates touchCoordinates) throws IOException, JadbException {

        //TODO: Send touches to virtual device through ADB

        System.out.println("Touch Received: " + touchCoordinates.getX_coor() + ", " + touchCoordinates.getY_coor());
        System.out.println("Touch ReScaled: " + (touchCoordinates.getX_coor() * xMultiplier) + ", " + (touchCoordinates.getY_coor() * yMultiplier));


        JadbConnection jadbConnection = new JadbConnection();
        List<JadbDevice> devices = jadbConnection.getDevices();

        JadbDevice device = devices.get(0);

        device.executeShell("input tap " + (touchCoordinates.getX_coor() * xMultiplier) + " " + (touchCoordinates.getY_coor() * yMultiplier));

        return new GeneralResponseObject(1, "Success");

    }

    public GeneralResponseObject registerResolution(TouchCoordinates resolutionCoordinates) {


        this.resolutionCoordinatesClient = resolutionCoordinates;
        System.out.println("Registered Resolution: " + resolutionCoordinates.getX_coor() + ", " + resolutionCoordinates.getY_coor());

//        xMultiplier = Math.max(resolutionCoordinatesClient.getX_coor(), resolutionCoordinatesVirtual.getX_coor())
//                / Math.min(resolutionCoordinatesClient.getX_coor(), resolutionCoordinatesVirtual.getX_coor());
//
//        yMultiplier = Math.max(resolutionCoordinatesClient.getY_coor(), resolutionCoordinatesVirtual.getY_coor())
//                / Math.min(resolutionCoordinatesClient.getY_coor(), resolutionCoordinatesVirtual.getY_coor());

        xMultiplier = (double) resolutionCoordinatesVirtual.getX_coor() / resolutionCoordinatesClient.getX_coor();
        yMultiplier = (double) resolutionCoordinatesVirtual.getY_coor() / resolutionCoordinatesClient.getY_coor();

        System.out.println("xMul: " + xMultiplier);
        System.out.println("yMul: " + yMultiplier);
        return new GeneralResponseObject(1, "Resolution Coordinates Registered Successfully!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {


//        ADBExecutor.executeADBCommand("powershell.exe adb shell \"dumpsys window | grep cur= |tr -s \" \" | cut -d \" \" -f 4|cut -d \"=\" -f 2\"");

        TouchCoordinates touchCoordinates = new TouchCoordinates();
        touchCoordinates.setX_coor(1080);
        touchCoordinates.setY_coor(1920);
        this.resolutionCoordinatesVirtual = touchCoordinates;

    }
}
