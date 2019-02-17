package com.hank.dataJpaDemo.repository;

import com.hank.dataJpaDemo.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class UserDetailsRepositoryTest {
    @Resource
    private UserDetailsRepository userDetailsRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUserInfo(){
/*
       List<UserInfo> userInfos = userDetailsRepository.findUserInfo("打球");
        for(UserInfo userInfo:userInfos){
            System.out.println("address"+ userInfo.getAddress());
        }
        */


    }
}