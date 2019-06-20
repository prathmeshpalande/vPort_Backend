package com.virtual.portable.server.task;

import java.io.IOException;

public class ScreenGrabTask extends Thread {

    @Override
    public void run() {

        try {
            while(true) {

                long startTime = System.currentTimeMillis();
                ADBExecutor.executeADBCommand("powershell.exe adb shell screencap -p /sdcard/screencap.png");
                ADBExecutor.executeADBCommand("powershell.exe adb pull /sdcard/screencap.png");
                System.out.println("Time Taken: " + (System.currentTimeMillis() - startTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
