package com.fast.study.repository;

import com.fast.study.model.entity.Item;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// 해당 클래스가 DAO라는 것을 알리기 위해서 wjrdjwnsek
public interface ItemRepository  extends JpaRepository<Item,Long> {
}
