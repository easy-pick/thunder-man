package com.easypick.thunderMan.service;

import com.easypick.thunderMan.dto.SignupDto;
import org.springframework.validation.Errors;

import java.util.Map;

public interface AuthService {

    public Map<String, String> validHandling(Errors errors);
    public boolean userIdChk(String userId);
    public void signup(SignupDto signupDto);

}
