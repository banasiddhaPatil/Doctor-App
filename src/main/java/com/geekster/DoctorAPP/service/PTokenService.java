package com.geekster.DoctorAPP.service;

import com.geekster.DoctorAPP.model.AuthenticationToken;
import com.geekster.DoctorAPP.model.dto.AuthenticationInputDto;
import com.geekster.DoctorAPP.repository.IPTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PTokenService {

    @Autowired
    IPTokenRepo ipTokenRepo;

    public void createToken(AuthenticationToken token) {
        ipTokenRepo.save(token);
    }

    public void deleteToken(String tokenValue) {

        AuthenticationToken token =  ipTokenRepo.findFirstByTokenValue(tokenValue);
        ipTokenRepo.delete(token);

    }

    public boolean authenticate(AuthenticationInputDto authInfo) {

        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        //find thr actual token -> get the connected patient -> get its email-> verify with passed email

        //return ipTokenRepo.findFirstByTokenValue(tokenValue).getPatient().getPatientEmail().equals(email);

        AuthenticationToken token =  ipTokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getPatient().getPatientEmail().equals(email);
        }
        else
        {
            return false;
        }

    }
}
