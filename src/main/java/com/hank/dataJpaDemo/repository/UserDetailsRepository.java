package com.hank.dataJpaDemo.repository;

import com.hank.dataJpaDemo.entity.UserDetails;
import com.hank.dataJpaDemo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    @Query("select u.userName as userName, u.email as email, d.address as address, d.hobby as hobby from User u, UserDetails d "
    + "where u.id = d.userId and hobby = ?1")
    List<UserInfo> findUserInfo(String hobby);

/*
    @Query("SELECT u FROM  UserEntity u WHERE u.tenantId = :tenantId" +
    "AND u.customerId = :customerId AND u.authority = :authority"+
    "AND LOWER(u.searchText) LIKE LOWER(CONCAT(:searchText,'%'))"+
    "AND u.id> :idOffset ORDER BY u.id")
    List<UserEntity> findUserByAuthority(@Param("tenantId") String tenantId,
                                         @Param("customerId") String customerId,
                                         @Param("idOffset") String idOffset,
                                         @Param("searchText") String searchText,
                                         @Param("authority") String authority,
                                         Pageable pageable);
                                         */


}
