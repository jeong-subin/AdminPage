package com.fast.study.repository;


import com.fast.study.StudyApplicationTests;
import com.fast.study.model.entity.Item;
import com.fast.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Assertions;



import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;


public class UserRepositoryTest extends StudyApplicationTests{
    // Dependency Injection(DI)
    @Autowired

    private UserRepository userRepository;

    @Test
    //따로 쿼리문을 작성하지 않아도 db insert 할수 있음
    public void create(){
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser:"+newUser);

    }
    @Test
    @Transactional
    public void read(){
        Optional<User> user  = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser->{
           selectUser.getOrderDetailList().stream().forEach(detail->{
               Item item = detail.getItem();
               System.out.println(detail.getItem());
           });
        });

    }
    @Test
    @Transactional  //다시롤백됨
    public void update(){
        Optional<User> user  = userRepository.findById(2L);
        user.ifPresent(selectUser->{
         selectUser.setAccount("pppp");
         selectUser.setUpdatedAt(LocalDateTime.now());
         selectUser.setUpdatedBy("update method()");

         userRepository.save(selectUser);
        });
    }
    @Test
    @Transactional //test만하고 실제db에는 지워지지않음
    public void delete(){
        Optional<User> user  = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });
        //select
        Optional<User> deleteUser  = userRepository.findById(1L);

        Assertions.assertFalse(deleteUser.isPresent());
    }


}
