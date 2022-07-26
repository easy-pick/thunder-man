package com.easypick.thunderMan.repository;


import com.easypick.thunderMan.config.JpaConfig;
import com.easypick.thunderMan.domain.DlUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
public class DlUserRepositoryTest {

    private final DlUserRepository dlUserRepository;

    public DlUserRepositoryTest(@Autowired DlUserRepository dlUserRepository ){

        this.dlUserRepository = dlUserRepository;
    }

    @DisplayName("user Select Test")
    @Test
    void giveUserName_whenSelecting_thenWorksFine(){

        // Given
        String userId = "admin1234";

        // When
        DlUser dlUser = dlUserRepository.findDlUserByUserId(userId);

        // Then
        assertThat(dlUser.getPhone()).isEqualTo("01082188000");

    }



}
