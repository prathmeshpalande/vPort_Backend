package com.virtual.portable.server.service;

import com.virtual.portable.server.model.Credentials;
import com.virtual.portable.server.model.DummyUsers;
import com.virtual.portable.server.model.GeneralResponseObject;
import org.springframework.stereotype.Service;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;
import sun.font.CreatedFontTracker;

import java.io.IOException;
import java.util.List;

@Service
public class LoginService {

    private DummyUsers dummyUsers;


    public boolean processCredentials(Credentials credentials) throws IOException, JadbException {

        GeneralResponseObject isExistCredentials = verifyCredentials(credentials);


        //Todo : connect the user to his allocated virtaul machine

        return isExistCredentials.getResponseCode() == 1;

    }

    public GeneralResponseObject verifyCredentials(Credentials credentials) {

        boolean isExistUser = (dummyUsers.getUsers().get(credentials.getUserName()) != null) ?
                dummyUsers.getUsers().get(credentials.getUserName())
                        .equals(credentials.getPassword()) : false;

        if(isExistUser)
            return new GeneralResponseObject(1, " User verified !");

        return new GeneralResponseObject(0, " User name or password is incorrect!!");


    }
}
