package com.hank.dataJpaDemo.repository;

import com.hank.dataJpaDemo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);

/*
    User findFirstByOrderByLastNameAsc();
    User findTopByOrderByAgeDesc();
    Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
    List<User> findFirst10ByLastname(String lastname, Sort sort);
    List<User> findTop10ByLastname(String lastname, Pageable pageable);
*/

    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);
    Page<User> findByNickName(String nickName, Pageable pageable);






    List<User> findByEmailLike(String email);
    User findByUserNameIgnoreCase(String userName);
    List<User> findByUserNameOrderByEmailDesc(String email);

    /*
    @Transactional(timeout = 10)
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteById(Long id);


    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

*/




}