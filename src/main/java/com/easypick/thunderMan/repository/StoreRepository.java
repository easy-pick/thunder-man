package com.easypick.thunderMan.repository;

import com.easypick.thunderMan.domain.DlStore;
import com.easypick.thunderMan.domain.QDlStore;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface StoreRepository extends
        JpaRepository<DlStore, Long>
        , QuerydslPredicateExecutor<DlStore>
        , QuerydslBinderCustomizer<QDlStore> {

    Slice<DlStore> findByCategory(Long categoryId);



    @Override
    default void customize(QuerydslBindings bindings, QDlStore root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.storeName);

    }


}
