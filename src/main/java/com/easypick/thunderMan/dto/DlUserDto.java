package com.easypick.thunderMan.dto;

import com.easypick.thunderMan.domain.DlUser;

import java.time.LocalDateTime;

public  record DlUserDto(
        String userId,
        String userPassword,
        String email,
        String nickname,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static DlUserDto of(String userId, String userPassword, String email, String nickname) {
        return new DlUserDto(userId, userPassword, email, nickname, null, null, null, null);
    }

    public static DlUserDto of(String userId, String userPassword, String email, String nickname, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new DlUserDto(userId, userPassword, email, nickname, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static DlUserDto from(DlUser entity) {
        return new DlUserDto(
                entity.getUserId(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public DlUserDto toEntity() {
        return DlUserDto.of(
                userId,
                userPassword,
                email,
                nickname
        );
    }

}