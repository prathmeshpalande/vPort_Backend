package com.virtual.portable.server.service;

import com.virtual.portable.server.task.ADBExecutor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Service
public class ScreenGrabService {

    public byte[] grabScreen() throws IOException, JadbException {

//        JadbConnection jadbConnection = new JadbConnection();
//        List<JadbDevice> devices = jadbConnection.getDevices();
//
//        JadbDevice device = devices.get(0);
//
//        device.executeShell("screencap -p /sdcard/screencap.png");
//        device.execute("pull /sdcard/screencap.png");


//        ADBExecutor.executeADBCommand("powershell.exe adb shell screencap -p /sdcard/screencap.png");
//        ADBExecutor.executeADBCommand("powershell.exe adb pull /sdcard/screencap.png");

//        InputStream in = getClass().getResourceAsStream("C:\\Users\\palan\\IdeaProjects\\portableserver\\screencap.png");

//        return getByteArray(new File("screencap.png"));

        System.out.println("Reading Image File");
        BufferedImage bImage = ImageIO.read(new File("screencap.png"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", bos );
        byte [] data = bos.toByteArray();

//        return IOUtils.toByteArray(in);
        System.out.println("Converted to byte array, returning");
        return data;
    }

    public byte[] getByteArray(File file) {

        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();

        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }
        return bArray;

    }

//    public void executeADBCommand(String command) throws IOException {
//
//        //String command = "powershell.exe  your command";
//        //Getting the version
////        String command = "powershell.exe  $PSVersionTable.PSVersion";
//        // Executing the command
//        Process powerShellProcess = Runtime.getRuntime().exec(command);
//        // Getting the results
//        powerShellProcess.getOutputStream().close();
//        String line;
//        System.out.println("Standard Output:");
//        BufferedReader stdout = new BufferedReader(new InputStreamReader(
//                powerShellProcess.getInputStream()));
//        while ((line = stdout.readLine()) != null) {
//            System.out.println(line);
//        }
//        stdout.close();
//        System.out.println("Standard Error:");
//        BufferedReader stderr = new BufferedReader(new InputStreamReader(
//                powerShellProcess.getErrorStream()));
//        while ((line = stderr.readLine()) != null) {
//            System.out.println(line);
//        }
//        stderr.close();
//        System.out.println("Done");
//
//    }

}
