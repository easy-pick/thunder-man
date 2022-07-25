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
        @Index(columnList = "id"),
        @Index(columnList = "foodId")
})
public class DlFoodOption {

    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) private DlFood dlFood;
    @Column(nullable = false, length = 100) private String optionName;
    @Column(nullable = false, length = 11) private int optionPrice;

}