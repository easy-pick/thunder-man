package com.easypick.thunderMan.service;

import com.easypick.thunderMan.domain.DlUser;
import com.easypick.thunderMan.dto.SignupDto;
import com.easypick.thunderMan.repository.DlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
    DlUserRepository dlUserRepository;

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
	public long userIdChk(String userId) {
//		return authMapper.usernameChk(userId);
		DlUser dlUser = dlUserRepository.findDlUserByUserId(userId);
		long idCheck = dlUserRepository.count();
		return idCheck;
	}

	//회원가입
    @Transactional
	public void signup(SignupDto signupDto) {
		String encPassword = bCryptPasswordEncoder.encode(signupDto.getPassword());
		signupDto.setPassword(encPassword);
		DlUser signUser = DlUser.of(signupDto);
		dlUserRepository.save(signUser);
	}

}
