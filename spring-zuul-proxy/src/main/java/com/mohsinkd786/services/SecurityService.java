package com.mohsinkd786.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Objects;

@Service
public class SecurityService {

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    public boolean authenticate(String authorization){
        if(Objects.nonNull(authorization)) {
            String base64Credentials = authorization.substring("Basic ".length());
            // parse base64 string
            byte[] decodedCredentials = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedCredentials);
            final String[] credentialz = credentials.split(":");

            if (adminUsername.equals(credentialz[0]) && adminPassword.equals(credentialz[1])) {
                return true;
            }
            //throw new ZuulException(new Exception("Invalid or no Header specified"),"Invalid Credentials", HttpStatus.FORBIDDEN.value(),null);
        }
        return false;
    }
}
