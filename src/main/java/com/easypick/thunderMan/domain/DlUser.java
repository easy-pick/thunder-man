package com.easypick.thunderMan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(indexes = {
        @Index(columnList = "id")
})
public class DlUser extends AuditingFields {

    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100) private String userId;
    @Column(nullable = false, length = 100) private String password;
    @Column(length = 45) private String email;
    @Column(length = 45) private String nickname;
    @Column(length = 11) private int point;
    @Column(length = 45) private String phone;
    @Column(length = 45) private String rating;
    @Column(columnDefinition = "varchar(45) default 'ROLE_USER'") private String role;

    protected DlUser() {

    }

    // insert query 실행 전 default value 값 처리를 위하여 작성
    @PrePersist
    public void prePersist(){
        this.role = this.role == null ? "ROLE_USER" : this.role;
    }




    public DlUser(String userId, String password, String email, String nickname, String phone){
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;

    }

    public static DlUser of(String userId, String password, String email, String nickname, String phone){

        return new DlUser(userId, password, email, nickname, phone);
    }


}