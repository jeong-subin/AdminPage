package com.fast.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"orderGroup"})
@Entity//==table
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)

//java는 camelCase db snake_case
//etity 이름 table 이름이랑 같게
public class User {
    //snake_case를 쓰지 않아도 자동으로 jpa에서 매칭해줌

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    private String status;
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
 @CreatedDate
 private LocalDateTime createdAt;

 @CreatedBy
 private String createdBy;

 @LastModifiedDate
 private LocalDateTime updatedAt;

 @LastModifiedBy
 private String updatedBy;


 //User 1 : N OrderGroup
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;


}
