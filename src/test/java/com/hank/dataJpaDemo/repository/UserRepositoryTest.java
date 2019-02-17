package com.hank.dataJpaDemo.repository;

import com.hank.dataJpaDemo.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();

    }

    @After
    public void tearDown() {

    }
    @Test
    public void testMethods() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa", "aa@gmail.com", "aa", "aa123456", formattedDate));
        userRepository.save(new User("bb", "bb@gmail.com", "bb", "bb123456", formattedDate));
        userRepository.save(new User("cc", "cc@gmail.com", "cc", "cc123456", formattedDate));


 //       Assert.assertEquals(3,userRepository.findAll().size());
       // Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","cc@gmail.com").getNickName());
 //       Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","bb@gmail.com").getNickName());
  //      userRepository.delete(userRepository.findByUserName("aa1"));
    }


    @Test
    public void testBaseQuery() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

   //     User user = new User("aa","aa@gmail.com","aa","aa12345",formattedDate);

  //      User user = new User("bb","bb@gmail.com","bb","bb12345",formattedDate);
   //     User user = new User("cc","cc@gmail.com","cc","cc12345",formattedDate);
   //     User user = new User("dd","dd@gmail.com","dd","dd12345",formattedDate);

        User user = new User("ee","ee@gmail.com","ee","ee12345",formattedDate);

     //   System.out.println(userRepository.findAll());;
        userRepository.findAll();
        //can't work
      //  userRepository.findOne(11);
        userRepository.save(user);
    //    userRepository.delete(user);
        System.out.println(userRepository.count());;
        //can't work
//        userRepository.exists(1|);

    }

    @Test
    public void testPageQuery(){
        int page = 1, size = 10;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page,size,sort);

        userRepository.findAll(pageable);
        userRepository.findByNickName("aa", pageable);

    }


}