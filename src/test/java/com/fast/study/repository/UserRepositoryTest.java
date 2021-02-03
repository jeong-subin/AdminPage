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
        String account = "Test01";
        String  password = "Test01";
        String  status = "REGISTERED";
        String email = "Test01gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }
    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println("-------------------주문묶음------------------");

            System.out.println("수령인 : "+ orderGroup.getRevName());
            System.out.println("수령지 : "+ orderGroup.getRevAddress());
            System.out.println("총금액 : "+ orderGroup.getTotalPrice());
            System.out.println("총수량 : "+ orderGroup.getTotalQuantity());

            System.out.println("-------------------주문상세-----------------");

            orderGroup.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println("파트너사 이름 : " +orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 : " +orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " +orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " +orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " +orderDetail.getStatus());
                System.out.println("도착예정일자 : " +orderDetail.getArrivalDate());

            });


        });

        Assertions.assertNotNull(user);
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
