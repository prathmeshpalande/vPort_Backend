package com.virtual.portable.server.task;

import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;

import java.io.IOException;
import java.util.List;

public class ScreenGrabTask extends Thread {

    @Override
    public void run() {

        try {
//            JadbConnection jadbConnection = new JadbConnection();
//            List<JadbDevice> devices = jadbConnection.getDevices();
//
//            JadbDevice device = devices.get(0);


//            while(true) {

//                long startTime = System.currentTimeMillis();
                ADBExecutor.executeADBCommand("powershell.exe adb shell screencap -p /sdcard/screencap.png");
                ADBExecutor.executeADBCommand("powershell.exe adb pull /sdcard/screencap.png");

//                ADBExecutor.executeADBCommand("adb shell screencap -p | sed 's/\r$//' > screencap.png");
//                ADBExecutor.executeADBCommand("adb exec-out screencap -p -");



//                ADBExecutor.executeADBCommand("adb exec-out screencap -p > screencap.png");
//                device.executeShell("screencap -p /sdcard/screencap.png");
//                device.execute("pull /sdcard/screencap.png screencap.png");

//                System.out.println("Time Taken: " + (System.currentTimeMillis() - startTime));
//            }
        } catch (IOException e) {
            e.printStackTrace();
//        } catch (JadbException e) {
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
