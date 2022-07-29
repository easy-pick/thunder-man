package com.easypick.thunderMan.repository;


import com.easypick.thunderMan.config.JpaConfig;
import com.easypick.thunderMan.domain.DlUser;
import com.easypick.thunderMan.dto.SignupDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
public class UserRepositoryTest {

    private final UserRepository userRepository;

    public UserRepositoryTest(@Autowired UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @DisplayName("user Select Test")
    @Test
    void giveUserName_whenSelecting_thenWorksFine(){

        // Given
        String userId = "admin1234";

        // When
        DlUser dlUser = userRepository.findDlUserByUserId(userId);

        // Then
        assertThat(dlUser.getPhone()).isEqualTo("01082188000");

    }

    @DisplayName("User 회원가입 Test")
    @Test
    void givenSignUpUserInfo_whenSaving_thenReturnsUserCreate() {


        // Given
        String userId = "testUser1234";
        String password = "testUser1234";
        String email = "test@test.com";
        String phone = "01012345678";
        String nickName = "테스트유저";

        SignupDto signupDto = new SignupDto();

        signupDto.setUserId(userId);
        signupDto.setPassword(password);
        signupDto.setEmail(email);
        signupDto.setPhone(phone);
        signupDto.setNickname(nickName);

        DlUser signUpUser = DlUser.of(signupDto);

        // When

        userRepository.save(signUpUser);
        DlUser user = userRepository.findDlUserByUserId(userId);

        // Then
        System.out.println("user :::::::::: " + user.toString());
        assertThat(user).isEqualTo(signUpUser);

    }

}
