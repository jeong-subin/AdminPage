package com.fast.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor //존재하는 모든생성자를 자동으로 생성
@NoArgsConstructor //파라매터가없는 생성자 생성
@Entity  //jpa를 사용해서 테이블과 매핑할 클래스는  @Entity어노태이션을 필수로 분여야 합니다.

public class Item {
    @Id //db 테이블에 PK를 명시하는 것
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 주키의 값을 위한 자동 생성 전략명시
    private Long id;
    private String status;
    private String name;
    private String title;
    private String content;
    private Integer price;
    private String brandName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Long partnerId;

    //1:n
    //Lazy = 지연로딩(1:n), EAGER = 즉시로딩(1:1)에 추천
    //LAZY = select * from item where id = ?
    //EAGER =
    //item_id = order_detail.item_id
    //user_id = order_detail.user_id
    //where item.id= ?
    // item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id

}
