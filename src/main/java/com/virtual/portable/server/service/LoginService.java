package com.virtual.portable.server.service;

import com.virtual.portable.server.model.Credentials;
import com.virtual.portable.server.model.DummyUsers;
import com.virtual.portable.server.model.GeneralResponseObject;
import org.springframework.stereotype.Service;
import se.vidstige.jadb.JadbException;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginService {

    private DummyUsers dummyUsers;


    public boolean processCredentials(Credentials credentials) throws IOException, JadbException, NoSuchAlgorithmException {

        GeneralResponseObject isExistCredentials = verifyCredentials(credentials);


        //Todo : connect the user to his allocated virtaul machine

        if (isExistCredentials.getResponseCode() == 1) {

            // To generate session key
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String hashString = (credentials.getUserName() + credentials.getPassword() + System.currentTimeMillis());
            byte[] hashCode = messageDigest.digest(hashString.getBytes());
            BigInteger no = new BigInteger(1, hashCode);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            dummyUsers.getUsers().get(credentials.getUserName()).setSessionKey(hashtext);
        }

        return isExistCredentials.getResponseCode() == 1;

    }

    public GeneralResponseObject verifyCredentials(Credentials credentials) {

        boolean isExistUser = (dummyUsers.getUsers().get(credentials.getUserName()) != null) ?
                dummyUsers.getUsers().get(credentials.getUserName())
                        .equals(credentials.getPassword()) &&
                        dummyUsers.getUsers().get(credentials.getUserName()).getSessionKey() == null : false;

        if (isExistUser)
            return new GeneralResponseObject(1, " User verified !");

        return new GeneralResponseObject(0, " User name or password is incorrect!!");


    }
}
