package com.easypick.thunderMan.repository;

import com.easypick.thunderMan.domain.DlFood;
import com.easypick.thunderMan.domain.QDlFood;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface FoodRepository extends
        JpaRepository<DlFood, Long>
        , QuerydslPredicateExecutor<DlFood>
        , QuerydslBinderCustomizer<QDlFood> {

    Slice<DlFood> findByDlStoreId(Long DlStoreId);



    @Override
    default void customize(QuerydslBindings bindings, QDlFood root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.foodName);

    }


}
