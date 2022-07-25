package com.easypick.thunderMan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "orderNum")
})
public class DlOrderDetail {

    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) private DlOrder dlOrder; 
    @Column(length = 2000) private String foodInfo;

}