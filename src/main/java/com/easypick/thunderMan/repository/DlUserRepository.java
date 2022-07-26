package com.easypick.thunderMan.repository;

import com.easypick.thunderMan.domain.DlUser;
import com.easypick.thunderMan.domain.QDlUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DlUserRepository extends
        JpaRepository<DlUser, Long>
        , QuerydslPredicateExecutor<DlUser>
        , QuerydslBinderCustomizer<QDlUser>
{

    DlUser findDlUserByUserId(String userId);
    Long findByUserId(String userId);

    @Override
    default void customize(QuerydslBindings bindings, QDlUser root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.userId);

    }


}
