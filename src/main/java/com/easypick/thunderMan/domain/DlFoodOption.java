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
public class DlFoodOption extends AuditingFields{

    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "dl_food_id")
    private DlFood dlFood;
    @Column(nullable = false, length = 100) private String optionName;
    @Column(nullable = false, length = 11) private int optionPrice;
    @Column(length = 1) private String deleteYn;

    protected DlFoodOption() {};
    public DlFoodOption(DlFood dlFood, String optionName, int optionPrice, String deleteYn) {
        this.dlFood = dlFood;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        this.deleteYn = deleteYn;
    }

    public static DlFoodOption of(DlFood dlFood, String optionName, int optionPrice, String deleteYn) {
        return  new DlFoodOption(dlFood, optionName, optionPrice, deleteYn);
    }

}
