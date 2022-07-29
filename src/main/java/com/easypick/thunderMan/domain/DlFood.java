package com.easypick.thunderMan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(indexes = {
        @Index(columnList = "id")
})
public class DlFood extends AuditingFields{

    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "dlFood", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<DlFoodOption> dlFoodOption = new LinkedHashSet<>();

    @Setter @ManyToOne(optional = false) private DlStore storeId;

    @Column(nullable = false, length = 100) private String foodName;
    @Column(nullable = false, length = 11) private int foodPrice;
    @Column(length = 200) private String foodDec;
    @Column(length = 200) private String foodImg;
    @Column(length = 200) private String foodThumb;

}