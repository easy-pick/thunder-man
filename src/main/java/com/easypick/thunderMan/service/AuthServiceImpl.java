package com.easypick.thunderMan.service;

import com.easypick.thunderMan.domain.DlUser;
import com.easypick.thunderMan.dto.SignupDto;
import com.easypick.thunderMan.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class AuthServiceImpl implements AuthService {


    @Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Transactional
	public Map<String, String> validHandling(Errors errors) {
		Map<String, String> validResult = new HashMap<>();
		for(FieldError error : errors.getFieldErrors()) {
			validResult.put("valid_"+error.getField(), error.getDefaultMessage());
		}
		return validResult;
	}


	//아이디 중복확인
	@Transactional(readOnly = true)
	public boolean userIdChk(String userId) {
//		return authMapper.usernameChk(userId);
		DlUser dlUser = userRepository.findDlUserByUserId(userId);
		boolean idCheck = false;
		if( dlUser == null ) idCheck = true;
		
		return idCheck;

	}

	//회원가입
    @Transactional
	public void signup(SignupDto signupDto) {

		signupDto.setPassword(passwordEncoder.encode(signupDto.getPassword()));
		DlUser signUser = DlUser.of(signupDto);
		userRepository.save(signUser);
	}



}
